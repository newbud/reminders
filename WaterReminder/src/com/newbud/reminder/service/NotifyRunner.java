package com.newbud.reminder.service;

import java.util.logging.Logger;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Color;

import com.newbud.reminder.R;

public class NotifyRunner implements Runnable{

	private final NotificationManager mNotificationManager;
	
	public NotifyRunner(NotificationManager notificationManager){
		mNotificationManager = notificationManager;
	}
	
	
	@Override
	public void run() {
		Logger.getLogger("notifyrunner").info("Inside run");
		sendNotification();
		
	}

	private void sendNotification() {
	    Logger.getLogger("notifyrunner").info("Sending notification now...");
		final Notification notify = new Notification(R.drawable.icon, "Reminder on..", System.currentTimeMillis());

	    notify.icon = R.drawable.icon;
	    notify.tickerText = "Reminder on..";
	    notify.when = System.currentTimeMillis();
	    notify.number = 1;
	    notify.flags |= Notification.FLAG_AUTO_CANCEL;
	    notify.defaults |= Notification.DEFAULT_SOUND;

	    // add lights
        notify.flags |= Notification.FLAG_SHOW_LIGHTS;
        notify.ledARGB = Color.CYAN;
        notify.ledOnMS = 500;
        notify.ledOffMS = 500;
   

	    notify.vibrate = new long[] {100, 200, 300};
	    mNotificationManager.notify(1, notify);
	}

}
