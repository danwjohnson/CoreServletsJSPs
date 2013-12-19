package com.coreservlets.chap09;

/** A catalog that lists the items available in inventory. */

public class Catalog {

	// This would come from a database in real life.
	// We use a static table for ease of testing and deployment.
	// See JDBC chapters for info on using databases in
	// servlets and JSP pages.
	private static CatalogItem[] items =
		{ new CatalogItem
			("hall001",
			 "<i>Core Servlets and JavaServer Pages " +
			 "2nd Edition</i> (Volume 1)" +
			 " by Marty Hall and Larry Brown",
			 "The definitive reference on servlets " +
			 "and JSP from Prentice Hall and \n" +
			 "Sun Microsystems Press.<p>Nominated for " +
			 "the Nobel Prize in Literature.", 39.95),
		  new CatalogItem
		  	("hall002",
		  	 "<i>Core Web Programming, 2nd Edition</i> " +
		  	 "by Marty Hall and Larry Brown",
		  	 "One stopp shopping for the Web Programmer. " +
		  	 "Topics include \n" +
		  	 "<ul><li>Thorough coverage of Jave 2; " +
		  	 "including Threads, Networking, Swing, \n" +
		  	 "Jave 2D, RMI, JDBC and Collections\n" +
		  	 "<li>A fast introduction to HTML 4.01, " +
		  	 "including frames, style sheets, and layers.\n" +
		  	 "<li>A fast introduction to HTTP 1.1, " +
		  	 "servlets, and JaveServer Pages.\n" +
		  	 "<li>A quick overview of JavaScript 1.2\n" +
		  	 "</ul>",
		  	 49.99),
		  new CatalogItem
		    ("lewis001",
		     "<i>The Chronicles of Narnia</i> by C.S. Lewis",
		     "The classic children's adventure pitting " +
		     "Aslan the Great Lion and his followers\n" +
		     "against the White Witch and the forces " +
		     "of evil.  Dragons, magicians, quests, \n" +
		     "and talking animals wound around a deep " +
		     "spiritual allegory.  Series includes\n" +
		     "<i>The Magician's Nephew</i>,\n" +
		     "<i>The Lion, the Witch and the Wardrode</i>,\n" +
		     "<i>The Horse and His Boy</i>,\n" +
		     "<i>Prince Caspian<i>,\n" +
		     "<i>The Voyage of the Dawn Treader</i>\n" +
		     "<i>The Silver Chair</i>\n" +
		     "<i>The Last Batlle</i>\n",
		     19.95),
		   new CatalogItem
		     ("alexander001",
		      "<i>The Prydain Series</i> by Lloyd Alexander",
		      "Humble pig-keeper Taran joins mighty " +
		      "Lord Gwydion in his battle against\n" +
		      "Arawn the Lord of Annuvin. Joined by " +
		      "his loyal friends the beautiful princess\n" +
		      "Eilonwy, wannabe bard Fflewddur Fflam, " +
		      "and furry half-man Gurgi, Taran discovers " +
		      "courage, nobility, and other values along\n" +
		      "the way.  Series includes\n" +
		      "<i>The Book oF Three</i>, \n" +
		      "<i>The Black Cauldron</i>, \n" +
		      "<i>The Castle of Llyr</i>, \n" +
		      "<i>Taran Wanderer</i>, and\n" +
		      "<i>The High King</i>.", 19.95),
		    new CatalogItem
		      ("rowling001",
		       "<i>The Harry Potter Series</i> by J.K. Rowling",
		       "The first five of the popular stories " +
		       "about wizard-in-training Harry Potter\n" +
		       "topped both the adult and children's " +
		       "best-seller lists.  Series includes\n" +
		       "<i>Harry Potter and the Sorcerer's Stone</i>,\n" +
		       "<i>Harry Potter and the Chamber of Secrets</i>,\n" +
		       "<i>Harry Potter and the Prisoners of Azkaban</i>,\n" +
		       "<i>Harry Potter and the Goblet of Fire</i>, and\n" +
		       "<i>Harry Potter and the Order of the Phoenix</i>.\n", 59.95)
		};
	
	
	public static CatalogItem getItem(String itemID) {
		
		CatalogItem item;
		if (itemID == null)
			return null;
		
		for(int i=0; i<items.length; i++) {
		
			item = items[i];
			if (itemID.equals(item.getItemID()))
				return item;
		
		} // end for loop
		
		return null;
		
	}
	
} // end Catalog class
