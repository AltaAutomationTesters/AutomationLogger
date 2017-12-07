package com.controllers.service.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTimeBeans extends Thread {

	
	static CurrentTimeBeans instance;
	private String currentTime;
	
	public static CurrentTimeBeans getInstance() {
		if(instance == null) {
		   instance = new CurrentTimeBeans();
		}
		return instance;
	}
	
	public void setCurrentTime(String currentTime) {
		currentTime = currentTime;
	}
	
	public String getCurrentTime() {
		return currentTime;
	}
	
	public void run() {
		
		while (true)
        {
            String data = new SimpleDateFormat("HH:mm").format(new Date());
            setCurrentTime(data);
            Thread.yield();
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
		//return new SimpleDateFormat("HH:mm").format(new Date());
	}
	
	
	
}

