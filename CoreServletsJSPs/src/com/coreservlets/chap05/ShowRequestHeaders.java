package com.coreservlets.chap05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/** Shows all the request headers sent on the current request */

public class ShowRequestHeaders extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
					HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Servlet Example: Showing Request Headers";
		out.println(ServletUtilities.headWithTitle(title) + 
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
				"<B>Request Method: </B>" +
				request.getMethod() + "<BR>\n" +
				"<B>Request URI: </B>" +
				request.getRequestURI() + "<BR>\n" +
				"<B>Request Protocol: </B>" +
				request.getProtocol() + "<BR><BR>\n" +
				"<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
				"<TR BGCOLOR=\"#FFAD00\">\n" +
				"<TH>Header Name<TH>Header Value");
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			
			String headerName = (String)headerNames.nextElement();
			out.println("<TR><TD>" + headerName);
			out.println("    <TD>" + request.getHeader(headerName));
			
		} // end while loop
		
		out.println("</TABLE>\n</BODY></HTML>");
		
	} // end doGet()
	
	
	/**
	 * Since this servlet is for debugging, have it handle
	 * GET and POST identically
	 */
	
	public void doPost(HttpServletRequest request,
					HttpServletResponse response)
		throws ServletException, IOException {
		
		doGet(request, response);
		
	} // end doPost
	
} // end ShowRequestHeaders class
