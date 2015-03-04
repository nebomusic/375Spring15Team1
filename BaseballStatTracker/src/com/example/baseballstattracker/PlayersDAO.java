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
			
	public Player createPlayer(Player p) {
		ContentValues values = new ContentValues();
		// Place t data into values object
		// Handle boolean values
		//values.put(PlayersSQLiteHelper.COLUMN_NAME, p.getName());
		
		
		long insertId = database.insert(PlayersSQLiteHelper.TABLE_PLAYERS, null, values);
		
		Cursor cursor = database.query(PlayersSQLiteHelper.TABLE_PLAYERS, allColumns,
										PlayersSQLiteHelper.COLUMN_ID + " = " + insertId , null, null, null, null);
		cursor.moveToLast();
		Player newPlayer = cursorToPlayer(cursor);
		cursor.close();
		
		return newPlayer;
	}
	
	public void deletePlayer(Player p) {
		int id = p.getId();
		database.delete(PlayersSQLiteHelper.TABLE_PLAYERS,
				PlayersSQLiteHelper.COLUMN_ID + " = " + id, null);
	}
	
	public void editPlayer(Player p) {
		ContentValues values = new ContentValues();
		int id = p.getId();
		
		values.put(PlayersSQLiteHelper.COLUMN_NAME, p.getName());
				
		database.update(PlayersSQLiteHelper.TABLE_PLAYERS, values, PlayersSQLiteHelper.COLUMN_ID + " = " + id, null);

	}
	
	public List<Player> getAllPlayers() {
		List <Player> playerList = new ArrayList<Player>(0);
		Cursor cursor = database.query(PlayersSQLiteHelper.TABLE_PLAYERS, allColumns, null, null, null, null, null);
		
		cursor.moveToFirst();
		
		while(!cursor.isAfterLast()) {
			Player player = cursorToPlayer(cursor);
			playerList.add(player);
			cursor.moveToNext();
		}

		return playerList;
		
	}
	
	private Player cursorToPlayer(Cursor cursor) {
		
		int id = cursor.getInt(0);
		String name = cursor.getString(1);
		String team = cursor.getString(2);
		//for all fields
		
		Player p = new Player();
		
		p.setPlayerId(id);
		//p.setName(name);
				
		return p;		
	}
	
	public Player getPlayerById(int id) {
		//Create a cursor
		Cursor cursor = database.query(PlayersSQLiteHelper.TABLE_PLAYERS, allColumns,
				PlayersSQLiteHelper.COLUMN_ID + " = " + id, null, null, null, null);
		return (cursor.moveToFirst()) ? cursorToPlayer(cursor) : null;
	}
}
