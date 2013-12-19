package com.coreservlets.chap09;

/**
 * A specialization of the CatalogPage servlet that
 * displays a page selling three famous kids-book series.
 * Orders are sent to the OrderPage servlet.
 * @author DJ
 *
 */

public class KidsBookPage extends CatalogPage {

	private static final long serialVersionUID = 1L;

	public void init() {
		
		String[] ids = { "lewis001", "alexander001", "rowling001" };
		setItems(ids);
		setTitle("All-Time Best Children's Fantasy Books");
		
	} // end init()
	
} // end KidsBookPage class
