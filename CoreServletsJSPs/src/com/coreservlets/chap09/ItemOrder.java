package com.coreservlets.chap09;

/**
 * Associates a catalog Item with a specific order by
 * keeping track of the number ordered and the total price.
 * Also provides some convenience methods to get at the
 * CatalogItem data without extracting the CatalogItem
 * @author DJ
 *
 */

public class ItemOrder {

	private CatalogItem item;
	private int numItems;
	
	public ItemOrder(CatalogItem item) {
		
		setItem(item);
		setNumItems(1);
		
	} // end constructor
	
	
	public CatalogItem getItem() {
		
		return item;
		
	} // end getItem()
	
	
	public void setItem(CatalogItem item) {
		
		this.item = item;
		
	} // end setItem()
	
	
	public String getItemID() {
		
		return getItem().getItemID();
		
	} // end getItemID()
	
	
	public String getShortDescription() {
		
		return getItem().getShortDescription();
		
	} // end getShortDescription()
	
	
	public String getLongDescription() {
		
		return getItem().getLongDescription();
		
	} // end getLongDescription()
	
	
	public double getUnitCost() {
		
		return getItem().getCost();
		
	} // end getUnitCost()
	
	
	public int getNumItems() {
		
		return numItems;
		
	} // end getNumItems()
	
	
	public void setNumItems(int n) {
		
		this.numItems = n;
		
	} // end setNumItems()
	
	
	public void incrementNumItems() {
		
		setNumItems(getNumItems() + 1);
		
	} // end incrementNumItems()
	
	
	public void cancelOrder() {
		
		setNumItems(0);
		
	} // end cancelOrder()
	
	
	public double getTotalCost() {
		
		return getNumItems() * getUnitCost();
		
	} // end getTotalCost()

} // end ItemOrder class
