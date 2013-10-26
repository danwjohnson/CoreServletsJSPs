package com.coreservlets.chap04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Servlet that handles previewing and storing resumes
 * submitted by job applicants
 */

public class SubmitResume extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
					HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (request.getParameter("previewButton") != null) {
			showPreview(request, out);
		} else {
			storeResume(request);
			showConfirmation(request, out);
		} // end if/else
		
	} // end doGet()
	
	
	/**
	 * Shows a preview of the submitted resume.  Takes
	 * the font information and builds an HTML
	 * style sheet out of it, then takes the real
	 * resume information and presents it formatted with
	 * that style sheet
	 */
	
	private void showPreview(HttpServletRequest request, 
			PrintWriter out) {
		
		String headingFont = request.getParameter("headingFont");
		headingFont = replaceIfMissingOrDefault(headingFont, "");
		int headingSize = getSize(request.getParameter("headingSize"), 32);
		String bodyFont = request.getParameter("bodyFont");
		bodyFont = replaceIfMissingOrDefault(bodyFont, "");
		int bodySize = getSize(request.getParameter("bodySize"), 18);
		String fgColor = request.getParameter("fgColor");
		fgColor = replaceIfMissing(fgColor, "BLACK");
		String bgColor = request.getParameter("bgColor");
		bgColor = replaceIfMissing(bgColor, "WHITE");
		String name = request.getParameter("name");
		name = replaceIfMissing(name,"Lou Zer");
		String title = request.getParameter("title");
		title = replaceIfMissing(title, "Loser");
		String email = request.getParameter("email");
		email = repalceIfMissing(email, "contact@hot-computer-jobs.com");
		String languages = request.getParameter("languages");
		String skills = request.getParameter("skills");
		skills = replaceIfMissing(skills, "Not many, obviously.");
		out.println(
				ServletUtilities.DOCTYPE + "\n" +
				"<HTML><HEAD><TITLE>Resume for " + name + "</TITLE>\n" +
				makeStyleSheet(headingFont, headingSize, 
							bodyFont, bodySize,
							fgColor, bgColor) + "\n" +
				"</HEAD>\n" +
				"<BODY> \n" +
				"<CENTER>\n" +
				"<SPAN CLASS=\"HEADING1\">" + name + "</SPAN><BR>\n" +
				"<SPAN CLASS=\"HEADING2\">" + title + "<BR>\n" +
				"<A HREF=\"mailto:" + email + "\">" + email +
					"</A></SPAN>\n" +
				"</CENTER><BR><BR>\n" +
				"<SPAN CLASS=\"HEADING3\">Programming Languages" +
				"</SPAN>\n" +
				makeList(languages) + "<BR><BR>\n" +
				"<SPAN CLASS=\"HEADING3\">Skills and Experience" +
				"</SPAN><BR><BR>\n" +
				skills + "\n" +
				"</BODY></HTML>");
		
	} // end showPreview()
	
	
	/**
	 * Builds a cascading style sheet with information
	 * on the three levels of headings and overall
	 * foreground and background cover.  Also tells
	 * the browser to change color of mail to link
	 * when mouse moves over it.
	 */
	
	private String makeStyleSheet(String headingFont,
								int headingSize,
								String bodyFont,
								int bodySize,
								String fgColor,
								String bgColor) {
	
		int heading2Size = headingSize*7/10;
		int heading3Size = headingSize*6/10;
		String styleSheet =
				"<STYLE TYPE=\"text/css\">\n" +
				"<!--\n" +
				".HEADING1 { font-size: " + headingSize + "px;\n" +
				"			 font-weight: bold;\n" +
				"			 font-family: " + headingFont;	
		
		// TODO - pick up from here.
		
		return styleSheet;
		
	}
	
} // end SubmitResume class
