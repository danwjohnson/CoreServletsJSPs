package com.coreservlets.chap09;

/**
 * Describes a catalog item for an online store.  The itemID
 * uniquely identifies the item, the short description
 * gives brief info like the book title and author,
 * the long description describes the item in a couple
 * of sentences, and the cost gives the current per-item price.
 * Both the short and long descriptions can contain HTML
 * markup.
 * @author DJ
 *
 */

public class CatalogItem {

	private String itemID;
	private String shortDescription;
	private String longDescription;
	private double cost;
	
	
	/**
	 * Constructor
	 * @param itemID
	 * @param shortDescription
	 * @param longDescription
	 * @param cost
	 */
	public CatalogItem(String itemID, String shortDescription,
					   String longDescription, double cost) {
		
		setItemID(itemID);
		setShortDescription(shortDescription);
		setLongDescription(longDescription);
		setCost(cost);
		
	} // end constructor
	
	
	/**
	 * Get the itemID
	 * @return itemID as a String
	 */
	public String getItemID() {
		
		return itemID;
		
	} // end getItemID()
	
	
	/**
	 * Set the itemID
	 * @param itemID
	 */
	protected void setItemID(String itemID) {
		
		this.itemID = itemID;
		
	} // end setItemID()
	
	
	/**
	 * Get the short description
	 * @return shortDescription as a String
	 */
	public String getShortDescription() {
		
		return shortDescription;
		
	} // end getShortDescription()
	
	
	/**
	 * Set the short description
	 * @param shortDescription
	 */
	protected void setShortDescription(String shortDescription) {
		
		this.shortDescription = shortDescription;
		
	} // end setShortDescription()
	
	
	/**
	 * Get the long description
	 * @return longDescription as a String
	 */
	public String getLongDescription() {
		
		return longDescription;
		
	} // end getLongDescription()
	
	
	/**
	 * Set the long description
	 * @param longDescription
	 */
	protected void setLongDescription(String longDescription) {
		
		this.longDescription = longDescription;
		
	} // end setLongDescription()
	
	
	/**
	 * Get the cost
	 * @return cost as a double
	 */
	public double getCost() {
		
		return cost;
		
	} // end getCost()
	
	
	/**
	 * Set the cost
	 * @param cost
	 */
	protected void setCost(double cost) {
		
		this.cost = cost;
		
	} // end setCost()
	
} // end class CatalogItem
