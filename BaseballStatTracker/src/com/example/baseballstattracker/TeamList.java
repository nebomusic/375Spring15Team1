package com.example.baseballstattracker;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class TeamList {
	private List <Team> teamList;
	private TeamsDAO teamsDataSource;
	
	public TeamList(Context c) {
		teamList = new ArrayList<Team>(0);
		teamsDataSource = new TeamsDAO(c);
		teamsDataSource.open();
		
	}
	
	//Methods
	public Team getTeam(int teamId) {
		return teamsDataSource.getTeamById(teamId);
	}
	
	public Team createTeam(Team t) {
		return teamsDataSource.createTeam(t);
	}
	
	public void editTeam(Team t) {
		teamsDataSource.editTeam(t);
	}
	
	public void deleteTeam(Team t) {
		teamsDataSource.deleteTeam(t);
	}
	
	public List<Team> getAllTeams() {
		teamList = teamsDataSource.getAllTeams();
		return teamList;
	}

}

