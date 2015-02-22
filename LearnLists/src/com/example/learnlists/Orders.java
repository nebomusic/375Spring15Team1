package com.example.learnlists;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	//Fields (only the list)
	private List <Drink> drinks;
	
	//Constructor
	public Orders() {
		drinks = new ArrayList <Drink> (0);
	}
	
	//Accessor
	public List<Drink> getDrinks() {
		return drinks;
	}
	
	//Add a drink to the list
	public void addDrink(Drink d) {
		drinks.add(d);
	}
	
	//get the total drinks served
	public int getNumServed() {
		int total = 0;
		for (int d = 0; d < drinks.size(); d++) {
			if (drinks.get(d).getServed() == true) {
				total++;
			}
		}
		return total;
	}
	
	//get an individual order
	public Drink getDrink(int i) {
		return drinks.get(i);
	}
	 //get the drinks ordered
	public int getNumDrinks() {
		return drinks.size();
	}
}
