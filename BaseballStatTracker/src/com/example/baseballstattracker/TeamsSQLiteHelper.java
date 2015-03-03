package com.example.baseballstattracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TeamsSQLiteHelper extends SQLiteOpenHelper {

	public static final String TABLE_TEAMS = "teams";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_PLAYERS = "players";
	
	public static final String DATABASE_NAME = "teams.db";
	public static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = "create table "
			+TABLE_TEAMS + "("
			+ COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_NAME + " text not null, "
			+ COLUMN_PLAYERS + " text not null);";
	
	
	public TeamsSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);		
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(TeamsSQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
				+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_TEAMS);
		onCreate(db);		
	}

}
