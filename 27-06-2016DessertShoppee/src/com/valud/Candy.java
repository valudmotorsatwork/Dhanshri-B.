package com.valud;

/**
 * @author HGonge
 * Date 27-June-2016
 */
public class Candy extends DessertItem{
	private double weight;
	private int candyPrice;
	public Candy(String name, double wt, int price){	
		super(name);
		setWeight(wt);
		setCandyPrice(price);
		
	}

	@Override
	public int getCost() {
		int cost;
		double temp = getWeight()*getCandyPrice();
		cost = (int)Math.round(temp);
		return cost;
	}
	public String toString()
	{
		
		return "";
	}



	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getCandyPrice() {
		return candyPrice;
	}

	public void setCandyPrice(int candyPrice) {
		this.candyPrice = candyPrice;
	}

}