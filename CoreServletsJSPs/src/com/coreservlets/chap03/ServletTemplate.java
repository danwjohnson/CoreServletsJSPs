package com.coreservlets.chap03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTemplate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		// Use 'request' to read incoming HTTP headers
		// (e.g., cookies) and query data from HTML forms
		
		// Use 'response' to specify the HTTP response status
		// code and headers (e.g., the content type, cookies)
		
		PrintWriter out = response.getWriter();
		// Use 'out' to send content to the browser
		
	} // end doGet()

} // end ServletTemplate
