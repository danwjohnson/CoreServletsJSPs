package com.coreservlets.chap04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;
import com.coreservlets.chap04.beans.BidInfo;

/**
 * Example of simplified form processing.  Shows two features:
 * 
 * <OL>
 * 	<LI>Automatically filling in a bean based on the
 * 		incoming request parameters
 * 	<LI>Using the same servlet both to generate the input
 * 		form and to process the results.  That way, when
 * 		fields are omitted, the servlet can redisplay the
 * 		form without making the use reenter previously
 * 		entered values.
 * </OL>
 * 
 */

public class BidServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Try to populate a bean that represents information
	 * in the form data sent by the user.  If this data is
	 * complete, show the results.  If the form data is
	 * missing or incomplete, display the HTML form
	 * that gathers the data.
	 */
	
	public void doGet(HttpServletRequest request,
					HttpServletResponse response)
		throws ServletException, IOException {
		
		BidInfo bid = new BidInfo();
		BeanUtilities.populateBean(bid, request);
		if (bid.isComplete()) {
			
			// All required form data was supplied: show result.
			showBid(request, response, bid);
			
		} else {
			
			// Form data was missing or incomplete: redisplay form.
			showEntryForm(request, response, bid);
		
		} // end if/else
		
	} // end doGet()

	
	/** All required data is present: show the results page. */
	
	private void showBid(HttpServletRequest request,
						HttpServletResponse response,
						BidInfo bid)
		throws ServletException, IOException {
		
		submitBid(bid);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Bid Submitted";
		out.println(ServletUtilities.headWithTitle(title) +
				"<BODY BGCOLOR=\"#FDF5E6\"><CENTER>\n" +
				"<H1>" + title + "</H1>\n" +
				"Your bid is now active.  If your bid is successful,\n" +
				"you will be notified within 24 hours of the close\n" +
				"of bidding.\n" +
				"<P>\n" +
				"<TABLE BORDER=1\n" +
				"  <TR><TH BGCOLOR=\"BLACK\"><FONT COLOR=\"WHITE\">" +
				bid.getItemName() + "</FONT>\n" +
				"  <TR><TH>Item ID: " +
				bid.getItemID() + "\n" +
				"  <TR><TH>Name: " +
				bid.getBidderName() + "\n" +
				"  <TR><TH>Email Address: " +
				bid.getEmailAddress() + "\n" +
				"  <TR><TH>Bid Price: " +
				bid.getBidPrice() + "\n" +
				"  <TR><TH>Auto-Increment price: " +
				bid.isAutoIncrement() + "\n" +
				"</TABLE></CENTER></BODY></HTML>");
		
	} // end showBid()
	
	
	/**
	 * If the required data is totally missing, show a blank
	 * form.  If the required data is partially missing,
	 * warn the user, fill in form fields that already have
	 * values, and prompt user for missing fields.
	 */
	
	private void showEntryForm(HttpServletRequest request,
						HttpServletResponse response,
						BidInfo bid)
		throws ServletException, IOException {
		
		boolean isPartlyComplete = bid.isPartlyComplete();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Welcome to Auctions-R-Us.  Please Enter Bid.";
		out.println(ServletUtilities.headWithTitle(title) +
				"<BODY BGCOLOR=\"#FDF5E6\"><CENTER>\n" +
				"<H1>" + title + "</H1>\n" +
				warning(isPartlyComplete) +
				"<FORM>\n" +
				inputElement("Item ID", "itemID",
						bid.getItemID(), isPartlyComplete) +
				inputElement("Item Name", "itemName",
						bid.getItemName(), isPartlyComplete) +
				inputElement("Your Name", "bidderName",
						bid.getBidderName(), isPartlyComplete) +
				inputElement("Your Email Address", "emailAddress",
						bid.getEmailAddress(), isPartlyComplete) +
				inputElement("Amount Bid", "bidPrice", 
						bid.getBidPrice(), isPartlyComplete) +
				checkBox("Auto-increment bid to match other bidders?",
						"autoIncrement", bid.isAutoIncrement()) +
				"<INPUT TYPE=\"SUBMIT\" VALUE=\"Submit Bid\">\n" +
				"</CENTER></BODY></HTML>");
		
	} // end ShowEntryForm()
	
	
	private void submitBid(BidInfo bid) {
		
		// Some application-specific code to record the bid.
		// The point is that you pass in a real object with
		// properties populated, not a bunch of strings.
		
	} // end submitBid()
	
	
	private String warning(boolean isFormPartlyComplete) {
		
		if (isFormPartlyComplete) {
			
			return("<H2>Required Data Missing! " +
					"Enter and Resubmit.</H2>\n");
			
		} else {
			
			return "";
			
		} // end if/else
		
	} // end warning()
	
	
	/**
	 * Create a textfield for input, prefaced by a prompt.
	 * If this particular textfield is missing a value but
	 * other fields have values (i.e., a partially filled form
	 * was submitted), then add a warning telling the user that
	 * this textfield is required.
	 */
	
	private String inputElement(String prompt,
								String name,
								String value,
								boolean shouldPrompt) {
		
		String message = "";
		if (shouldPrompt && ((value == null) || value.equals(""))) {
			
			message = "<B>Required field!</B>";
			
		} // end if
		return (message + prompt + ": " +
				"<INPUT TYPE=\"TEXT\" NAME=\"" + name + "\"" +
				" VALUE=\"" + value + "\"><BR>\n");
	
	} // end inputElement()
	
	
	private String inputElement(String prompt,
								String name,
								double value,
								boolean shouldPrompt) {
		
		String num;
		if (value == 0.0) {
		
			num = "";
			
		} else {
			
			num = String.valueOf(value);
			
		} // end if/else
		
		return(inputElement(prompt, name, num, shouldPrompt));
		
	} // end inputElement()
	
	
	private String checkBox(String prompt,
							String name,
							boolean isChecked) {
		
		String result =
			prompt + ": " +
			"<INPUT TYPE=\"CHECKBOX\" NAME=\"" + name + "\"";
		if (isChecked)
			result = result + " CHECKED";
		result = result + "><BR>\n";
		
		return result;
	}
	
} // end BidServlet class
