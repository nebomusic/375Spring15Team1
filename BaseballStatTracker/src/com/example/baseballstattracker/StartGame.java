package com.example.baseballstattracker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class StartGame extends Activity {
	
	//Fields for Start Game
	private Spinner spinnerSelectTeam;
	private boolean isHome = true;
	public List <String> gamedata;
	private Context c = this;
	//private TeamsDAO teams = new TeamsDAO(c);
	private List<Team>teams;
	private TeamList teamList;
	
	//Fields for In Game
	private boolean isAdd = true;
	private Button btnInGameBack;
	private TextView textTeam;
	private TextView textGameInfo;
	private Spinner spinnerPlayer;
	private List<Player>players;
	private PlayerList playerList;
	private ToggleButton toggleAddSub;
	private Button buttonAB;
	private int AB = 0;
	private Button buttonOneB;
	private int OneB = 0;
	private Button buttonTwoB;
	private int TwoB = 0;
	private Button buttonThreeB;
	private int ThreeB = 0;
	private Button buttonHR;
	private int HR = 0;
	private TextView textAB;
	private TextView textOneB;
	private TextView textTwoB;
	private TextView textThreeB;
	private TextView textHR;
	private Button buttonBall;
	private int ball = 0;
	private Button buttonStrike;
	private int strike = 0;
	private Button buttonReset;
	private TextView buttonH;
	private int H = 0;
	private Button buttonK;
	private int K = 0;
	private Button buttonBB;
	private int BB = 0;
	private Button buttonHBP;
	private int HBP = 0;
	private TextView textBall;
	private TextView textStrike;
	private TextView textH;
	private TextView textK;
	private TextView textBB;
	private TextView textHBP;
	private Button buttonPA;
	private int PA = 0;
	private Button buttonSH;
	private int SH = 0;
	private Button buttonSF;
	private int SF = 0;
	private Button buttonSB;
	private int SB = 0;
	private Button buttonGDP;
	private int GDP = 0;
	private Button buttonFC;
	private int FC = 0;
	private Button buttonR;
	private int run = 0;
	private Button buttonRBI;
	private int RBI = 0;
	private Button buttonCS;
	private int CS = 0;
	private Button buttonStB;
	private int StB = 0;
	private TextView textPA;
	private TextView textSH;
	private TextView textSF;
	private TextView textSB;
	private TextView textGDP;
	private TextView textFC;
	private TextView textR;
	private TextView textRBI;
	private TextView textCS;
	private TextView textStB;
	private TextView textBA;
	private int BA = 0;
	private TextView textXBH;
	private int XBH = 0;
	private TextView textTA;
	private int TA = 0;
	private TextView textPASO;
	private int PASO;
	private TextView textSBA;
	private int SBA;
	private TextView textSBP;
	private int SBP;
	private TextView textISO;
	private int ISO = 0;
	private TextView textOBP;
	private int OBP = 0;
	private TextView textTB;
	private int TB = 0;
	private TextView textSLG;
	private int SLG = 0;
	private TextView textTOB;
	private int TOB = 0;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startgame);
	
		//Start Game XML
		//Populate Spinner
		teams = new ArrayList<Team>(0);
		teamList = new TeamList(this);
		spinnerSelectTeam = (Spinner)findViewById(R.id.spinnerSelectTeam);
	
		populateSpinnerTeams();
		
//		ArrayAdapter<String> teamAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, allTeams);
//		teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		spinnerSelectTeam.setAdapter(teamAdapter);
		
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
		teams = new ArrayList<Team>(0);
		teamList = new TeamList(this);
		spinnerSelectTeam = (Spinner)findViewById(R.id.spinnerSelectTeam);
	
		populateSpinnerTeams();
			
		//Fill Spots with Prior Data
		Button btnSelectDate = (Button)findViewById(R.id.buttonSelectDate);
		Button btnSelectTime = (Button)findViewById(R.id.buttonSelectTime);
		EditText editLocation = (EditText)findViewById(R.id.editLocation);
		btnSelectDate.setText(gamedata.get(2).toString());
		btnSelectTime.setText(gamedata.get(3).toString());
		editLocation.setText(gamedata.get(4).toString());

	}
	
	public void handleInGameClick(View v) {
		switch (v.getId()) {
			case R.id.buttonAB:
				textAB = (TextView)findViewById(R.id.textAB);
				if (isAdd){AB++;}
				else{AB--;}
				textAB.setText(String.valueOf(AB));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonOneB:
				textOneB = (TextView)findViewById(R.id.textOneB);
				if (isAdd){OneB++;}
				else{OneB--;}
				textOneB.setText(String.valueOf(OneB));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonTwoB:
				textTwoB = (TextView)findViewById(R.id.textTwoB);
				if (isAdd){TwoB++;}
				else{TwoB--;}
				textTwoB.setText(String.valueOf(TwoB));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonThreeB:
				textThreeB = (TextView)findViewById(R.id.textThreeB);
				if (isAdd){ThreeB++;}
				else{ThreeB--;}
				textThreeB.setText(String.valueOf(ThreeB));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonHR:
				textHR = (TextView)findViewById(R.id.textHR);
				if (isAdd){HR++;}
				else{HR--;}
				textHR.setText(String.valueOf(HR));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonBall:
				textBall = (TextView)findViewById(R.id.textBall);
				if (isAdd){ball++;}
				else{ball--;}
				if (ball > 4) {ball = 0;}
				textBall.setText(String.valueOf(ball));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonStrike:
				textStrike = (TextView)findViewById(R.id.textStrike);
				if (isAdd){strike++;}
				else{strike--;}
				if (strike > 3) {strike = 0;}
				textStrike.setText(String.valueOf(strike));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonReset:
				ball = 0;
				strike = 0;
				textBall.setText(String.valueOf(ball));
				textStrike.setText(String.valueOf(strike));
				updateCalcStats();
			break;
			case R.id.buttonH:
				textH = (TextView)findViewById(R.id.textH);
				if (isAdd){H++;}
				else{H--;}
				textH.setText(String.valueOf(H));
				updateCalcStats();
				updateStatList();
			break;			
			case R.id.buttonK:
				textK = (TextView)findViewById(R.id.textK);
				if (isAdd){K++;}
				else{K--;}
				textK.setText(String.valueOf(K));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonBB:
				textBB = (TextView)findViewById(R.id.textBB);
				if (isAdd){BB++;}
				else{BB--;}
				textBB.setText(String.valueOf(BB));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonHBP:
				textHBP = (TextView)findViewById(R.id.textHBP);
				if (isAdd){HBP++;}
				else{HBP--;}
				textHBP.setText(String.valueOf(HBP));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonPA:
				textPA = (TextView)findViewById(R.id.textPA);
				if (isAdd){PA++;}
				else{PA--;}
				textPA.setText(String.valueOf(PA));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonSH:
				textSH = (TextView)findViewById(R.id.textSH);
				if (isAdd){SH++;}
				else{SH--;}
				textSH.setText(String.valueOf(SH));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonSF:
				textSF = (TextView)findViewById(R.id.textSF);
				if (isAdd){SF++; SH++;}
				else{SF--;}
				textSF.setText(String.valueOf(SF));
				textSH.setText(String.valueOf(SH));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonGDP:
				textGDP = (TextView)findViewById(R.id.textGDP);
				if (isAdd){GDP++;}
				else{GDP--;}
				textGDP.setText(String.valueOf(GDP));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonFC:
				textFC = (TextView)findViewById(R.id.textFC);
				if (isAdd){FC++;}
				else{FC--;}
				textFC.setText(String.valueOf(FC));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonR:
				textR = (TextView)findViewById(R.id.textR);
				if (isAdd){run++;}
				else{run--;}
				textR.setText(String.valueOf(run));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonRBI:
				textRBI = (TextView)findViewById(R.id.textRBI);
				if (isAdd){RBI++;}
				else{RBI--;}
				textRBI.setText(String.valueOf(RBI));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonCS:
				textCS = (TextView)findViewById(R.id.textCS);
				if (isAdd){CS++;}
				else{CS--;}
				textCS.setText(String.valueOf(CS));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonStB:
				textStB = (TextView)findViewById(R.id.textStB);
				if (isAdd){StB++;}
				else{StB--;}
				textStB.setText(String.valueOf(StB));
				updateCalcStats();
				updateStatList();
			break;
			case R.id.buttonEndGame:
				loadGameInfo();
				showYesNoDialog(v);
			break;
		}
	}
	
	//Created with the help of http://stackoverflow.com/questions/2478517/how-to-display-a-yes-no-dialog-box-in-android
	
	public class YesNoFragment extends DialogFragment {

	    @Override
	    public Dialog onCreateDialog(Bundle savedInstanceState) {
	        return new AlertDialog.Builder(getActivity())
	            .setTitle("Confirm")
	            .setMessage("Are You Sure You Want to End the Game?")
	            .setNegativeButton(android.R.string.no, new OnClickListener() {
	                @Override
	                public void onClick(DialogInterface dialog, int which) {
	                    // do nothing (will close dialog)
	                }
	            })
	            .setPositiveButton(android.R.string.yes,  new OnClickListener() {
	                @Override
	                public void onClick(DialogInterface dialog, int which) {
	                	Intent intentOne = new Intent(c, MainActivity.class);
	    				startActivity(intentOne);
	                }
	            })
	            .create();
	    }
	}
	
	public void showYesNoDialog(View v) {
		DialogFragment newFragment = new YesNoFragment();
		newFragment.show(getFragmentManager(), "confirm");
		
	}
	
	private void updateStatList() {
		//Update the public list of data using the SQLite Database		
	}

	private void updateCalcStats() {
		textBA = (TextView)findViewById(R.id.textBA);
		textXBH = (TextView)findViewById(R.id.textXBH);
		textTA = (TextView)findViewById(R.id.textTA);
		textSBA = (TextView)findViewById(R.id.textSBA);
		textSBP = (TextView)findViewById(R.id.textSBP);
		textPASO = (TextView)findViewById(R.id.textPASO);
		textISO = (TextView)findViewById(R.id.textISO);
		textOBP = (TextView)findViewById(R.id.textOBP);
		textTB = (TextView)findViewById(R.id.textTB);
		textSLG = (TextView)findViewById(R.id.textSLG);
		textTOB = (TextView)findViewById(R.id.textTOB);
		
		if (AB == 0) {BA = 0;}
		else {BA = H/AB;}
		XBH = (TwoB + ThreeB + HR);
		if ((AB - H + CS + GDP) == 0) {TA = 0;}
		else{TA = (TB + BB + HBP + SB - CS)/(AB - H + CS + GDP);}
		if (K == 0){PASO = 0;}
		else {PASO = PA/K;}
		SBA = SB+CS;
		if (SBA == 0){SBP = 0;}
		else{SBP = SB/SBA;}
		if (AB == 0) {SLG = 0;}
		else{SLG = TB/AB;}
		ISO = BA-SLG;
		TOB = (H + BB + HBP);
		if ((AB + BB + HBP + SH) == 0){OBP = 0;}
		else{OBP = TOB/(AB + BB + HBP + SH);}
		TB =  (OneB + (2 * TwoB) + (3 * ThreeB) + (4 * HR));
		textBA.setText("BA: " + String.valueOf(BA));
		textXBH.setText("XBH: " +String.valueOf(XBH));
		textTA.setText("TA: " +String.valueOf(TA));
		textSBA.setText("SBA: " +String.valueOf(SBA));
		textSBP.setText("SBP: " +String.valueOf(SBP) + "%");
		textPASO.setText("PA/SO: " +String.valueOf(PASO));
		textSLG.setText("SLG: " +String.valueOf(SLG));
		textISO.setText("ISO: " +String.valueOf(ISO));
		textOBP.setText("OBP: " +String.valueOf(OBP) + "%");
		textTB.setText("TB: " +String.valueOf(TB));
		textTOB.setText("TOB: " +String.valueOf(TOB));
	}

	public void handleToggleClick(View v) {
		boolean on = ((ToggleButton) v).isChecked();
		
		if (on){isAdd = false;}
		else {isAdd = true;}
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
	
	private void loadGameInfo() {
		// creates a new column in the SQLite Database to hold the new game's data
		
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
      populateSpinnerPlayer();
      
      spinnerPlayer.setOnItemSelectedListener(new OnItemSelectedListener()  {
  	   	@Override
  		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
  	   		parent.getItemAtPosition(position);
  	   		textAB = (TextView)findViewById(R.id.textAB);	
  	   		textOneB = (TextView)findViewById(R.id.textOneB);
  	   		textTwoB = (TextView)findViewById(R.id.textTwoB);
  	   		textThreeB = (TextView)findViewById(R.id.textThreeB);
  	   		textHR = (TextView)findViewById(R.id.textHR);
  	   		textBall = (TextView)findViewById(R.id.textBall);
  	   		textStrike = (TextView)findViewById(R.id.textStrike);
  	   		textH = (TextView)findViewById(R.id.textH);
  	   		textK = (TextView)findViewById(R.id.textK);
  	   		textBB = (TextView)findViewById(R.id.textBB);
  	   		textHBP = (TextView)findViewById(R.id.textHBP);
  	   		textPA = (TextView)findViewById(R.id.textPA);
  	   		textSH = (TextView)findViewById(R.id.textSH);
  	   		textSF = (TextView)findViewById(R.id.textSF);
  	   		textGDP = (TextView)findViewById(R.id.textGDP);
  	   		textFC = (TextView)findViewById(R.id.textFC);
  	   		textR = (TextView)findViewById(R.id.textR);
  	   		textRBI = (TextView)findViewById(R.id.textRBI);
  	   		textStB = (TextView)findViewById(R.id.textStB);
  	   		textCS = (TextView)findViewById(R.id.textCS);
  			//updates all stat data to match data in the SQLite Database 
  	   		//for now it will just reset the data
  	   		textAB.setText("0");
  	   		textOneB.setText("0");
  	   		textTwoB.setText("0");
  	   		textThreeB.setText("0");
  	   		textHR.setText("0");
  	   		textBall.setText("0");
  	   		textStrike.setText("0");
  	   		textH.setText("0");
  	   		textBB.setText("0");
  	   		textHBP.setText("0");
  	   		textPA.setText("0");
  	   		textSH.setText("0");
  	   		textSF.setText("0");
  	   		textGDP.setText("0");
  	   		textFC.setText("0");
  	   		textR.setText("0");
  	   		textRBI.setText("0");
  	   		textStB.setText("0");
  	   		textCS.setText("0"); 
  	   		
  	   		updateCalcStats();
  		}

  		@Override
  		public void onNothingSelected(AdapterView<?> parent) {
  			// TODO Auto-generated method stub
  			//Do Nothing
  		}
  	});
      
	}
	
	private void populateSpinnerPlayer() {
		//Create a list of strings
		List<String>playerStrings = new ArrayList<String>(0);
			
		players = playerList.getAllPlayers();
			
		for(int i = 0; i<players.size(); i++) {
			playerStrings.add(players.get(i).getName());
		}
		
		spinnerPlayer = (Spinner)findViewById(R.id.spinnerPlayer);
			
		ArrayAdapter<String>playerAdapter = 
				new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, playerStrings);
			
		playerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			
		spinnerPlayer.setAdapter(playerAdapter);
		
	}

	private void populateSpinnerTeams() {
		//Create a list of strings
		List<String>teamStrings = new ArrayList<String>(0);
		
		teams = teamList.getAllTeams();
		
		for(int i = 0; i<teams.size(); i++) {
			teamStrings.add(teams.get(i).getName());
		}
		
		ArrayAdapter<String>arrayAdapter = 
				new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamStrings);
		
		arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinnerSelectTeam.setAdapter(arrayAdapter);
		
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