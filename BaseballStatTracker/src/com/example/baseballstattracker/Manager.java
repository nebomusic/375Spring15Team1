package com.example.baseballstattracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
//			case R.id.buttonAdd:
//				Intent intentOne = new Intent(this, Create.class);
//				startActivity(intentOne);
//				break;
			case R.id.buttonEdit:
				Intent intentTwo = new Intent(this, EditTeam.class);
				startActivity(intentTwo);
				break;
		}
	}
}
