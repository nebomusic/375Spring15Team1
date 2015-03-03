package com.example.baseballstattracker;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private int teamId;
	private String name;
	private List<String> players;
	
	// Constructor
	public Team() {
		players = new ArrayList<String>(0);
	}
	
	// Accessors and Modifiers
	public void setTeamId(int id) {
		teamId = id;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void addPlayer(String p) {
		players.add(p);
	}
	
	// Accessors
	public int getId() {
		return teamId;
	}
	
	public String getName() {
		return name;
	}
	
	public List<String> getPlayerList() {
		return players;
	}
	
	public String getPlayers() {
		String player = "";
		for (int i=0; i<players.size();i++){
			player += players.get(i) + ", ";
		}
		return player;
	}
	
} // end class Team














