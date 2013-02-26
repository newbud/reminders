package com.newbud.reminder.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

public class WaterReminderService extends Service{
	
	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	NotificationManager mNotificationManager;
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		/*if(!executor.isShutdown()){
			executor.shutdownNow();
		}*/
		
		Bundle parameters = intent.getExtras();
		//int delayInMs = parameters.getInt("delayInMs");
		//int frequencyInMs = parameters.getInt("frequencyInMs");
		
		int delayInMs = 5;
		int frequencyInMs = 3*1;
		
		if(delayInMs != 0 && frequencyInMs != 0){
			Logger.getLogger("foo").info("starting notification runner");
			executor.scheduleAtFixedRate(new NotifyRunner(mNotificationManager), delayInMs, frequencyInMs, TimeUnit.MILLISECONDS);
		}
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
    public void onDestroy() {
		Logger.getLogger("foo").info("stopping notification runner");
        executor.shutdownNow();
        
    }
	
}
