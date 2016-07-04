package com.valud;


import java.util.ArrayList;

/**
 * @author HGonge
 * Date:27June2016
 * 
 */
public class Checkout extends java.lang.Object{
	
	 // the number of items 
	private int itemNo;
    
    // the array of items in the current list
    ArrayList<DessertItem> desserts = new ArrayList<DessertItem>();
	//Zero Parameterized Constructor
	public Checkout()
		{
			itemNo =0;
			desserts.clear();
		}
	
	//Clears the Checkout to begin checking out a new set of items
	public void clear()
	{
		for(int i = 0; i < itemNo; i++)
        {
           desserts.clear();
        }
		itemNo = 0;
	}
	
    //A DessertItem is added to the end of the list of items
	public void enterItem(DessertItem item)
	{
		  desserts.add(item);
		  itemNo++;
	}
	
	//Returns the number of DessertItem's in the list
	public int numberOfItems()
	{
		int count=0;
		count = itemNo;
		return count;
	}
	
	//Returns total cost of items in cents (without tax)
	public int totalCost()
	{
		int totalCost=0;
		  for(int i=0; i < itemNo; i++)
	        {	        
			  totalCost += desserts.get(i).getCost();
	        }
		return totalCost;
	}
	
	//Returns total tax on items in cents
	public int totalTax()
	{
		int totalTax=0;
		int costWithoutTax= totalCost();
		 totalTax = (int)Math.round(costWithoutTax * DessertShoppe.TAX_RATE/100.0);
		return totalTax;
	}
	public String toString()
	{
		 String receipt = "";
		 int WIDTH_OF_RECEIPT = 30;
		 receipt = "-------------------------------------------\n";
		 receipt += DessertShoppe.STORE_NAME+"\n";
		 receipt += "\n*****************RECEIPT******************\n";
		 receipt += "Number of Items: " + itemNo + "\n\n";
	        int itemCost = 0;
	        int widthCost=WIDTH_OF_RECEIPT-3;
	        for(int i=0; i < itemNo; i++)
	        {
	        	receipt +="Item Name-->" + desserts.get(i).getName()+"\n";
	        	receipt +="Cost-->"+ String.format("%" + widthCost + "s%n", desserts.get(i).getCost())+"\n";
	        	itemCost += desserts.get(i).getCost();
	        }
	        receipt += "\n";
	        receipt += "Subtotal";
	        int  widthPreTax =WIDTH_OF_RECEIPT - 8; 
	        String preTax = DessertShoppe.cents2dollarsAndCents(itemCost);
			receipt +=String.format("%" + widthPreTax + "s%n", preTax);

	        // calculate the taxes
	        receipt += "Tax";
	        int tax = (int)Math.round(itemCost * DessertShoppe.TAX_RATE/100.0);
	        String taxS = DessertShoppe.cents2dollarsAndCents(tax);
	        // format the spacing for the tax amount
	        // we subtract 3 because of the 3 letters in Tax
	        int widthTax = WIDTH_OF_RECEIPT - 3;
	        receipt += String.format("%" + widthTax + "s%n", taxS);
	        
	        // calculate the total
	        receipt += "Total";
	        int total = itemCost + tax;
	        String totalS = DessertShoppe.cents2dollarsAndCents(total);
	     
	        int widthTotal = WIDTH_OF_RECEIPT - 5;
	        receipt += String.format("%" + widthTotal + "s%n", totalS);
	        receipt+="---------------------------------";
	        return receipt;
	}
	
}