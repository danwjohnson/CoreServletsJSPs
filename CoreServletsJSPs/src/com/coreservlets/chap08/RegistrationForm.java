package com.coreservlets.chap08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Servlet that displays an HTML form to collect user's
 * first name, last name, and email address.  Uses cookies
 * to determine the initial values of each of those
 * form fields
 * @author DJ
 *
 */

public class RegistrationForm extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String actionURL =
				"/CoreServletsJSPs/servlet/RegistrationServlet";
		
		String firstName =
				CookieUtilities.getCookieValue(request, "firstName", "");
		String lastName =
				CookieUtilities.getCookieValue(request, "lastName", "");
		String emailAddress =
				CookieUtilities.getCookieValue(request, "emailAddress", "");
		
		String title = "Please Register";
		
		out.println(ServletUtilities.headWithTitle(title) +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<CENTER>\n" +
				"<H1>" + title + "</H1>\n" +
				"<FORM ACTION=\"" + actionURL + "\">\n" +
				"First Name:\n" +
				"  <INPUT TYPE=\"TEXT\" NAME=\"firstName\" " +
						"VALUE=\"" + firstName + "\"><BR>\n" +
				"Last Name:\n" +
				"  <INPUT TYPE=\"TEXT\" NAME=\"lastName\" " + 
						"VALUE=\"" + lastName + "\"><BR>\n" +
				"Email Address: \n" + 
				"  <INPUT TYPE=\"TEXT\" NAME=\"emailAddress\" " +
						"VALUE=\"" + emailAddress + "\"><P>\n" +
				"<INPUT TYPE=\"SUBMIT\" VALUE=\"Register\">\n" +
				"</FORM></CENTER></BODY></HTML>");
		
	} // end doGet()

}
