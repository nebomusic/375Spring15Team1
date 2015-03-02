//Devin Summers
//All work here is honestly obtained and is my own
package com.example.summersfinalexam;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	//Fields
	private EditText editDollars;
	private Button buttonDollars;
	private EditText editYen;
	private Button buttonYen;
	private EditText editPounds;
	private Button buttonPounds;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editDollars = (EditText)findViewById(R.id.editDollars);
		buttonDollars = (Button)findViewById(R.id.buttonDollars);
		editYen = (EditText)findViewById(R.id.editYen);
		buttonYen = (Button)findViewById(R.id.buttonYen);
		editPounds = (EditText)findViewById(R.id.editPounds);
		buttonPounds = (Button)findViewById(R.id.buttonPounds);
		
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
		double dollars;
		double yen;
		double pounds;
		if (editDollars.length() <= 0){dollars =0;}
		else {dollars = Double.parseDouble(String.valueOf(editDollars.getText()));}
		if (editYen.length() <= 0){yen = 0;}
		else{yen = Double.parseDouble(String.valueOf(editYen.getText()));}
		if (editPounds.length() <= 0){pounds = 0;}
		else{pounds = Double.parseDouble(String.valueOf(editPounds.getText()));}
		
		switch(v.getId()){
			case R.id.buttonDollars:
				String textYen = dollarsToYen(dollars);
				String textPounds = dollarsToPounds(dollars);
				editYen.setText(textYen);
				editPounds.setText(textPounds);
			break;
			case R.id.buttonYen:
				String textDollars = yenToDollars(yen);
				String textPounds2 = yenToPounds(yen);
				editDollars.setText(textDollars);
				editPounds.setText(textPounds2);
			break;
			case R.id.buttonPounds:
				String textDollars2 = poundsToDollars(pounds);
				String textYen2 = poundsToYen(pounds);
				editYen.setText(textYen2);
				editDollars.setText(textDollars2);
			break;
			
		}
	}

	private String dollarsToPounds(double dollars) {
		double pounds3 = dollars*.62;
		return String.valueOf(pounds3);
	}

	private String poundsToYen(double pounds) {
		double yen3 = (pounds/.62)*97.35;
		return String.valueOf(yen3);
	}

	private String poundsToDollars(double pounds) {
		double dollars3 = pounds/.62;
		return String.valueOf(dollars3);
	}

	private String yenToPounds(double yen) {
		double pounds2 = (yen/97.35)*.62;		
		return String.valueOf(pounds2);
	}

	private String yenToDollars(double yen) {
		double dollars2 = yen/97.35;
		return String.valueOf(dollars2);
	}

	private String dollarsToYen(double dollars) {
		double yen2 = dollars*97.35;
		return String.valueOf(yen2);
	}
}
