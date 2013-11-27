package com.coreservlets.chap06;

/**
 * Utility with static method to build a URL for any
 * of the most popular search engines.
 * @author DJ
 *
 */

public class SearchUtilities {

	private static SearchSpec[] commonSpecs =
		{ new SearchSpec("Google", "http://www.google.com/search?q="),
		  new SearchSpec("Yahoo", "http://search.yahoo.com/bin/search?p="),
		  new SearchSpec("Lycos", "http://search.lycos.com/web?q="),
		  new SearchSpec("Bing", "http://bing.com/search?q="),
		};
	
	
	public static SearchSpec[] getCommonSpecs() {
		return commonSpecs;
	} // end getCommonSpecs()
	
	
	/**
	 * Given a search engine name and a search string, builds
	 * a URL for the results page of that search engine
	 * for that query.  Returns null if the search engine name
	 * is not one of the ones it knows about.
	 */
	public static String makeURL(String searchEngineName, String searchString) {
		
		SearchSpec[] searchSpecs = getCommonSpecs();
		String searchURL = null;
		for (int i = 0; i < searchSpecs.length; i++) {
			SearchSpec spec = searchSpecs[i];
			if (spec.getName().equalsIgnoreCase(searchEngineName)) {
				searchURL = spec.makeURL(searchString);
				break;
			} // end if
	
		} // end for/loop
		
		return searchURL;
		
	} // end makeURL
	
}
