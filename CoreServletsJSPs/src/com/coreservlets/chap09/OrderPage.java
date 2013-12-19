package com.coreservlets.chap09;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Shows all items currently in ShoppingCart.  Clients
 * have their own session that keeps track of which
 * ShoppingCart is theirs. If this is their first visit
 * to the order page, a new shopping cart is created.
 * Usually, people come to this page by way of a page
 * showing catalog entries, so this page adds an additional
 * item to the shopping cart.  But users can also 
 * bookmark this page, access it from their history list,
 * or be sent back to it by clicking on the "Update Order"
 * button after changing the number of items ordered.
 * @author DJ
 *
 */

public class OrderPage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
			       	  HttpServletResponse response)
		throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ShoppingCart cart;
		synchronized(session) {
			
			cart = (ShoppingCart)session.getAttribute("shoppingCart");
			
		} // end synchronized()
		
	}

}
