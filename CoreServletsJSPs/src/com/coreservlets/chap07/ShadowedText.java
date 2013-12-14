package com.coreservlets.chap07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coreservlets.chap03.ServletUtilities;

/**
 * Servlet that generates JPEG images representing
 * a designated message with an oblique-shadowed
 * version behind it.
 * @author dj
 *
 */

public class ShadowedText extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
				 	  HttpServletResponse response)
		throws ServletException, IOException {
		
		String wantsList = request.getParameter("showList");
		if (wantsList != null)
			showFontList(response);
		else{
			
			String message = request.getParameter("message");
			if ((message == null) || (message.length() == 0))
				message = "Missing 'message' parameter";
			
			String fontName = request.getParameter("fontName");
			if ((fontName == null) || (fontName.length() == 0))
				fontName = "Serif";
			
			String fontSizeString = request.getParameter("fontSize");
			int fontSize;
			try {
				fontSize = Integer.parseInt(fontSizeString);
			} catch(NumberFormatException nfe) {
				fontSize = 90;
			} // end try/catch
			
			response.setContentType("image/jpeg");
			MessageImage.writeJPEG(MessageImage.makeMessageImage(
					message, fontName, fontSize),
					response.getOutputStream());
		} // end if/else
		
	} // end doGet()
	
	
	private void showFontList(HttpServletResponse response) 
		throws IOException {
		
		PrintWriter out = response.getWriter();
		String title = "Fonts Available on Server";
		out.println(ServletUtilities.headWithTitle(title) +
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN=CENTER>" + title + "</H1>\n" +
				"<UL>");
		
		String[] fontNames = MessageImage.getFontNames();
		for (int i = 0; i < fontNames.length; i++)
			out.println("  <LI>" + fontNames[i]);
		
		out.println("</UL>\n" + "</BODY></HTML>");
		
	} // end showFontList()
	
} // end ShadowedText class
