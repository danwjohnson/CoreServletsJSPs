package com.coreservlets.chap04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Servlet that reads a code snippet from the request
 * and displays it inside a PRE tag.  Fails to filter
 * the special HTML characters.
 */

public class BadCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
					HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Code Sample";
		out.println(ServletUtilities.headWithTitle(title) + 
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
				"<PRE>\n" +
				getCode(request) +
				"</PRE>\n" +
				"Now, wasn't that an interesting sample\n" +
				"of code?\n" +
				"</BODY></HTML>");
		
	} // end doGet()

	
	protected String getCode(HttpServletRequest request) {
		return(request.getParameter("code"));
	} // end getCode()
	
} // end BadCodeServlet class
