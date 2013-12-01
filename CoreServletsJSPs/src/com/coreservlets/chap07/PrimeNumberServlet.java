package com.coreservlets.chap07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Servlet that processes a request to generate n
 * prime numbers, each with at least m digits.
 * It performs the calculations in a low-priority background
 * thread, returning only the results it has found so far.
 * If these results are not complete, it sends a Refresh 
 * header instructing the browser to ask for new results a
 * little while later.  It also maintains a list of a
 * small number of previously calculated prime lists
 * to return immediately to anyone who supplies the same
 * n and m as a recently completed computation.
 * @author DJ
 *
 */

public class PrimeNumberServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private ArrayList primeListCollection = new ArrayList();
	private int maxPrimeLists = 30;

	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
		throws ServletException, IOException {
		
		int numPrimes =
				ServletUtilities.getIntParameter(request, "numPrimes", 50);
		
		int numDigits =
				ServletUtilities.getIntParameter(request, "numDigits", 120);
		
		PrimeList primeList =
				findPrimeList(primeListCollection, numPrimes, numDigits);
	
		if (primeList == null) {
			
			primeList = new PrimeList(numPrimes, numDigits, true);
			
			// Multiple servlet request threads share the instance
			// variables (fields) of PrimeNumbers.  So
			// synchronize all access to servlet fields
			synchronized(primeListCollection) {
				if (primeListCollection.size() >= maxPrimeLists)
					primeListCollection.remove(0);
				primeListCollection.add(primeList);
				
			} // end synchronized()
			
		} // end if to check if primeList is null
	
		ArrayList currentPrimes = primeList.getPrimes();
		int numCurrentPrimes = currentPrimes.size();
		int numPrimesRemaining = numPrimes = numCurrentPrimes;
		boolean isLastResult = (numPrimesRemaining == 0);
		if (!isLastResult) {
			response.setIntHeader("Refresh", 5);
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Some" + numDigits + "-Digit Prime Numbers";
		out.println(ServletUtilities.headWithTitle(title) + 
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H2 ALIGN=CENTER>" + title + "</H2>\n" +
				"<H3>Primes found with " + numDigits +
				" or more digits: " + numCurrentPrimes +
				".</H3>");
		
		if (isLastResult)
			out.println("<B>Done searching.</B>");
		else
			out.println("<B>Still looking for " + numPrimesRemaining +
					" more<BLINK>...</BLINK></B>");
		out.println("<OL>");
		for (int i = 0; i < numCurrentPrimes; i++)
			out.println("  <LI>" + currentPrimes.get(i));
		
		out.println("</OL>");
		out.println("</BODY></HTML>");
		
	} // end doGet()
	
	
	// See if there is an existing ongoing or completed 
	// calculation with the same number of primes and number
	// of digits per prime.  If so, return those results instead
	// of starting a new background thread.  Keep this list small so
	// that the Web server doesn't use too much memory.
	// Synchronize access to the list since there may be
	// multiple simultaneous request.
	private PrimeList findPrimeList(ArrayList primeListCollection,
									int numPrimes,
									int numDigits) {
		
		for (int i = 0; i < primeListCollection.size(); i++ ) {
			
			PrimeList primes =
					(PrimeList)primeListCollection.get(i);
			synchronized(primeListCollection) {
				
				if ((numPrimes == primes.numPrimes()) &&
					(numDigits == primes.numDigits()))
					return primes;
				
			} // end synchronized()
			
			return null;
			
		} // end for loop
		
		return null;
		
	} // end findPrimeList()
	
} // end PrimeNumberServlet class
