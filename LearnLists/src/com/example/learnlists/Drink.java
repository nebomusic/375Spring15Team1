package com.example.learnlists;

import java.util.Date;

public class Drink {
	//Fields
	private boolean hot;
	private String type;
	private String flavor;
	private String topping;
	private String dairy;
	private int size;
	private String instructions;
	private Date date;
	private boolean served;
	
	//Constructor - no initialization of fields
	public Drink() {
		
	}
	
	//Second Constructor with fields
	public Drink(boolean h, String t, String f, String tp, String d, int sz, String ins) {
		hot = h;
		type = t;
		flavor = f;
		topping = t;
		dairy = d;
		size = sz;
		instructions = ins;
		served = false;
	}
	
	//Modifiers
	public void setHot(boolean h) {
		hot = h;
	}
	
	public void setType(String t) {
		type  = t;
	}
	
	public void setFlavor(String f) {
		flavor = f;
	}
	
	public void setDairy(String d) {
		dairy = d;
	}
	
	public void setSize(int s) {
		size = s;
	}
	
	public void setInstructions(String i) {
		instructions = i;
	}
	
	public void setDate(Date d) {
		date = d;
	}
	
	//Accessors
	public boolean getHot() {
		return hot;
	}
	
	public String getType() {
		return type;
	}
	
	public String getFlavor() {
		return flavor;
	}
	
	public String getTopping() {
		return topping;
	}
	
	public String getDairy() {
		return dairy;
	}
	
	public int getSize() {
		return size;
	}
	
	public Date getDate() {
		return date;
	}
	
	public boolean getServed() {
		return served;
	}
	
	public void setServed(boolean s) {
		served = s;
	}
}

