package com.oracle;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.oracle.data.Coffee;
import com.oracle.data.CustomerAndLocation;
import com.oracle.data.StaticData;

public class Worker implements Runnable {

	private Connection conn;
	
	private int batchSize = 0;
	private int waitSec = 0;
	private String restURL;
	private boolean writeFile=false;
	private boolean stop=false;
	private boolean loadDB=false;
	private boolean loadREST=false;
	private PreparedStatement stmt=null;
	private boolean staticData=false;
	private boolean historicData=false;
	private Random random;
	private BufferedWriter bw;
	
	private static final int MAX_ORDERS=5;
	
	public Worker(String restURL, Integer waitSec, String jdbc, String file, boolean staticData, boolean historicData) {
		this.waitSec = waitSec.intValue();
		this.restURL = restURL;
		this.staticData = staticData;
		this.historicData = historicData;
		this.random = new Random();
		
		if (!file.isEmpty()) {
			writeFile = true;
			
			try {
				bw = new BufferedWriter(new FileWriter(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (null != jdbc) {
			loadDB = true;
			try {
				conn = CloudConnectionManager.getConnection(new File("/Users/gvenzl/Documents/coffeeshop/client_credentials_Maria.zip"), "coffeeshop", "coffeeshop", "dbaccess");
				conn.setAutoCommit(false);
				// Write into sales history table rather than sales
				if (this.historicData) {
					stmt = conn.prepareStatement("INSERT INTO ORDERS_HISTORY (order_details) VALUES(?)");
				}
				else {
					stmt = conn.prepareStatement("INSERT INTO ORDERS (order_details) VALUES(?)");
				}
			} catch (SQLException | IOException e) {
				System.out.println("Bugger!");
				System.out.println(e.getMessage());
			}
		}
		
		loadREST = !restURL.isEmpty();
	}
	
	private String generateDate() {
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setTimeZone(tz);
		return " \"date\": \"" + df.format(getDate()) + "\"";
	}
	
	private Date getDate() {
		// If history 
		if (historicData) {
			return generateHistoricDate();
		}
		else {
			return getCurrentDate();
		}
	}
	
	private Date getCurrentDate() {
		return new Date();
	}
	
	private Date generateHistoricDate() {
		return new Date(new Date().getTime() + (random.nextInt(365) *24 *3600 * 1000l ));
	}
	
	private String generateLocation() {
		return CustomerAndLocation.getCustomerAndLocation();
	}
	
	private String generateStatic() {
		return StaticData.getStaticData(staticData);
	}
	
	private String generateOrders() {
		
		double salesTotal = 0.0;
		String order = "\"order\": [";
		Coffee coffeeSale = new Coffee();
		
		// Get random number of orders
		int orders = new Random().nextInt(MAX_ORDERS) + 1;
		
		for (int i=0;i<orders;i++) {
			Coffee.CoffeeEntry coffee = coffeeSale.getCoffee();
			order = order + coffee.coffee + ",";
			salesTotal += coffee.salesAmount;
		}
		
		// Round to 2 digits after the comma
		DecimalFormat df = new DecimalFormat("###.##");
		
		return  "  \"salesAmount\": " + df.format(salesTotal) + ",\n  " +
		              order.substring(0, order.length()-1) + "]";
	}
	
	private String generateSale() {
		return "{\n" +
				generateStatic() + ",\n" +
				generateDate() + ",\n" +
				generateLocation() + ",\n" +
				generateOrders() + "\n}";
	}
	
	@Override
	public void run() {
		Random random = new Random();
		while (!stop) {
			loadData();
			try {
				if (waitSec > 0 ) {
					int sleep = random.nextInt(waitSec);
					Thread.sleep(sleep*1000);
				}
			} catch (InterruptedException e) {
				stop=true;
			}
		}
	}
	
	private void loadData() {
		String order = generateSale();
		if (writeFile) {
			writeIntoFile(order);
		}
		
		if (loadDB) {
			loadDataIntoDB(order);
		}
		
		if (loadREST) {
			loadRest(order);
		}
	}
	
	private void writeIntoFile(String order) {
		try {
			bw.write(order.replaceAll("\n", "").replaceAll("\r", "").replaceAll("  ", "") + "\n");
		} catch (IOException e) {
			System.out.println("Can't write file.");
			System.out.println(e.getMessage());
		}
	}
	
	private void loadDataIntoDB(String data) {
		try {
			batchSize = batchSize + 1;
			stmt.setBlob(1, new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8)));
			stmt.addBatch();
			if (batchSize == 100) {
				stmt.executeBatch();
				conn.commit();
				batchSize = 0;
			}
			
		} catch (SQLException e) {
			System.out.println("Good try, but not good enough!");
			System.out.println(e.getMessage());
		}
		
	}
	
	private void loadRest(String data) {
		
		TrustManager[] trustAllCerts = new TrustManager[] { 
			    new X509TrustManager() {     
			        public java.security.cert.X509Certificate[] getAcceptedIssuers() { 
			            return new X509Certificate[0];
			        } 
			        public void checkClientTrusted( 
			            java.security.cert.X509Certificate[] certs, String authType) {
			            } 
			        public void checkServerTrusted( 
			            java.security.cert.X509Certificate[] certs, String authType) {
			        }
			    } 
			}; 
	
		try {
			SSLContext ctx = SSLContext.getInstance("SSL");
			ctx.init(null, trustAllCerts, new java.security.SecureRandom()); 
		    HttpsURLConnection.setDefaultSSLSocketFactory(ctx.getSocketFactory());
			
			CloseableHttpClient client = HttpClients.custom().setSSLContext(ctx).setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
			HttpPost post = new HttpPost(restURL);
			post.setEntity(
				new StringEntity(data,
						ContentType.create("application/json", "UTF-8")));

			HttpResponse response = client.execute(post);
			if (response.getStatusLine().getStatusCode() >= 400) {
				System.out.println("REST service not available: " + response.getStatusLine());
			}
			else {
				System.out.println("Data successfully posted!");
			}
		} catch (Exception e) {
			System.out.println("Error on calling REST: " + e.getMessage());
		}
	}
	
	void stop() {
		stop=true;
	}

}
