package com.coreservlets.chap05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that displays referrer-specific image.
 * @author DJ
 *
 */

public class CustomizeImage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
					  HttpServletResponse response) 
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String referer = request.getHeader("Referer");
		out.println("Referer = " + referer);
		
	}
	
	
} // end CustomizeImage class
