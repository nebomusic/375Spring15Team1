package com.example.baseballstattracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TeamsDAO {
	private SQLiteDatabase database;
	private TeamsSQLiteHelper dbHelper;
	private String [] allColumns = {
			TeamsSQLiteHelper.COLUMN_ID,
			TeamsSQLiteHelper.COLUMN_NAME,
			TeamsSQLiteHelper.COLUMN_PLAYERS};
	
	public TeamsDAO(Context context) {
		dbHelper = new TeamsSQLiteHelper(context);
	}
	
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
	
	public Team createTeam(Team t) {
		ContentValues values = new ContentValues();
		// Place t data into values object
		// Handle boolean values
		int name = 0;
		if (t.getName()) {
			name = 1;
		}
		
		values.put(TeamsSQLiteHelper.COLUMN_NAME, name);
		values.put(TeamsSQLiteHelper.COLUMN_PLAYERS, t.getPlayers);
		
		long insertId = database.insert(TeamsSQLiteHelper.TABLE_TEAMS, null, values);
		
		Cursor cursor = database.query(TeamsSQLiteHelper.TABLE_TEAMS, allColumns,
										TeamsSQLiteHelper.COLUMN_ID + " = " + insertId , null, null, null, null);
		cursor.moveToLast();
		Team newTeam = cursorToTeam(cursor);
		cursor.close();
		
		return newTeam;
	}
	
	public void deleteTeam(Team t) {
		int id = t.getId();
		database.delete(TeamsSQLiteHelper.TABLE_TEAMS,
				TeamsSQLiteHelper.COLUMN_ID + " = " + id, null);
	}
	
	public void editTeam(Team t) {
		ContentValues values = new ContentValues();
		int id = t.getId();
		
		int name = 0;
		if(t.getName()) {
			name = 1;
		}
		
		values.put(TeamsSQLiteHelper.COLUMN_NAME, name);
		values.put(TeamsSQLiteHelper.COLUMN_PLAYERS, t.getPlayers());
		
		database.update(TeamsSQLiteHelper.TABLE_TEAMS, values, TeamsSQLiteHelper.COLUMN_ID + " = " + id, null);

	}

} // end class TeamsDAO












