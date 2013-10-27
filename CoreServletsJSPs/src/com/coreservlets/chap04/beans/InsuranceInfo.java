package com.coreservlets.chap04.beans;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Simple bean that represents information needed to
 * calculate an employee's insurance costs.  Has String,
 * int, and boolean properties.  Used to demonstrate
 * automatically filling in bean properties from request
 * parameters.
 */

public class InsuranceInfo {

	private String name = "No name specified";
	private String employeeID = "No ID specified";
	private int numChildren = 0;
	private boolean isMarried = false;
	
	public String getName() {
		return name;
	} // end getName()
	
	
	/**
	 * Just in case user enters special HTML characters,
	 * filter them out before storing the name
	 */
	
	public void setName(String name) {
		this.name = ServletUtilities.filter(name);
	} // end setName()
	
	
	public String getEmployeeID() {
		return employeeID;
	} // end getEmployeeID()
	
	
	/**
	 * Just in case user enters special HTML characters,
	 * filter them out before storing the name
	 */
	
	public void setEmployeeID(String employeeID) {
		this.employeeID = ServletUtilities.filter(employeeID);
	} // end setEmployeeID()
	
	
	public int getNumChildren() {
		return numChildren;
	} // end getNumChildren()
	
	
	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	} // end setNumChildren
	
	
	/**
	 * Bean convention: name getter method "isXxxx" instead
	 * of "getXxxx" for boolean methods
	 */
	
	public boolean isMarried() {
		return isMarried;
	} // end isMarried()
	
	
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	} // end setMarried()
	
} // end InsuranceInfo class
