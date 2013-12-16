package com.coreservlets.chap08;

import javax.servlet.http.Cookie;

/**
 * Cookie that persists 1 year.  Default cookie doesn't
 * persist past current browsing session.
 * @author DJ
 *
 */

public class LongLivedCookie extends Cookie{

	private static final long serialVersionUID = 1L;

	public static final int SECONDS_PER_YEAR = 60 * 60 * 24 * 365;
	
	public LongLivedCookie(String name, String value) {
		
		super(name, value);
		setMaxAge(SECONDS_PER_YEAR);
		
	} // end constructor
	
} // end LongLivedCookie class
