package com.coreservlets.chap09;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Servlet that displays a list of items being ordered.
 * Accumulates them in an ArrayList with no attempt at
 * detecting repeated items.  Used to demonstrate basic
 * session tracking.
 * @author DJ
 *
 */

public class ShowItems extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
		throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ArrayList previousItems =
				(ArrayList)session.getAttribute("previousItems");
		if (previousItems == null){
			previousItems = new ArrayList();
			session.setAttribute("previousItems", previousItems);
		} // end if
		
		String newItem = request.getParameter("newItem");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Items Purchased";
		
		out.println(ServletUtilities.headWithTitle(title) + 
				"<BODY BGCOLOR=\"FDF5E6\">\n" +
				"<H1>" + title + "</H1>");
		
		synchronized(previousItems) {
			
			if (newItem != null)
				previousItems.add(newItem);
			
			if (previousItems.size() ==0)
				out.println("<I>No items</I>");
			else {
				out.println("<UL>");
				for(int i = 0; i < previousItems.size(); i++)
					out.println("<LI>" + (String)previousItems.get(i));
				
				out.println("</UL>");
			}
			
			out.println("</BODY></HTML>");
			
		} // end synchronized
		
	} // end doGet()

} // end ShowItems class
