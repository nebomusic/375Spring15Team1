package com.example.baseballstattracker;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
		values.put(TeamsSQLiteHelper.COLUMN_NAME, t.getName());
		values.put(TeamsSQLiteHelper.COLUMN_PLAYERS, t.getPlayers());
		
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
		
		values.put(TeamsSQLiteHelper.COLUMN_NAME, t.getName());
		values.put(TeamsSQLiteHelper.COLUMN_PLAYERS, t.getPlayers());
		
		database.update(TeamsSQLiteHelper.TABLE_TEAMS, values, TeamsSQLiteHelper.COLUMN_ID + " = " + id, null);

	}
	
	public List<Team> getAllTeams() {
		List <Team> teamList = new ArrayList<Team>(0);
		Cursor cursor = database.query(TeamsSQLiteHelper.TABLE_TEAMS, allColumns, null, null, null, null, null);
		
		cursor.moveToFirst();
		
		while(!cursor.isAfterLast()) {
			Team team = cursorToTeam(cursor);
			teamList.add(team);
			cursor.moveToNext();
		}

		return teamList;
		
	}
	
	private Team cursorToTeam(Cursor cursor) {
		
		int id = cursor.getInt(0);
		String name = cursor.getString(1);
		String players = cursor.getString(2);
		
		Team t = new Team();
		
		t.setTeamId(id);
		t.setName(name);
		t.addPlayer(players);
		
		return t;		
	}
	
	public Team getTeamById(int id) {
		//Create a cursor
		Cursor cursor = database.query(TeamsSQLiteHelper.TABLE_TEAMS, allColumns,
				TeamsSQLiteHelper.COLUMN_ID + " = " + id, null, null, null, null);
		return (cursor.moveToFirst()) ? cursorToTeam(cursor) : null;
	}

} // end class TeamsDAO












