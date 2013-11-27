package com.coreservlets.chap05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Creates a table showing the current value of each
 * of the standard CGI variables
 * @author DJ
 *
 */

public class ShowCGIVariables extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String [][] variables =
			{ { "AUTH_TYPE", request.getAuthType() },
			  { "CONTENT_LENGTH", String.valueOf(request.getContentLength()) },
			  { "DOCUMENT_ROOT", getServletContext().getRealPath("/") },
			  { "PATH_INFO", request.getPathInfo() },
			  { "PATH_TRANSLATED", request.getPathTranslated() },
			  { "QUERY_STRING", request.getQueryString() },
			  { "REMOTE_ADDR", request.getRemoteAddr() },
			  { "REMOTE_HOST", request.getRemoteHost() },
			  { "REMOTE_USER", request.getRemoteUser() },
			  { "REQUEST_METHOD", request.getMethod() },
			  { "SCRIPT_NAME", request.getServletPath() },
			  { "SERVER_NAME", request.getServerName() },
			  { "SERVER_PORT", String.valueOf(request.getServerPort()) },
			  { "SERVER_PROTOCOL", request.getProtocol() },
			  { "SERVER_SOFTWARE", getServletContext().getServerInfo() }
			};
		
		String title = "Servlet Example: Showing CGI Variables";
		out.println(ServletUtilities.headWithTitle(title) + 
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<CENTER>\n" +
				"<H1>" + title + "</H1>\n" +
				"<TABLE BORDER=1>\n" +
				"  <TR BGCOLOR=\"#FFAD00\">\n" +
				"	  <TH>CGI Variable Name<TH>Value");
		for(int i = 0; i < variables.length; i++) {
			
			 String varName = variables[i][0];
			 String varValue = variables[i][1];
			 if (varValue == null)
				 varValue = "<I>Not specified</I>";
			 out.println("  <TR><TD>" + varName + "<TD>" + varValue);
			
		} // end for loop
		
		out.println("</TABLE></CENTER></BODY></HTML>");
		
	} // end doGet()

	
	/** POST and GET request handled identically. */
	
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response)
		throws ServletException, IOException {
		
		doGet(request, response);
		
	} // end doPost()
}
