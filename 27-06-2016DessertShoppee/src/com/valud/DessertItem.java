package com.valud;


/**
	 * @author dbagal
	 * Date-27-June-2016
 */


	//DessertItem.java - Dessert Item abstract superclass

	//Abstract superclass for Dessert Item hierarchy

	public abstract class DessertItem {

	protected String name;
	
	//Default constructor for DessertItem class
	public DessertItem() {
	 this("");
	}
	
	//Constructor For Initializing  DessertItem Constructor
	public DessertItem(String name) {
	 if (name.length() <= DessertShoppe.MAX_ITEM_NAME_SIZE)
	   this.name = name;
	 else 
	   this.name = name.substring(0,DessertShoppe.MAX_ITEM_NAME_SIZE);
	}
	 
	public final String getName() {
	 return name;
	}
	
	public abstract int getCost();

	}

