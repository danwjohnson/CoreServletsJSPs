package com.coreservlets.chap03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet (HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String docType = 
				"<!DOCTYPE HTML PUBLIC \" - //W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n";
		out.println(docType +
					"<HTML>\n" +
					"<HEAD><TITLE>Hello</TITLE></HEAD>\n" +
					"<BODY BGCOLOR=\"#FDF5E6\">\n" +
					"<H1>Hello</H1>\n" +
					"</BODY></HTML>");
		
	} // end doGet()
	
} // end HelloServlet class
