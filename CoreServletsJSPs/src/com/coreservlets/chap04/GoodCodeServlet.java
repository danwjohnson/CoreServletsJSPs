package com.coreservlets.chap04;

import javax.servlet.http.HttpServletRequest;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Servlet that reads a code snippet from the request and displays
 * it inside a PRE tag.  Filters the special HTMl characters
 */

public class GoodCodeServlet extends BadCodeServlet {

	private static final long serialVersionUID = 1L;

	protected String getCode(HttpServletRequest request) {
		return(ServletUtilities.filter(super.getCode(request)));
	} // end getCode()

} // end GoodCodeServlet class
