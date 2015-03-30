package menucreate;

import java.io.PrintWriter;

import abstractinterfaces.Formatter;

public class TextFormatter implements Formatter{
	
	public void format(Food f)
	{
		try
		{
		boolean flag=false;
		String category="";
		String currency="";
		PrintWriter writer = new PrintWriter("MenuText.txt", "UTF-8");
		for(Menu m : f.getFoodItemData())
		{
			if(flag==false)
			{
				currency=m.getCountry();
				if(currency.equalsIgnoreCase("GB"))
					currency="GBP";
				else
					currency="$";
				
				category=m.getCategory().toUpperCase().toString();
				writer.println(category+"\n");
				writer.println();
				writer.println(m.getName()+"\t\t\t\t"+currency+" "+m.getPrice());
				writer.println(m.getDescription()+"\n");
				writer.println();
				flag=true;
			}
			else if(flag==true)
			{
				if(m.getCategory().equalsIgnoreCase(category))
				{	
					writer.println(m.getName()+"\t\t\t\t"+currency+" "+m.getPrice());
					writer.println(m.getDescription()+"\n");
					writer.println();
				}
				else 
				{
					category=m.getCategory().toUpperCase().toString();
					writer.println(category+"\n");
					writer.println();
					writer.println(m.getName()+"\t\t\t\t"+currency+" "+m.getPrice());
					writer.println(m.getDescription()+"\n");
					writer.println();
				}
			}
				
		}
		writer.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
