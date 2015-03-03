package com.example.baseballstattracker;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Manager extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manager);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_manager);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manager, menu);
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
			case R.id.buttonAdd:
				Intent intentTwo = new Intent(this, NewTeam.class);
				startActivity(intentTwo);
				break;
			case R.id.buttonEdit:
				Intent intentOne = new Intent(this, EditTeam.class);
				startActivity(intentOne);
				break;
		}
	}
	
	
	
}












