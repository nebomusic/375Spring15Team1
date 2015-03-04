package com.example.baseballstattracker;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class PlayersDAO {
	private SQLiteDatabase database;
	private PlayersSQLiteHelper dbHelper;
	private String[] allColumns = {
			PlayersSQLiteHelper.COLUMN_NAME,
			PlayersSQLiteHelper.COLUMN_TEAM,
			PlayersSQLiteHelper.COLUMN_ATBATS,
			PlayersSQLiteHelper.COLUMN_BASEONE,
			PlayersSQLiteHelper.COLUMN_BASETWO,
			PlayersSQLiteHelper.COLUMN_BASETHREE,
			PlayersSQLiteHelper.COLUMN_HOMERUN,
			PlayersSQLiteHelper.COLUMN_HIT,
			PlayersSQLiteHelper.COLUMN_BASEONBALLS,
			PlayersSQLiteHelper.COLUMN_HITBYPITCH,
			PlayersSQLiteHelper.COLUMN_PLATEAPPEARANCES,
			PlayersSQLiteHelper.COLUMN_SACRIFICEHIT,
			PlayersSQLiteHelper.COLUMN_SACRIFICEFLY,
			PlayersSQLiteHelper.COLUMN_GROUNDINTODOUBLE,
			PlayersSQLiteHelper.COLUMN_FIELDERSCHOICE,
			PlayersSQLiteHelper.COLUMN_RUN,
			PlayersSQLiteHelper.COLUMN_RBI,
			PlayersSQLiteHelper.COLUMN_STOLENBASE,
			PlayersSQLiteHelper.COLUMN_BATTINGAVERAGE,
			PlayersSQLiteHelper.COLUMN_EXTRABASEHIT,
			PlayersSQLiteHelper.COLUMN_TOTALAVERAGE,
			PlayersSQLiteHelper.COLUMN_PASO,
			PlayersSQLiteHelper.COLUMN_STOLENBASEAVERAGE,
			PlayersSQLiteHelper.COLUMN_STOLENBASEPERCENTAGE,
			PlayersSQLiteHelper.COLUMN_ISOLATEDPOWER,
			PlayersSQLiteHelper.COLUMN_ONBASEPERCENTAGE,
			PlayersSQLiteHelper.COLUMN_TOTALBASES,
			PlayersSQLiteHelper.COLUMN_SLUGGING,
			PlayersSQLiteHelper.COLUMN_TIMESONBASE,
			PlayersSQLiteHelper.COLUMN_TIMESONBASE};
	
	public PlayersDAO(Context context) {
		dbHelper = new PlayersSQLiteHelper(context);
	}
	
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
			

}
