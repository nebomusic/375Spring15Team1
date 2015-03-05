package com.example.baseballstattracker;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

public class PlayerList {
	private List <Player> playerList;
	private PlayersDAO playersDataSource;
	
	public PlayerList(Context c) {
		playerList = new ArrayList<Player>(0);
		playersDataSource = new PlayersDAO(c);
		Log.d("Test", "Test2");
		playersDataSource.open();
	}
	
	//Methods
	public Player getPlayer(int playerId) {
		return playersDataSource.getPlayerById(playerId);
	}
	
	public Player createPlayer(Player p) {
		return playersDataSource.createPlayer(p);
	}
	
	public void editPlayer(Player p) {
		playersDataSource.editPlayer(p);
	}
	
	public void deletePlayer(Player p) {
		playersDataSource.deletePlayer(p);
	}
	
	public List<Player> getAllPlayers() {
		playerList = playersDataSource.getAllPlayers();
		return playerList;
	}
}
