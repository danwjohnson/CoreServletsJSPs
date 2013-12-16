package com.coreservlets.chap08;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Two static methods for use in cookie handling
 * @author DJ
 *
 */

public class CookieUtilities {

	/**
	 * Given the request object, a name, and a default value,
	 * this method tries to find the value of the cookie with
	 * the given name.  If no cookie matches the name,
	 * the default value is returned.
	 */
	
	public static String getCookieValue(HttpServletRequest request,
										String cookieName,
										String defaultValue) {
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			
			for(int i = 0; i < cookies.length; i++) {
				
				Cookie cookie = cookies[i];
				if (cookieName.equals(cookie.getName()))
					return(cookie.getValue());
				
			} // end for loop
			
		} // end if statement
		
		return defaultValue;
		
	} // end getCookieValue()
	
	
	/**
	 * Given the request object and a name, this method tries
	 * to find and return the cookie that has the given name.
	 * If no cookie matches the name, null is returned.
	 */
	
	public static Cookie getCookie(HttpServletRequest request,
								   String cookieName) {
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			
			for(int i = 0; i < cookies.length; i++) {
				
				Cookie cookie = cookies[i];
				if(cookieName.equals(cookie.getName()))
					return cookie;
				
			} // end for loop
			
		} // end if statement
		
		return null;
		
	} // end getCookie()
	
} // end CookieUtilities class
