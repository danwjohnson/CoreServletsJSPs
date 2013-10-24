package com.coreservlets.chap03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	Servlet that attempts to give each user a unique
 *	user ID, However, because it fails to synchronize
 *	access to the nextID field, it suffers from race
 *	conditions: two users could get the same ID.
 */

public class UserIDs extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private int nextID = 0;
	
	public void doGet(HttpServletRequest request,
					HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();
		String title = "Your ID";
		out.println(ServletUtilities.headWithTitle(title) +
				"<CENTER>\n" +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1>" + title + "</H1>\n");
		String id = "User-ID-" + nextID;
		out.println("<H2>" + id + "</H2>");
		nextID = nextID + 1;
		out.println("</BODY></HTML>");
		
	} // end doGet()

} // end UserIDs class
