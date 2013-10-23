package com.coreservlets.chap03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet3 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();
		String title = "Hello (3)";
		out.println(ServletUtilities.headWithTitle(title) + 
				"<BODY BGCOLOR=\"#FDF5E6\">\n" + 
				"<H1>" + title + "</H1>\n" +
				"</BODY></HTML>");
		
	} // end doGet()

} // end HelloServlet3 class
