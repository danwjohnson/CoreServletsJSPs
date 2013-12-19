package com.coreservlets.chap09;

/**
 * A specialization of the CatalogPage servlet that
 * displays a page selling two famous computer books.
 * Orders are sent to the OrderPage servlet.
 * @author DJ
 *
 */

public class TechBooksPage extends CatalogPage{

	private static final long serialVersionUID = 1L;

	public void init() {
		
		String[] ids = { "hall001", "hall002" };
		setItems(ids);
		setTitle("All-Time Best Computer Books");
		
	} // end init()
	
} // end TechBooksPage class
