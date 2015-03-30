package menucreate;
import java.io.PrintWriter;

import abstractinterfaces.Formatter;

public class HTMLFormatter implements Formatter{
	
	public void format(Food f)
	{
		try
		{
		String category=f.getFoodItemData().get(0).getCategory();
		String country=f.getFoodItemData().get(0).getCountry();
		String currency="";
		if(f.getFoodItemData().get(0).getCountry().equalsIgnoreCase("GB"))
			currency="GBP";
		else
			currency="$";
		PrintWriter writer = new PrintWriter("MenuHTML.html", "UTF-8");
		writer.println("<HTML>");
		writer.println("<HEAD>");
		writer.println("\t<TITLE>Menu</TITLE>");
		writer.println("</HEAD>");
		writer.println("<BODY>");
		writer.println("<CENTER>Menu</CENTER>");
		writer.println("<H1>"+category.toUpperCase()+"</H1>");
		writer.println("<UL>");
		for(Menu m : f.getFoodItemData())
		{
			if(!category.equalsIgnoreCase(m.getCategory()))
			{	
				writer.println("</UL>");
				writer.println("<H1>"+m.getCategory().toUpperCase()+"</H1>");
				writer.println("<UL>");
			}
				category=m.getCategory();
			writer.println("<LI>");
			writer.println(m.getName());
			writer.println("<BR>");
			writer.println("<I>"+m.getDescription()+"</I><BR>"+currency+" "+m.getPrice()+"</LI><BR>");
				
		}
		writer.println("</UL>");
		writer.println("</BODY>");
		writer.println("</HTML>");
		writer.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
