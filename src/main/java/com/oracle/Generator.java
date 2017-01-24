package com.oracle;

import java.util.ArrayList;

public class Generator {

	private final String  restURL;
	private final Integer threads;
	private final Integer wait;
	private final String jdbc;
	private final boolean staticData;
	private final boolean historyData;
	
	public Generator(String restURL, Integer threads, Integer wait, String jdbc, boolean staticData, boolean historyData) {
		this.restURL = restURL;
		this.threads = threads;
		this.wait = wait;
		this.jdbc = jdbc;
		this.staticData = staticData;
		this.historyData = historyData;

	}
	
	public void run() {
		ArrayList<Thread> workers = new ArrayList<Thread>();
		
		for (int i=0; i<threads.intValue(); i++) {
			Thread worker = new Thread(new Worker(restURL, wait, jdbc, staticData, historyData));
			worker.start();
			workers.add(worker);
		}
	}
}
