package menucreate;

import abstractinterfaces.Formatter;

public class FormatFactory {

	public Formatter createFormat(String type)
	{
		if(type.equalsIgnoreCase("TEXT"))
			return new TextFormatter();
		else if(type.equalsIgnoreCase("XML"))
			return new XMLFormatter();
		else
			return new HTMLFormatter();
	}
	
}
