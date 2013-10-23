/**
 * Example using servlet initialization and the
 * getLastModified method.
 */
package com.coreservlets.chap03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LotteryNumbers extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private long modTime;
	private int[] numbers = new int[10];
	
	/**
	 * the init method is called only when the servlet is first
	 * loaded, before the first request is processed
	 */
	
	public void init() throws ServletException {
		
		// Round to nearest second (i.e., 1000 milliseconds)
		modTime = System.currentTimeMillis()/1000*1000;
		for (int i=0; i < numbers.length; i++) {
			
			numbers[i] = randomNum();
			
		} // end for loop
		
	} // end init()

	
	/** Return the list of numbers that init computed */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();
		String title = "Your Lottery Numbers";
		out.println(ServletUtilities.headWithTitle(title) +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN=CENTER>" + title + "</H1>\n" +
				"<B>Based upon extensive research of " +
				"astro-illogical trends, psychic farces, " +
				"and detailed statistical claptrap, " +
				"we have chosen the " + numbers.length +
				" best lottery numbers for you.</B>" +
				"<OL>");
		
		for (int i = 0; i < numbers.length; i++)
			out.println("  <LI>" + numbers[i]);
		
		out.println("</OL>" + 
					"</BODY></HTML>");
		
	} // end doGet()
	
	
	/** The standard service method compares this date against
	 *  any date specified in the If-Modified-Since request header.
	 *  If the getlastModified date is later or if there is no
	 *  If-Modified-Since header, the doGet method is called
	 *  normally.  But if the getLastModified date is the same or
	 *  earlier, the service method sends back a 304 (Not Modified)
	 *  response and does <B>not</B> call doGet.  The browser should
	 *  use its cached version of the page in such a case.
	 */
	
	public long getLastModified(HttpServletRequest request) {
		
		return(modTime);
		
	} // end getLastModified()
	
	// A random int from 0 to 99
	private int randomNum() {
		
		return((int)(Math.random() * 100));
		
	} // end randomNum()
	
} // end LotteryNumbers class
