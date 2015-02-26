package com.example.baseballstattracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {
	
	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_main);
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    		case R.id.buttonStart:
    			Intent intentOne = new Intent(this, StartGame.class);
    			startActivity(intentOne);
    			break;
    		case R.id.buttonEdit:
    			Intent intentTwo = new Intent(this, Manager.class);
    			startActivity(intentTwo);
    			break;
    		case R.id.buttonAbout:
    			Intent intentThree = new Intent(this, About.class);
    			startActivity(intentThree);
    			break;
    	}
    }
}
