package com.example.baseballstattracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PlayersSQLiteHelper extends SQLiteOpenHelper{

	public static final String TABLE_PLAYERS = "players";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_TEAM = "team";
	public static final String COLUMN_ATBATS = "at bats";
	public static final String COLUMN_BASEONE = "base one";
	public static final String COLUMN_BASETWO = "base two";
	public static final String COLUMN_BASETHREE = "base three";
	public static final String COLUMN_HOMERUN = "homeruns";
	public static final String COLUMN_HIT = "hits";
	public static final String COLUMN_BASEONBALLS = "base on balls";
	public static final String COLUMN_HITBYPITCH = "hit by pitch";
	public static final String COLUMN_PLATEAPPEARANCES = "plate appearances";
	public static final String COLUMN_SACRIFICEHIT = "sacrifice hit";
	public static final String COLUMN_SACRIFICEFLY = "sacrifice fly";
	public static final String COLUMN_GROUNDINTODOUBLE = "ground into double";
	public static final String COLUMN_FIELDERSCHOICE = "fielders choice";
	public static final String COLUMN_RUN = "run";
	public static final String COLUMN_RBI = "rbi";
	public static final String COLUMN_STOLENBASE = "stole base";
	public static final String COLUMN_BATTINGAVERAGE = "batting average";
	public static final String COLUMN_EXTRABASEHIT = "extra base hit";
	public static final String COLUMN_TOTALAVERAGE = "total average";
	public static final String COLUMN_PASO = "plate average per strike out";
	public static final String COLUMN_STOLENBASEAVERAGE = "stolen base average";
	public static final String COLUMN_STOLENBASEPERCENTAGE = "stolen base percentage";
	public static final String COLUMN_ISOLATEDPOWER = "isolated power";
	public static final String COLUMN_ONBASEPERCENTAGE = "on base percentage";
	public static final String COLUMN_TOTALBASES = "total bases";
	public static final String COLUMN_SLUGGING = "sluggins";
	public static final String COLUMN_TIMESONBASE = "times on base";
	
	
	public static final String DATABASE_NAME = "players.db";
	public static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_PLAYERS + "("
			+ COLUMN_NAME + " integer primary key autoincrement, "
			+ COLUMN_TEAM + " text not null, "
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
			+ COLUMN_TIMESONBASE + " text not null, "
			+ COLUMN_TIMESONBASE + " text not null);";
	
	public PlayersSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(PlayersSQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to " 
				+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_PLAYERS);
		onCreate(db);
	}
	
}
