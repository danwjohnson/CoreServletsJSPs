package com.coreservlets.chap05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Servlet that gives browser-specific insult.
 * Illustrates how to use the User-Agent
 * header to tell browsers apart
 * @author DJ
 *
 */

public class BrowserInsult extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title, message;
		
		// Assume for simplicity that Netscape and IE are
		// the only two browsers.
		String userAgent = request.getHeader("User-Agent");
		if ((userAgent != null) &&
				(userAgent.indexOf("MSIE") != -1)) {
			
			title = "Microsoft Minion";
			message = "Welcome, O spineless slave to the " +
					"mighty empire.";
			
		} else {
			
			title = "Hopeless Netscape Rebel";
			message = "Enjoy it while you can. " +
					"You <I>will</I> be assimilated!";
			
		} // end if/else
		
		out.println(ServletUtilities.headWithTitle(title) + 
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN=CENTER>" + title + "</H1>\n" +
				message + "\n" +
				"</BODY></HTML>");
		
	} // end doGet()
	
} // end BrowserInsult class
