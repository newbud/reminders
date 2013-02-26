package com.newbud.reminder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.newbud.reminder.service.WaterReminderService;

public class SetReminder extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setupUIControls();
    }
    
    private void setupUIControls(){
    	final Spinner hourControl = (Spinner) findViewById(R.id.hour);
    	ArrayAdapter<Integer> hourAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_item);
    	hourControl.setAdapter(hourAdapter);
    	for(int i = 1; i < 25; i++){
    		hourAdapter.add(i);
    	}
    	
    	final Spinner minuteControl = (Spinner) findViewById(R.id.minute);
    	ArrayAdapter<Integer> minuteAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_item);
    	minuteControl.setAdapter(minuteAdapter);
    	for(int i = 1; i < 61; i++){
    		minuteAdapter.add(i);
    	}
    	
    	final Spinner frequencyControl = (Spinner) findViewById(R.id.frequency);
    	
    	ArrayAdapter<Integer> frequencyAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_spinner_item);
    	frequencyControl.setAdapter(frequencyAdapter);
    	for(int i = 1; i < 25; i++){
    		frequencyAdapter.add(i);
    	}
    	
    	final Spinner unit = (Spinner) findViewById(R.id.frequencyunit);
    	ArrayAdapter<String> unitAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item);
    	unit.setAdapter(unitAdapter);
    	unitAdapter.add("Hour");
    	unitAdapter.add("Minute");
    	
    	final Button saveButton = (Button) findViewById(R.id.save);
    	
    	saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*if(((CheckBox) findViewById(R.id.onoff)).isChecked()){
                	Date currentTime = new Date();
                	int currentHour = currentTime.getHours();
                	int currentMinute = currentTime.getMinutes();
                	int initialStartHour = (Integer)hourControl.getSelectedItem();
                	int initialStartMinute = (Integer) minuteControl.getSelectedItem();
                	int delayInMillisecond = (Math.abs(currentHour - initialStartHour)*60 + Math.abs(currentMinute - initialStartMinute))*60*1000;
                	int frequency = (Integer) frequencyControl.getSelectedItem();
                	String frequencyUnit = (String) unit.getSelectedItem();
                	if(frequencyUnit.equalsIgnoreCase("hour")){
                		frequency = frequency * 60 * 60 * 1000;
                	}
                	else{
                		frequency = frequency * 60 * 1000;
                	}
                	
                	Bundle intentBundle = new Bundle();
                	intentBundle.putInt("delayInMs", delayInMillisecond);
                	intentBundle.putInt("frequencyInMs", frequency);
                	Intent startServiceIntent = new Intent(SetReminder.this, WaterReminderService.class);
                	startServiceIntent.putExtras(intentBundle);
                	startService(startServiceIntent);
                	
                	
    			}*/
            	Intent startServiceIntent = new Intent(SetReminder.this, WaterReminderService.class);
            	//startServiceIntent.putExtras(intentBundle);
            	startService(startServiceIntent);
            }
        });
    }
}