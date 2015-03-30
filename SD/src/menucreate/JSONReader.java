package menucreate;
import java.io.*;
import java.util.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import abstractinterfaces.Reader;


public class JSONReader implements Reader{

	public Food reader(String country)
	{
		ObjectMapper mapper = new ObjectMapper();
		 
		try {
	 
			// convert user object to json string, and save to a file
			Food food = mapper.readValue(new File("FoodItemJSON.json"), Food.class);
			Food food1=new Food();
			ArrayList<Menu> flist=new ArrayList<Menu>();
			
			for(int i=0;i<food.getFoodItemData().size();i++)
			{
				if(food.getFoodItemData().get(i).getCountry().equals(country))
				{
					flist.add(food.getFoodItemData().get(i));
				}
			}
			
			// display to console
			food1.setFoodItemData(flist);
			return food1;
	 
		} catch (JsonGenerationException e) {
	 
			e.printStackTrace();
			return null;
	 
		} catch (JsonMappingException e) {
	 
			e.printStackTrace();
			return null;
		} catch (IOException e) {
	 
			e.printStackTrace();
			return null;
		}
	}

}
