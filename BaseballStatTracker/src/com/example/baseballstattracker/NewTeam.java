package com.example.baseballstattracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class NewTeam extends Activity {
	
	//Field
	private EditText editTeam;
	private TeamList teamList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newteam);
		
		editTeam = (EditText)findViewById(R.id.editTeam);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_team, menu);
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
	public void otherClick(View v) {
		
	}
	
	public void handleClick(View v) {
		Log.d("test1", "test");
		addTeam();
		
		Intent intentOne = new Intent(this, EditTeam.class);
		startActivity(intentOne);
	}

	private void addTeam() {
		
		editTeam = (EditText)findViewById(R.id.editTeam);
		Team t = new Team();
		t.setName(editTeam.getText().toString());	
		
		Team newTeam = teamList.createTeam(t);
		
		
	}
}
