package com.example.baseballstattracker;

public class Team {
	private int teamId;
	private boolean name;
	private String players;
	
	// Constructor
	public Team() {
		
	}
	
	// Accessors and Modifiers
	public void setTeamId(int id) {
		teamId = id;
	}
	
	public void setName(boolean n) {
		name = n;
	}
	
	public void setPlayers(String p) {
		players = p;
	}
	
	// Accessors
	public int getId() {
		return teamId;
	}
	
	public boolean getName() {
		return name;
	}
	
	public String getPlayers() {
		return players;
	}
	
	// Provides a String of the class
	public String toString() {
		String result = "";
		
		if (name) {
			result += "Name: ";
		}
		
		result += teamId + " " + players;
		
		return result;
	}

} // end class Team














