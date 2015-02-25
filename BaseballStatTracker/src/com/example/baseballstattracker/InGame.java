package com.example.baseballstattracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class InGame extends Activity {
	
	private TextView textTeam;
	private StartGame currentgame;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_in_game);
		//Set Top Text to the current team
		textTeam = (TextView)findViewById(R.id.textTeam);
		String team = (String) currentgame.getStartGameInfo().get(0);
		textTeam.setText(team);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.in_game, menu);
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
			case R.id.buttonInGameBack:
				Intent intentOne = new Intent(this, StartGame.class);
				startActivity(intentOne);
				break;
		}
	}
}
