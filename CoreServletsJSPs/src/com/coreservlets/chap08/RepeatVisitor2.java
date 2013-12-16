package com.coreservlets.chap08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * A variation of the RepeatVisitor servlet that uses
 * CookieUtilities.getCookieValue and LongLivedCookie
 * to simplify the code
 * @author DJ
 *
 */

public class RepeatVisitor2 extends HttpServlet {
	
	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
		throws ServletException, IOException {
		
		boolean newbie = true;
		String value =
				CookieUtilities.getCookieValue(request, "repeatVisitor2", "no");
		
		if (value.equals("yes"))
			newbie = false;
		
		String title;
		if (newbie) {
			LongLivedCookie returnVisitorCookie =
					new LongLivedCookie("repeatVisitor2", "yes");
			response.addCookie(returnVisitorCookie);
			title = "Welcome Aboard";
			
		} else
			title = "Welcome Back";
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(ServletUtilities.headWithTitle(title) +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALGIN=\"CENTER\">" + title + "</H1>\n" +
				"</BODY></HTML>");
		
	} // end doGet()

}
