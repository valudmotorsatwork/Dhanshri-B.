package com.valud;

import com.valud.DessertItem;

/**
 * @author HGonge
 *Date 27-June-2016
 *
 */
public class Sundae extends DessertItem{
	
	private int iceCreamPrice;
	private int toppingPrice;
	public Sundae(String iceCream, int iCPrice, String topping, int toppingPrc) {
		super(iceCream+""+topping);
		setIceCreamPrice(iCPrice);
		setToppingPrice(toppingPrc);
		
	}

	@Override
	public int getCost() {
		int cost=0;
		cost=getIceCreamPrice()+getToppingPrice();
		return cost;
	}


	public int getIceCreamPrice() {
		return iceCreamPrice;
	}

	public void setIceCreamPrice(int iceCreamPrice) {
		this.iceCreamPrice = iceCreamPrice;
	}

	public int getToppingPrice() {
		return toppingPrice;
	}

	public void setToppingPrice(int toppingPrice) {
		this.toppingPrice = toppingPrice;
	}
	

}
