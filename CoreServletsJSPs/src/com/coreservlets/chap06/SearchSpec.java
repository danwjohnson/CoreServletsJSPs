package com.coreservlets.chap06;

/**
 * Small class the encapsulates how to construct a
 * search string for a particular search engine.
 * @author DJ
 *
 */

public class SearchSpec {

	private String name, baseURL;
	
	public SearchSpec(String name, String baseURL) {
		
		this.name = name;
		this.baseURL = baseURL;
		
	} // end constructor
	
	/**
	 * Builds a URL for the results page by simply concatenating
	 * the base URL (http://...?someVar=?") with the URL-encoded
	 * search string (jsp+training)
	 */
	
	public String makeURL(String searchString) {
		return(baseURL + searchString);
	} // end makeURL()
	
	public String getName() {
		return name;
	} // end getName()
	
} // end SearchSpec class
