package com.controllers.service.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTimeBeans extends Thread {

	static CurrentTimeBeans instance;
	String currentTime1;

	public static CurrentTimeBeans getInstance() {
		if (instance == null) {
			instance = new CurrentTimeBeans();
		}
		return instance;
	}

	public void setCurrentTime(String currentTime) {
		currentTime1 = currentTime;
	}

	public String getCurrentTime() {
		return currentTime1;
	}

	public void run() {

		new Thread() {
			@Override
			public void run() {
				super.run();
				while (true) {
					String data = new SimpleDateFormat("HH:mm").format(new Date());
					setCurrentTime(data);
					Thread.yield();
					try {
						Thread.sleep(60000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();

	}

}
