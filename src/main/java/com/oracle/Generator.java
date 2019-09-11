package com.oracle;

import java.util.ArrayList;

public class Generator {

	public void run() {
		ArrayList<Thread> workers = new ArrayList<>();

		try {
			for (int i = 0; i < Parameters.getThreads(); i++) {
				Thread worker = new Thread(new Worker());
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
