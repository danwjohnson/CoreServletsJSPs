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
 * Creates a table of the cookies associated with
 * the current page.  Also sets six cookies: three
 * that apply only to the current session
 * (regardless of how long that session lasts)
 * and three that persist for an hour (regardless
 * of whether the browser is restarted)
 * @author DJ
 *
 */

public class CookieTest extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, 
					  HttpServletResponse response)
		throws ServletException, IOException {
		
		for (int i=0; i < 3; i++) {
			// Default maxAge is -1, indicating cookie
			// applies only to current browsing session.
			Cookie cookie = new Cookie("Session-Cookie-" + i,
									  "Cookie-Value-S" + i);
			response.addCookie(cookie);
			
			cookie = new Cookie("Persistent-Cookie-" + i,
							    "Cookie-Value-P" + i);
			// Cookie is valid for an hour, regardless of whether
			// user quits browser, reboots computer, or whatever.
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
			
		} // end for loop to add 6 cookies
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String title = "Active Cookies";
		out.println(ServletUtilities.headWithTitle(title) + 
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
				"<TABLE BORDER=1 ALIGN=\"CENTER\">\n" + 
				"<TR BGCOLOR=\"#FFAD00\">\n" +
				"  <TH>Cookie Name\n" +
				"  <TH>Cookie Value");
		
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			out.println("<TR><TH COLSPAN=2>No cookies");
		} else {
			Cookie cookie;
			for(int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				out.println("<TR>\n" +
						"  <TD>" + cookie.getName() + "\n" +
						"  <TD>" + cookie.getValue());
			} // end for loop
			
		} // end if/else
		
		out.println("</TABLE></BODY></HTML>");
		
	} // end doGet()

} // end CookieTest class
