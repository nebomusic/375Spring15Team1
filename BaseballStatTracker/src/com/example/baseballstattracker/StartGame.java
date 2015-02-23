package com.example.baseballstattracker;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class StartGame extends Activity {
	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_startgame);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startgame);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void handleClick(View v) {
		switch (v.getId()) {
			case R.id.buttonStartGameBack:
				Intent intentOne = new Intent(this, MainActivity.class);
				startActivity(intentOne);
				break;
			case R.id.buttonStartGame:
				Intent intentTwo = new Intent(this, InGame.class);
				startActivity(intentTwo);
				break;
		}
		
	}
	
//Classes for Date and Time Pickers 
	//from research from: http://developer.android.com/guide/topics/ui/controls/pickers.html
	
	public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
		//Fields for date
		private int month;
		private int day;
		private int yr;
		private Button btnSelectDate;
		
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			//Use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			
			//Create a new instance of DatePickerDialog and return it
			return new DatePickerDialog(getActivity(), this, year, month, day);
		}
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {	
			btnSelectDate = (Button)findViewById(R.id.buttonSelectDate);
			yr = year;
			month = monthOfYear;
			day = dayOfMonth;
			
			btnSelectDate.setText(month + "/" + day + "/" + yr);
			
		}
		
		public String getDate() {
			return String.valueOf(month + "/" + day + "/" + yr);
		}
		
	}
	
	//When btnSelectDate is clicked
	public void showDatePickerDialog(View v) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getFragmentManager(), "datePicker");
	}
	
	public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
		//Fields for date
		private int hr;
		private int min;
		private Button btnSelectTime;

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			//Use the current time as the default values for the picker
			final Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			
			//Create a new instance of TimePickerDialog and return it
			return new TimePickerDialog(getActivity(), this, hour, minute, 
					DateFormat.is24HourFormat(getActivity()));
		}
		
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			btnSelectTime = (Button)findViewById(R.id.buttonSelectTime);
			hr = hourOfDay;
			min = minute;
			if (min > 10) {btnSelectTime.setText(hr + ":" + min);}
			else {btnSelectTime.setText(hr + ":0" + min);}
		}
		
		public String getTime() {
			if (min > 10) {return String.valueOf(hr + ": " + min);}
			else {return String.valueOf(hr + ": 0" + min);}
		}

	}
	
	//When btnSelectTime is clicked
	public void showTimePickerDialog(View v) {
		DialogFragment newFragment = new TimePickerFragment();
		newFragment.show(getFragmentManager(), "timePicker");
	}
}
