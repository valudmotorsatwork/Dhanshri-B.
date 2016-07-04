package com.valud;

/**
 * @author dbagal
 *Date-27-june-2016
 */
public class Cookie extends DessertItem{

	private int quantityInDozens;
	private int cookiePrice;
	public Cookie(String name, int quantity, int price) {
		super(name);
		setQuantityInDozens(quantity);
		setCookiePrice(price);
	}
	

	@Override
	public int getCost() {
		int cost=0;
		cost=getQuantityInDozens()*getCookiePrice();
		return cost;
	}

	

	public int getQuantityInDozens() {
		return quantityInDozens;
	}

	public void setQuantityInDozens(int quantityInDozens) {
		this.quantityInDozens = quantityInDozens;
	}

	public int getCookiePrice() {
		return cookiePrice;
	}

	public void setCookiePrice(int cookiePrice) {
		this.cookiePrice = cookiePrice;
	}

}