package com.coreservlets.chap06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Servlet that builds the HTML form that gathers input
 * for the search engine servlet.  This servlet first
 * displays a textfield for the search query, then looks up
 * the search engine names known to the SearchUtilites and
 * displays a list of radio buttons, one for each search
 * engine.
 * @author DJ
 *
 */

public class SearchEngineForm extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "One-Stop Web Search";
		String actionURL = "SearchEngines";
		out.println(ServletUtilities.headWithTitle(title) +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<CENTER>\n" + 
				"<H1>" + title + "</H1>\n" +
				"<FORM ACTION=\"" + actionURL + "\">\n" +
				"  Search keywords: \n" +
				"  <INPUT TYPE =\"TEXT\" NAME=\"searchString\"><P>\n");
		
		SearchSpec[] specs = SearchUtilities.getCommonSpecs();
		for(int i = 0; i < specs.length; i++) {
			
			String searchEngineName = specs[i].getName();
			out.println("<INPUT TYPE=\"RADIO\" " +
						"NAME=\"searchEngine\" " +
						"VALUE=\"" + searchEngineName + "\">\n");
			out.println(searchEngineName + "<BR>\n");
			
		} // end for loop to display available search engines
		
		out.println(
				"<BR>  <INPUT TYPE=\"SUBMIT\">\n" +
				"</FORM>\n" +
				"</CENTER></BODY></HTML>");
		
	} // end doGet()
	
} // end SearchEngineForm class
