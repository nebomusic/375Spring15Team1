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
		values.put(PlayersSQLiteHelper.COLUMN_NAME, p.getName());
		values.put(PlayersSQLiteHelper.COLUMN_TEAM, p.getTeam());
		values.put(PlayersSQLiteHelper.COLUMN_ATBATS, p.getAtBats());
		values.put(PlayersSQLiteHelper.COLUMN_BASEONE, p.getBaseOne());
		values.put(PlayersSQLiteHelper.COLUMN_BASETWO, p.getBaseTwo());
		values.put(PlayersSQLiteHelper.COLUMN_BASETHREE, p.getBaseThree());
		values.put(PlayersSQLiteHelper.COLUMN_HOMERUN, p.getHomeRun());
		values.put(PlayersSQLiteHelper.COLUMN_HIT, p.getHit());
		values.put(PlayersSQLiteHelper.COLUMN_BASEONBALLS, p.getBaseOnBalls());
		values.put(PlayersSQLiteHelper.COLUMN_HITBYPITCH, p.getHitByPitch());
		values.put(PlayersSQLiteHelper.COLUMN_PLATEAPPEARANCES, p.getPlateAppearances());
		values.put(PlayersSQLiteHelper.COLUMN_SACRIFICEHIT, p.getSacrificeHit());
		values.put(PlayersSQLiteHelper.COLUMN_SACRIFICEFLY, p.getSacrificeFly());
		values.put(PlayersSQLiteHelper.COLUMN_GROUNDINTODOUBLE, p.getGroundIntoDouble());
		values.put(PlayersSQLiteHelper.COLUMN_FIELDERSCHOICE, p.getFieldersChoice());
		values.put(PlayersSQLiteHelper.COLUMN_RUN, p.getRun());
		values.put(PlayersSQLiteHelper.COLUMN_RBI, p.getRBI());
		values.put(PlayersSQLiteHelper.COLUMN_STOLENBASE, p.getStolenBase());
		values.put(PlayersSQLiteHelper.COLUMN_BATTINGAVERAGE, p.getBattingAverage());
		values.put(PlayersSQLiteHelper.COLUMN_EXTRABASEHIT, p.getExtraBaseHit());
		values.put(PlayersSQLiteHelper.COLUMN_TOTALAVERAGE, p.getTotalAverage());
		values.put(PlayersSQLiteHelper.COLUMN_PASO, p.getPASO());
		values.put(PlayersSQLiteHelper.COLUMN_STOLENBASEAVERAGE, p.getStolenBaseAverage());
		values.put(PlayersSQLiteHelper.COLUMN_STOLENBASEPERCENTAGE, p.getStolenBasePercentage());
		values.put(PlayersSQLiteHelper.COLUMN_ISOLATEDPOWER, p.getIsolatedPower());
		values.put(PlayersSQLiteHelper.COLUMN_ONBASEPERCENTAGE, p.getOnBasePercentage());
		values.put(PlayersSQLiteHelper.COLUMN_TOTALBASES, p.getTotalBases());
		values.put(PlayersSQLiteHelper.COLUMN_SLUGGING, p.getSlugging());
		values.put(PlayersSQLiteHelper.COLUMN_TIMESONBASE, p.getTimesOnBase());
		
		
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
		values.put(PlayersSQLiteHelper.COLUMN_TEAM, p.getTeam());
		values.put(PlayersSQLiteHelper.COLUMN_ATBATS, p.getAtBats());
		values.put(PlayersSQLiteHelper.COLUMN_BASEONE, p.getBaseOne());
		values.put(PlayersSQLiteHelper.COLUMN_BASETWO, p.getBaseTwo());
		values.put(PlayersSQLiteHelper.COLUMN_BASETHREE, p.getBaseThree());
		values.put(PlayersSQLiteHelper.COLUMN_HOMERUN, p.getHomeRun());
		values.put(PlayersSQLiteHelper.COLUMN_HIT, p.getHit());
		values.put(PlayersSQLiteHelper.COLUMN_BASEONBALLS, p.getBaseOnBalls());
		values.put(PlayersSQLiteHelper.COLUMN_HITBYPITCH, p.getHitByPitch());
		values.put(PlayersSQLiteHelper.COLUMN_PLATEAPPEARANCES, p.getPlateAppearances());
		values.put(PlayersSQLiteHelper.COLUMN_SACRIFICEHIT, p.getSacrificeHit());
		values.put(PlayersSQLiteHelper.COLUMN_SACRIFICEFLY, p.getSacrificeFly());
		values.put(PlayersSQLiteHelper.COLUMN_GROUNDINTODOUBLE, p.getGroundIntoDouble());
		values.put(PlayersSQLiteHelper.COLUMN_FIELDERSCHOICE, p.getFieldersChoice());
		values.put(PlayersSQLiteHelper.COLUMN_RUN, p.getRun());
		values.put(PlayersSQLiteHelper.COLUMN_RBI, p.getRBI());
		values.put(PlayersSQLiteHelper.COLUMN_STOLENBASE, p.getStolenBase());
		values.put(PlayersSQLiteHelper.COLUMN_BATTINGAVERAGE, p.getBattingAverage());
		values.put(PlayersSQLiteHelper.COLUMN_EXTRABASEHIT, p.getExtraBaseHit());
		values.put(PlayersSQLiteHelper.COLUMN_TOTALAVERAGE, p.getTotalAverage());
		values.put(PlayersSQLiteHelper.COLUMN_PASO, p.getPASO());
		values.put(PlayersSQLiteHelper.COLUMN_STOLENBASEAVERAGE, p.getStolenBaseAverage());
		values.put(PlayersSQLiteHelper.COLUMN_STOLENBASEPERCENTAGE, p.getStolenBasePercentage());
		values.put(PlayersSQLiteHelper.COLUMN_ISOLATEDPOWER, p.getIsolatedPower());
		values.put(PlayersSQLiteHelper.COLUMN_ONBASEPERCENTAGE, p.getOnBasePercentage());
		values.put(PlayersSQLiteHelper.COLUMN_TOTALBASES, p.getTotalBases());
		values.put(PlayersSQLiteHelper.COLUMN_SLUGGING, p.getSlugging());
		values.put(PlayersSQLiteHelper.COLUMN_TIMESONBASE, p.getTimesOnBase());
				
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
		//for all fields
				
		return p;		
	}
	
	public Player getPlayerById(int id) {
		//Create a cursor
		Cursor cursor = database.query(PlayersSQLiteHelper.TABLE_PLAYERS, allColumns,
				PlayersSQLiteHelper.COLUMN_ID + " = " + id, null, null, null, null);
		return (cursor.moveToFirst()) ? cursorToPlayer(cursor) : null;
	}
}
