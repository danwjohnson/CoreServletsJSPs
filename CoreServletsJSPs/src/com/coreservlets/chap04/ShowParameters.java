package com.coreservlets.chap04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Shows all the parameters sent to the servlet via either
 * GET or POST.  Specially marks parameters that have 
 * no values or multiple values.
 */

public class ShowParameters extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
					HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();
		String title = "Reading All Request Parameters";
		out.println(ServletUtilities.headWithTitle(title) +
				"<BODY BGCOLOR=\"#FDF5E^\">\n" +
				"<H1 ALIGN=CENTER>" + title + "</H1>\n" +
				"<TABLE BORDER=1 ALIGN=CENTER>\n" +
				"<TR BGCOLO\"#FFADOO\">\n" +
				"<TH>Parameter Name<TH>Parameter Value(s)");
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			
			String paramName = (String)paramNames.nextElement();
			out.print("<TR><TD>" + paramName + "\n<TD>");
			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() == 0)
					out.println("<I>No Value</I>");
				else
					out.println(paramValue);
			} else {
				out.println("<UL>");
				for(int i=0; i<paramValues.length; i++) {
					out.println("<LI>" + paramValues[i]);
				} // end for loop
				
				out.println("</UL>");
			
			} // end if/else
			
		} // end while loop
		
		out.println("</TABLE>\n</BODY></HTML>");
		
	} // end doGet()

	
	public void doPost(HttpServletRequest request,
					HttpServletResponse response)
		throws ServletException, IOException {
		
		doGet(request, response);
		
	} // end doPost()
	
} // end ShowParamters class
