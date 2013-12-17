package com.coreservlets.chap09;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Servlet that uses session tracking to keep per-client
 * access counts.  Also shows other info about the session.
 * @author DJ
 *
 */

public class ShowSession extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		String heading;
		
		Integer accessCount =
				(Integer)session.getAttribute("accessCount");
		if (accessCount == null) {
			
			accessCount = new Integer(0);
			heading = "Welcome, Newcommer";
			
		} else {
			
			heading = "Welcome Back";
			accessCount = new Integer(accessCount.intValue() + 1);
			
		} // end if/else
		
		// Integer is an immutable data-structure.  So, you
		// cannot modify the old one in-place.  Instead, you
		// have to allocate a new one and redo setAttribute.
		session.setAttribute("accessCount", accessCount);
		PrintWriter out = response.getWriter();
		String title = "Session Tracking Example";
		
		out.println(ServletUtilities.headWithTitle(title) + 
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<CENTER>\n" +
				"<H1>" + heading + "</H1>\n" +
				"<H2>Information on Your Session:</H2>\n" +
				"<TABLE BORDER=1>\n" +
				"<TR BGCOLOR=\"#FFAD00\">\n" +
				"  <TH>Info Type<TH>Value\n" +
				"<TR>\n" +
				"  <TD>ID\n" +
				"  <TD>" + session.getId() + "\n" +
				"<TR>\n" +
				"  <TD>Creation Time\n" +
				"  <TD>" +
				new Date(session.getCreationTime()) + "\n" +
				"<TR>\n" +
				new Date(session.getLastAccessedTime()) + "\n" +
				"<TR>\n" +
				"  <TD>Number of Previous Accesses\n" +
				"  <TD>" + accessCount + "\n" +
				"</TABLE>\n" +
				"</CENTER></BODY></HTML>");
		
	} // end doGet()
	
} // end ShowSession class
