package com.example.baseballstattracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PlayersSQLiteHelper extends SQLiteOpenHelper{

	public static final String TABLE_PLAYERS = "players";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_PLAYERTEAM = "team";
	public static final String COLUMN_ATBATS = "atbats";
	public static final String COLUMN_BASEONE = "baseone";
	public static final String COLUMN_BASETWO = "basetwo";
	public static final String COLUMN_BASETHREE = "basethree";
	public static final String COLUMN_HOMERUN = "homeruns";
	public static final String COLUMN_HIT = "hits";
	public static final String COLUMN_BASEONBALLS = "baseonballs";
	public static final String COLUMN_HITBYPITCH = "hitbypitch";
	public static final String COLUMN_PLATEAPPEARANCES = "plateappearances";
	public static final String COLUMN_SACRIFICEHIT = "sacrificehit";
	public static final String COLUMN_SACRIFICEFLY = "sacrificefly";
	public static final String COLUMN_GROUNDINTODOUBLE = "groundintodouble";
	public static final String COLUMN_FIELDERSCHOICE = "fielderschoice";
	public static final String COLUMN_RUN = "run";
	public static final String COLUMN_RBI = "rbi";
	public static final String COLUMN_STOLENBASE = "stolenbase";
	public static final String COLUMN_BATTINGAVERAGE = "battingaverage";
	public static final String COLUMN_EXTRABASEHIT = "extrabasehit";
	public static final String COLUMN_TOTALAVERAGE = "totalaverage";
	public static final String COLUMN_PASO = "plateaverageperstrikeout";
	public static final String COLUMN_STOLENBASEAVERAGE = "stolenbaseaverage";
	public static final String COLUMN_STOLENBASEPERCENTAGE = "stolenbasepercentage";
	public static final String COLUMN_ISOLATEDPOWER = "isolatedpower";
	public static final String COLUMN_ONBASEPERCENTAGE = "onbasepercentage";
	public static final String COLUMN_TOTALBASES = "totalbases";
	public static final String COLUMN_SLUGGING = "slugging";
	public static final String COLUMN_TIMESONBASE = "timesonbase";
	
	
	public static final String DATABASE_NAME = "players.db";
	public static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_PLAYERS + "("
			+ COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_NAME + " text not null, "
			+ COLUMN_PLAYERTEAM + " text not null, "
			+ COLUMN_ATBATS + " text not null, "
			+ COLUMN_BASEONE + " text not null, "
			+ COLUMN_BASETWO + " text not null, "
			+ COLUMN_BASETHREE + " text not null, "
			+ COLUMN_HOMERUN + " text not null, "
			+ COLUMN_HIT + " text not null, "
			+ COLUMN_BASEONBALLS + " text not null, "
			+ COLUMN_HITBYPITCH + " text not null, "
			+ COLUMN_PLATEAPPEARANCES + " text not null, "
			+ COLUMN_SACRIFICEHIT + " text not null, "
			+ COLUMN_SACRIFICEFLY + " text not null, "
			+ COLUMN_GROUNDINTODOUBLE + " text not null, "
			+ COLUMN_FIELDERSCHOICE + " text not null, "
			+ COLUMN_RUN + " text not null, "
			+ COLUMN_RBI + " text not null, "
			+ COLUMN_STOLENBASE + " text not null, "
			+ COLUMN_BATTINGAVERAGE + " text not null, "
			+ COLUMN_EXTRABASEHIT + " text not null, "
			+ COLUMN_TOTALAVERAGE + " text not null, "
			+ COLUMN_PASO + " text not null, "
			+ COLUMN_STOLENBASEAVERAGE + " text not null, "
			+ COLUMN_STOLENBASEPERCENTAGE + " text not null, "
			+ COLUMN_ISOLATEDPOWER + " text not null, "
			+ COLUMN_ONBASEPERCENTAGE + " text not null, "
			+ COLUMN_TOTALBASES + " text not null, "
			+ COLUMN_SLUGGING + " text not null, "
			+ COLUMN_TIMESONBASE + " text not null);";
	
	public PlayersSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("Test", "Test4");
		db.execSQL(DATABASE_CREATE);
		Log.d("Test", "Test6");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d("Test", "Test5");
		Log.w(PlayersSQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to " 
				+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_PLAYERS);
		onCreate(db);
	}
	
}
