package com.coreservlets.chap04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;
import com.coreservlets.chap04.beans.InsuranceInfo;

/**
 * Example of simplified form processing.  Illustrates the
 * use of BeanUtilities.populateBean to automatically fill
 * in a bean (Java object with methods that follow the
 * get/set naming convention) from request parameters.
 */

public class SubmitInsuranceInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, 
					HttpServletResponse response)
		throws ServletException, IOException {
		
		InsuranceInfo info = new InsuranceInfo();
		BeanUtilities.populateBean(info, request);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Insurance Info for " + info.getName();
		out.println(ServletUtilities.headWithTitle(title) + 
				"<BODY BGCOLOR=\"#FDF5E6\">\n" + 
				"<CENTER>\n" +
				"<H1>" + title + "</H1>\n" +
				"<UL>\n" +
				"  <LI>Employee ID: " +
					info.getEmployeeID() + "\n" +
				"  <LI>Number of children: " +
					info.getNumChildren() + "\n" +
				"  <LI>Married?: " + "\n" +
					info.isMarried() + "\n" +
				"</UL></CENTER></BODY></HTML>");
		
	} // end doGet()
	
} // end SubmitInsuranceInfo class
