package menucreate;
import java.util.*;
import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import abstractinterfaces.Formatter;

public class XMLFormatter implements Formatter{
	
	public void format(Food f)
	{
		try {
			String category=f.getFoodItemData().get(0).getCategory();
			String currency="";
			if(f.getFoodItemData().get(0).getCountry().equalsIgnoreCase("GB"))
				currency="GBP";
			else
				currency="$";
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("MenuItems");
			doc.appendChild(rootElement);
	 
			// staff elements
			Element MenuCategory = doc.createElement("MenuCategory");
			rootElement.appendChild(MenuCategory);
	 
			// set attribute to staff element
			Attr attr = doc.createAttribute("category");
			attr.setValue(category);
			MenuCategory.setAttributeNode(attr);
	 
			// shorten way
			// staff.setAttribute("id", "1");
			for(Menu m : f.getFoodItemData())
			{
			if(!category.equalsIgnoreCase(m.getCategory()))
			{
				MenuCategory = doc.createElement("MenuCategory");
				rootElement.appendChild(MenuCategory);
				// set attribute to staff element
				attr = doc.createAttribute("category");
				attr.setValue(m.getCategory());
				MenuCategory.setAttributeNode(attr);
			}
			category=m.getCategory();
			
			Element MenuItem = doc.createElement("MenuItem");
			MenuCategory.appendChild(MenuItem);
	 
			// lastname elements
			Element Name = doc.createElement("Name");
			Name.appendChild(doc.createTextNode(m.getName()));
			MenuItem.appendChild(Name);
			// nickname elements
			Element Price = doc.createElement("Price");
			MenuItem.appendChild(Price);
	 
			Element Currency = doc.createElement("CurrencyCode");
			Currency.appendChild(doc.createTextNode(currency));
			Price.appendChild(Currency);
			
			Element Amount = doc.createElement("Amount");
			Amount.appendChild(doc.createTextNode(String.valueOf(m.getPrice())));
			Price.appendChild(Amount);
			
			Element Desc = doc.createElement("Description");
			Desc.appendChild(doc.createTextNode(m.getDescription()));
			MenuItem.appendChild(Desc);
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("MenuXML.xml"));
			
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(source, result);
	 
			System.out.println("File saved!");
	 
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
	}

}
