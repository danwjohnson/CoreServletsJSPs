package com.coreservlets.chap06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that sends IE users to Google home page and
 * Netscape (and all other) users to the Microsoft home page.
 * @author DJ
 *
 */

public class WrongDestination extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
		throws ServletException, IOException {
		
		String userAgent = request.getHeader("User-Agent");
		if ((userAgent != null) && (userAgent.indexOf("MSIE") != -1)) {
			response.sendRedirect("http://www.google.com");
		} else {
			response.sendRedirect("http://www.microsoft.com");
		} // end if/else
		
	} // end doGet()
	
} // end WrongDestination class
