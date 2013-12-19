package com.coreservlets.chap09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Base class for pages showing catalog entries.
 * Servlets that extend this class must specify
 * the catalog entries that they are selling and the page
 * title <i>before</i> the servlet is ever accessed.  This
 * is done by putting calls to setItems and setTitle
 * in init.
 * @author DJ
 *
 */

public abstract class CatalogPage extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private CatalogItem[] items;
	private String[] itemIDs;
	private String title;
	
	/**
	 * Given an array of item IDs, look them up in the
	 * Catalog and put their corresponding CatalogItem entry
	 * into the items array.  The CatalogItem contains a short
	 * description, long description, and a price,
	 * using the item ID as the unique key.
	 * <p>
	 * Servlets that extend CatalogPage <b>must</b> call
	 * this method (usually from init) before the servlet
	 * is accessed.
	 */
	
	protected void setItems(String[] itemIDs) {
		
		this.itemIDs = itemIDs;
		items = new CatalogItem[itemIDs.length];
		for(int i = 0; i < items.length; i++)
			items[i] = Catalog.getItem(itemIDs[i]);
		
	} // end setItems()
	
	
	/**
	 * Sets the page title, which is displayed in
	 * an H1 heading in resultant page.
	 * <p>
	 * Servlets that extend CatalogPage <b>must</b> call
	 * this method (usually from init) before the servlet
	 * is accessed.
	 */
	
	protected void setTitle(String title) {
		this.title = title;
	} // end setTitle()
	
	
	/**
	 * First display title, then, for each catalog item,
	 * put its short description in a level-two (h2) heading
	 * with the price in parentheses and long description
	 * below.  Below each entry, put an order button
	 * that submits info the the OrderPage servlet for 
	 * the associated catalog entry.
	 * <p>
	 * To see the HTML that results from this method, do
	 * "View Source" on KidsBookPage or TechBooksPage, two
	 * concrete classes that extend this abstract class.
	 */
	
	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
		throws ServletException, IOException {
		
		if (items == null) {
			
			response.sendError(response.SC_NOT_FOUND, "Missing Items.");
			return;
		
		} // end if
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(ServletUtilities.headWithTitle(title) +
				"<BODY BGCOLOR=\"FDF5E6\">\n" +
				"<H1 ALIGN=\"CENTER\">" + title + "</H1>");
		CatalogItem item;
		for(int i = 0; i < items.length; i++) {
			
			out.println("<HR>");
			item = items[i];
			// Show error message if subclass lists item ID
			// that's not in the catalog
			if ( item == null ) {
				
				out.println("<FONT COLOR=\"RED\">" +
							"Unknown item ID " + itemIDs[i] +
							"</FONT>");
				
			} else {
				
				out.println();
				String formURL =
						"/CoreServletsJSPs/servlet/OrderPage";
				// Pass URLs that reference own site through encodeURL.
				formURL = response.encodeURL(formURL);
				out.println(
						"<FORM ACTION=\"" + formURL + "\">\n" +
						"<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\" " +
						"       VALUE=\"" + item.getItemID() + "\">\n" +
						"<H2>" + item.getShortDescription() +
						" ($" + item.getCost() + ")</H2>\n" +
						item.getLongDescription() + "\n" +
						"<P>\n<CENTER>\n" +
						"<INPUT TYPE = \"SUBMIT\" " +
						"VALUE=\"Add to Shopping Cart\">\n" +
						"</CENTER>\n<P>\n</FORM>");
						
			} // end if/else
			
		} // end for loop
		
		out.println("<HR>\n</BODY></HTML>");
		
	} // end doGet()
	
} // end CatalogPage
