package com.example.baseballstattracker;

public class Player {
	
	//Fields
	private int playerId;
	private String name="";
	private String team="";
	private String atBats="";
	private String baseOne="";
	private String baseTwo="";
	private String baseThree="";
	private String homeRun="";
	private String hit="";
	private String baseOnBalls="";
	private String hitByPitch="";
	private String plateAppearances="";
	private String sacrificeHit="";
	private String sacrificeFly="";
	private String groundIntoDouble="";
	private String fieldersChoice="";
	private String run="";
	private String rbi="";
	private String stolenBase="";
	private String battingAverage="";
	private String extraBaseHit="";
	private String totalAverage="";
	private String paso="";
	private String stolenBaseAverage="";
	private String stolenBasePercentage="";
	private String isolatedPower="";
	private String onBasePercentage="";
	private String totalBases="";
	private String slugging="";
	private String timesOnBase="";
	
	//Constructor
	public Player() {
		
	}
	
	//Modifiers
	public void setPlayerId(int id) {
		playerId = id;
	}
	public void setName(String n){
		name = n;
	}
	public void setTeam(String t){
		team = t;
	}
	public void setAtBats(String ab) {
		atBats = ab;
	}
	public void setBaseOne(String oneB){
		baseOne = oneB;
	}
	public void setBaseTwo(String twoB){
		baseTwo = twoB;
	}
	public void setBaseThree(String threeB){
		baseThree = threeB;
	}
	public void setHomeRun(String hr){
		homeRun = hr;
	}
	public void setHit(String h){
		hit = h;
	}
	public void setBaseOnBalls(String bob){
		baseOnBalls = bob;
	}
	public void setHitByPitch(String hbp){
		hitByPitch = hbp;
	}
	public void setPlateAppearances(String pa){
		plateAppearances = pa;
	}
	public void setSacrificeHit(String sh){
		sacrificeHit = sh;
	}
	public void setSacrificeFly(String sf){
		sacrificeFly = sf;
	}
	public void setGroundIntoDouble(String gip){
		groundIntoDouble = gip;
	}
	public void setFieldersChoice(String fc){
		fieldersChoice = fc;
	}
	public void setRun(String r){
		run = r;
	}
	public void setRBI(String rb){
		rbi = rb;
	}
	public void setStolenBase(String sb){
		stolenBase = sb;
	}
	public void setBattingAverage(String ba){
		battingAverage = ba;
	}
	public void setExtraBaseHit(String XBH){
		extraBaseHit = XBH;
	}
	public void setTotalAverage(String ta){
		totalAverage = ta;
	}
	public void setPASO(String pas){
		paso = pas;
	}
	public void setStolenBaseAverage(String sba){
		stolenBaseAverage = sba;
	}
	public void setStolenBasePercentage(String sbp){
		stolenBasePercentage = sbp;
	}
	public void setIsolatedPower(String ip){
		isolatedPower = ip;
	}
	public void setOnBasePercentage(String obp){
		onBasePercentage = obp;
	}
	public void setTotalBases(String tb){
		totalBases = tb;
	}
	public void setSlugging(String slg){
		slugging = slg;
	}
	public void setTimesOnBase(String tob){
		timesOnBase = tob;
	}
	
	
	//Accessors
	public int getId() {
		return playerId;
	}
	public String getName() {
		return name;
	}
	public String getTeam(){
		return team;
	}
	public String getAtBats() {
		return atBats;
	}
	public String getBaseOne(){
		return baseOne;
	}
	public String getBaseTwo(){
		return baseTwo;
	}
	public String getBaseThree(){
		return baseThree;
	}
	public String getHomeRun(){
		return homeRun;
	}
	public String getHit(){
		return hit;
	}
	public String getBaseOnBalls(){
		return baseOnBalls;
	}
	public String getHitByPitch(){
		return hitByPitch;
	}
	public String getPlateAppearances(){
		return plateAppearances;
	}
	public String getSacrificeHit(){
		return sacrificeHit;
	}
	public String getSacrificeFly(){
		return sacrificeFly;
	}
	public String getGroundIntoDouble(){
		return groundIntoDouble;
	}
	public String getFieldersChoice(){
		return fieldersChoice;
	}
	public String getRun(){
		return run;
	}
	public String getRBI(){
		return rbi;
	}
	public String getStolenBase(){
		return stolenBase;
	}
	public String getBattingAverage(){
		return battingAverage;
	}
	public String getExtraBaseHit(){
		return extraBaseHit;
	}
	public String getTotalAverage(){
		return totalAverage;
	}
	public String getPASO(){
		return paso;
	}
	public String getStolenBaseAverage(){
		return stolenBaseAverage;
	}
	public String getStolenBasePercentage(){
		return stolenBasePercentage;
	}
	public String getIsolatedPower(){
		return isolatedPower;
	}
	public String getOnBasePercentage(){
		return onBasePercentage;
	}
	public String getTotalBases(){
		return totalBases;
	}
	public String getSlugging(){
		return slugging;
	}
	public String getTimesOnBase(){
		return timesOnBase;
	}
}
