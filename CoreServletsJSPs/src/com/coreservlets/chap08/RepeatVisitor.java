package com.coreservlets.chap08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Servlet that says "Welcome aboard" to first-time
 * visitors and "Welcome back" to repeat visitors.
 * Also see RepeatVisitor2 for variation that uses
 * cookie utilities from later in this chapter
 * @author DJOHN74
 *
 */

public class RepeatVisitor extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
		throws ServletException, IOException {
		
		boolean newbie = true;
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			
			for (int i = 0; i < cookies.length; i++) {
				
				Cookie c = cookies[i];
				if ((c.getName().equals("repeatVisitor")) && 
						(c.getValue().equalsIgnoreCase("yes"))) {
					
					newbie = false;
					break;
					
				} // end if
				
			} // end for loop
			
		} // end if
		
		String title;
		if (newbie) {
			
			Cookie returnVisitorCookie =
					new Cookie("repeatVisitor", "yes");
			returnVisitorCookie.setMaxAge(60*60*24*365);  // 1 year
			response.addCookie(returnVisitorCookie);
			title = "Welcome aboard";
			
		} else {
			
			title = "Welcome back";
			
		} // end if/else
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(ServletUtilities.headWithTitle(title) +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALGIN=\"CENTER\">" + title + "</H1>\n" +
				"</BODY></HTML>");
		
	} // end doGet()
	
} // end RepeatVisitor class
