package com.example.baseballstattracker;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class EditTeam extends Activity {
	private Spinner spinnerTeams;
	private List<Team>teams;
	private TeamList teamList;
	private EditText editPlayer;
	private PlayerList playerList;
	
	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_editteam);
		
		playerList = new PlayerList(this);
		spinnerTeams = (Spinner)findViewById(R.id.spinnerTeams);
		
		//Spinner
		teams = new ArrayList<Team>(0);
		teamList = new TeamList(this);
		spinnerTeams = (Spinner)findViewById(R.id.spinnerSelectTeam);
			
		populateSpinnerTeams();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editteam);
		
		spinnerTeams = (Spinner)findViewById(R.id.spinnerTeams);
		
		//Spinner
		teams = new ArrayList<Team>(0);
		teamList = new TeamList(this);
		spinnerTeams = (Spinner)findViewById(R.id.spinnerSelectTeam);
			
		populateSpinnerTeams();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_team, menu);
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
		switch(v.getId()){
			case R.id.buttonStartGameBack:
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			break;
			case R.id.buttonAdd:
			//addPlayer();
			break;
		}
	}
	
	private void addPlayer() {
		editPlayer = (EditText)findViewById(R.id.editTeam);
		Player p = new Player();
		p.setName(editPlayer.getText().toString());

		Log.d("Test", "Test1");
		Player newPlayer = playerList.createPlayer(p);
	}

	private void populateSpinnerTeams() {
		//Create a list of strings
		List<String>teamStrings = new ArrayList<String>(0);
		
		teams = teamList.getAllTeams();
		
		for(int i = 0; i<teams.size(); i++) {
			teamStrings.add(teams.get(i).getName());
		}
		
		spinnerTeams = (Spinner)findViewById(R.id.spinnerTeams);
		
		ArrayAdapter<String>arrayAdapter = 
				new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamStrings);
		
		arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinnerTeams.setAdapter(arrayAdapter);
		
	}
}
