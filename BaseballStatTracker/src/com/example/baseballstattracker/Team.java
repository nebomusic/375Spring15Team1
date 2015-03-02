package com.example.baseballstattracker;

public class Team {
	private int teamId;
	private String name;
	private String players;
	
	// Constructor
	public Team() {
		
	}
	
	// Accessors and Modifiers
	public void setTeamId(int id) {
		teamId = id;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setPlayers(String p) {
		players = p;
	}
	
	// Accessors
	public int getId() {
		return teamId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPlayers() {
		return players;
	}
	
} // end class Team














