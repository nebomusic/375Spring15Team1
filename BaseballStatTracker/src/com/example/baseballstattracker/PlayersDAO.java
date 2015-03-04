package com.example.baseballstattracker;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
			
	public Team createPlayer(Player p) {
		ContentValues values = new ContentValues();
		// Place t data into values object
		// Handle boolean values
		//values.put(PlayersSQLiteHelper.COLUMN_NAME, p.getName());
		
		
		long insertId = database.insert(PlayersSQLiteHelper.TABLE_PLAYERS, null, values);
		
		Cursor cursor = database.query(PlayersSQLiteHelper.TABLE_PLAYERS, allColumns,
										PlayersSQLiteHelper.COLUMN_ID + " = " + insertId , null, null, null, null);
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
}
