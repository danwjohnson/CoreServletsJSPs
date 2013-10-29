package com.coreservlets.chap05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Servlet with <B>long</B> output.  Used to test
 * the effect of the gzip compression
 */

public class LongServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,
					HttpServletResponse response)
		throws ServletException, IOException {
		
		// Change the definition of "out" depending on whether
		// or not gzip is supported.
		PrintWriter out;
		if (GzipUtilities.isGzipSupported(request) &&
				!GzipUtilities.isGzipDisabled(request)) {
			
			out = GzipUtilities.getGzipWriter(response);
			response.setHeader("Content-Encoding", "gzip");
			
		} else {
			
			out = response.getWriter();
			
		} // end if/else
		
		
		// Once "out" has been assigned appropriately, the
		// rest of the page has no dependencies on the type
		// of writer being used.
		String title = "Long Page";
		
		out.println(ServletUtilities.headWithTitle(title) +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN=\"CENTER\">" + title + "</H1>\n");
		String line = "Blah, blah, blah, blah, blah. " +
				"Yadda, yadda, yadda, yadda.";
		for (int i = 0; i < 10000; i++)
			out.println(line);
		
		out.println("</BODY></HTML>");
		out.close();		// Needed fo gzip; optional otherwise.
		
	} // end doGet()

} // end LongServlet class
