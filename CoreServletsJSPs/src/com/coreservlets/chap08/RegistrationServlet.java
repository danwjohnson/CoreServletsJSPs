package com.coreservlets.chap08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Servlet that processes a registration form containing
 * a user's first name, last name, and email address.
 * If all the values are present, the servlet displays the
 * values.  If any of the values are missing, the input
 * form is redisplayed.  Either way, the values are put 
 * into cookies so that the input form can use the
 * previous values.
 * @author DJ
 *
 */

public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		boolean isMissingValue = false;
		
		String firstName = request.getParameter("firstName");
		
		if (isMissing(firstName)) {
			firstName = "Missing first name";
			isMissingValue = true;
		} // end if
		
		String lastName = request.getParameter("lastName");
		
		if (isMissing(lastName)) {
			lastName = "Missing last name";
			isMissingValue = true;
		} // end if
		
		String emailAddress = request.getParameter("emailAddress");
		
		if (isMissing(emailAddress)) {
			emailAddress = "Missing email address";
			isMissingValue = true;
		} // end if
		
		Cookie c1 = new LongLivedCookie("firstName", firstName);
		response.addCookie(c1);
		Cookie c2 = new LongLivedCookie("lastName", lastName);
		response.addCookie(c2);
		Cookie c3 = new LongLivedCookie("emailAddress", emailAddress);
		response.addCookie(c3);
		
		String formAddress =
				"CoreServletsJSPs/servlet/RegistrationForm";
		
		if (isMissingValue) {
			response.sendRedirect(formAddress);
		} else {
			
			PrintWriter out = response.getWriter();
			String title = "Thanks for Registering";
			
			out.println(ServletUtilities.headWithTitle(title) + 
					"<BODY BGCOLOR=\"#FDF5E6\">\n" +
					"<CENTER>\n" +
					"<H1 ALIGN>" + title + "</H1>\n" +
					"<UL>\n" +
					"  <LI><B>First Name</B>: " +
							firstName + "\n" +
					"  <LI><B>Last Name</B>: " +
							lastName + "\n" +
					"  <LI><B>Email Address</B>: " +
							emailAddress + "\n" +
					"</UL>\n"+
					"</CENTER></BODY></HTML>");
			
		} // end if/else
		
	} // end doGet()
	
	
	/** Determines if value is null or empty. */
	
	private boolean isMissing(String param) {
		
		return ((param == null) ||
				(param.trim().equals("")));
		
	} // end isMissing()
	
} // end RegistraionServlet class
