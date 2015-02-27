package com.example.baseballstattracker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class StartGame extends Activity {
	
	//Fields for Start Game
	private Spinner spinnerSelectTeam;
	private boolean isHome = true;
	public List <String> gamedata;
	
	//Fields for In Game
	private Button btnInGameBack;
	private TextView textTeam;
	private TextView textGameInfo;
	private Spinner spinnerPlayer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startgame);
	
		//Start Game XML
		//Populate Spinner
		spinnerSelectTeam = (Spinner)findViewById(R.id.spinnerSelectTeam);
						
		ArrayAdapter<CharSequence> teamAdapter = ArrayAdapter.createFromResource(this, 
						R.array.team_array, android.R.layout.simple_spinner_dropdown_item); 
		teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerSelectTeam.setAdapter(teamAdapter);
		
		//Populate List with Generic Data
		gamedata = new ArrayList <String> (0);
		gamedata.add("Team");
		gamedata.add("Home");
		gamedata.add("Select Date");
		gamedata.add("Select Time");
		gamedata.add("Enter Location");
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
	
	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_startgame);
		
		//Spinner
		spinnerSelectTeam = (Spinner)findViewById(R.id.spinnerSelectTeam);
				
		ArrayAdapter<CharSequence> teamAdapter = ArrayAdapter.createFromResource(this, 
				R.array.team_array, android.R.layout.simple_spinner_dropdown_item); 
		teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerSelectTeam.setAdapter(teamAdapter);
			
		//Fill Spots with Prior Data
		Button btnSelectDate = (Button)findViewById(R.id.buttonSelectDate);
		Button btnSelectTime = (Button)findViewById(R.id.buttonSelectTime);
		EditText editLocation = (EditText)findViewById(R.id.editLocation);
		btnSelectDate.setText(gamedata.get(2).toString());
		btnSelectTime.setText(gamedata.get(3).toString());
		editLocation.setText(gamedata.get(4).toString());
		
	}
	
	public void handleRadioClick(View v) {
		boolean checked = ((RadioButton) v).isChecked();
				
		//Which button was clicked
		switch(v.getId()) {
			case R.id.radioHome:
				if (checked) {isHome = true;}
			break;
					
			case R.id.radioAway:
				if (checked) {isHome = false;}
			break;
		}
	}
	
	public void handleClick(View v) {
		switch (v.getId()) {
			case R.id.buttonStartGameBack:
				Intent intentOne = new Intent(this, MainActivity.class);
				startActivity(intentOne);
				break;
			case R.id.buttonInGameBack:
				setContentView(R.layout.activity_startgame);
				onResume();
				break;
			case R.id.buttonInGameStart:
				setGameInfo();
				setContentView(R.layout.activity_in_game);
				launchInGame();
				break;
		}
		
	}
	
	public void setGameInfo() {
		//Populate GameData List
			gamedata = new ArrayList <String> (0);
			//Add Team - 0
			String team = String.valueOf(spinnerSelectTeam.getSelectedItem());
			gamedata.add(team);
						
			//Add Home or Away - 1
			if (isHome == true) {gamedata.add("Home");}
			else {gamedata.add("Away");}
								
			//Add Date - 2 
			Button btnSelectDate = (Button)findViewById(R.id.buttonSelectDate);
			String date = btnSelectDate.getText().toString();
			gamedata.add(date); 
					
			//Add Time - 3
			Button btnSelectTime = (Button)findViewById(R.id.buttonSelectTime);
			String time = btnSelectTime.getText().toString();
			gamedata.add(time);
						
			//Add Location - 4
			EditText editLocation = (EditText)findViewById(R.id.editLocation);
			String location  = editLocation.getText().toString();
			gamedata.add(location);
	}
	
	public void launchInGame() {
		//In Game XML
        btnInGameBack = (Button)findViewById(R.id.buttonInGameBack);
        textTeam = (TextView)findViewById(R.id.textTeam);
                
        //Set the First Line to the current game info
      	textTeam = (TextView)findViewById(R.id.textTeam);
      	String firstLine = gamedata.get(0).toString() + " - " + gamedata.get(1).toString();
      	textTeam.setText(firstLine);
        //Set the Second Line to the current game info
      	textGameInfo = (TextView)findViewById(R.id.textGameInfo);
      	String secondLine = gamedata.get(2).toString() + " at " + gamedata.get(3).toString() + " at "+ gamedata.get(4).toString();
      	textGameInfo.setText(secondLine);
      	
      //In Game Player Spinner
      spinnerPlayer = (Spinner)findViewById(R.id.spinnerPlayer);
      				
      ArrayAdapter<CharSequence> playerAdapter = ArrayAdapter.createFromResource(this, 
      			R.array.player_array, android.R.layout.simple_spinner_dropdown_item); 
      playerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      spinnerPlayer.setAdapter(playerAdapter);

	}
		
//Classes for Date and Time Pickers 
	//from research from: http://developer.android.com/guide/topics/ui/controls/pickers.html
	
	public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
		//Fields for date
		private int month;
		private int day;
		private int yr;
		
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
			Button btnSelectDate = (Button)findViewById(R.id.buttonSelectDate);
			yr = year;
			month = monthOfYear;
			day = dayOfMonth;
			
			btnSelectDate.setText(month + "/" + day + "/" + yr);
			
			//Show Toast
			Context context = getApplicationContext();
			CharSequence text = "Date Selected";
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
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
			Button btnSelectTime = (Button)findViewById(R.id.buttonSelectTime);
			hr = hourOfDay;
			min = minute;
			if (min > 10) {btnSelectTime.setText(hr + ":" + min);}
			else {btnSelectTime.setText(hr + ":0" + min);}

			//Show Toast
			Context context = getApplicationContext();
			CharSequence text = "Time Selected";
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		}
	}
	
	//When btnSelectTime is clicked
	public void showTimePickerDialog(View v) {
		DialogFragment newFragment = new TimePickerFragment();
		newFragment.show(getFragmentManager(), "timePicker");
	}
}
