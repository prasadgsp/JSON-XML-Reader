package menucreate;

import abstractinterfaces.Reader;

public class ReaderFactory {
	
	public Reader createReader(String type)
	{
		if(type.equalsIgnoreCase("GB"))
			return new XMLReader();
		else
			return new JSONReader();
	}
	

}
