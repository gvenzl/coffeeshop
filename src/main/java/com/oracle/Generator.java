package com.oracle;

import java.util.ArrayList;

public class Generator {

	private final String  restURL;
	private final Integer threads;
	private final Integer wait;
	private final String jdbc;
	private final String username;
	private final String password;
	private final String file;
	private final Integer batchSize;
	private final boolean staticData;
	private final boolean historyData;
	private final String credFile;
	
	public Generator(String restURL, Integer threads, Integer wait, 
			String jdbc, String username, String password, String file, Integer batchSize,
			boolean staticData, boolean historyData, String credFile) {
		this.restURL = restURL;
		this.threads = threads;
		this.wait = wait;
		this.jdbc = jdbc;
		this.username = username;
		this.password = password;
		this.file = file;
		this.batchSize = batchSize;
		this.staticData = staticData;
		this.historyData = historyData;
		this.credFile = credFile;
	}
	
	public void run() {
		ArrayList<Thread> workers = new ArrayList<>();

		try {
			for (int i = 0; i < threads; i++) {
				Thread worker = new Thread(new Worker(restURL, wait, jdbc, username, password, file, batchSize, staticData, historyData, credFile));
				worker.start();
				workers.add(worker);
			}

			for (Thread worker : workers) {
				worker.join();
			}
		}
		catch (Exception e) {
			System.out.println("Error occurred, stopping.");
			for (Thread worker : workers) {
				worker.interrupt();
			}
		}
	}
}
