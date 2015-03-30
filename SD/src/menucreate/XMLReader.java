package menucreate;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.*;

import org.w3c.dom.*;

import abstractinterfaces.Reader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

public class XMLReader implements Reader{
	
	public Food reader(String country)
	{
		  try {
		    	 Food food=new Food(); 
		    	ArrayList<Menu> flist=new ArrayList<Menu>();
		    	File fXmlFile = new File("FoodItemXML.xml");
		    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    	Document doc = dBuilder.parse(fXmlFile);
		     
		    	doc.getDocumentElement().normalize();
		     
		    	NodeList nList = doc.getElementsByTagName("FoodItem");
		     
		    	for (int temp = 0; temp < nList.getLength(); temp++) {
		     
		    		Menu e=new Menu();
		    		Node nNode = nList.item(temp);
		     
		    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		     
		    			Element eElement = (Element) nNode;
		    			if(eElement.getAttribute("country").toString().equalsIgnoreCase(country))
		    			{
		    			e.setCountry(eElement.getAttribute("country"));
		    			e.setId(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
		    			e.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
		    			e.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());
		    			e.setCategory(eElement.getElementsByTagName("category").item(0).getTextContent());
		    			e.setPrice(Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()));
		    			flist.add(e);
		    			}
		    		}
		    	}
		    	food.setFoodItemData(flist);
	
		    	return food;
		        } catch (Exception e) {
		    	e.printStackTrace();
		    	return null;
		        }
	}

}
