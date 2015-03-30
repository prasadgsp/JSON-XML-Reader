package menucreate;

import java.lang.*;
import java.io.*;
import java.util.*;

import abstractinterfaces.Generator;

public class EveningGenerator implements Generator {
	
	public Food generate(Food f)
	{
		Food f2=new Food();
		ArrayList<Menu> flist=new ArrayList<Menu>();
		for(Menu m : f.getFoodItemData())
		{
			if(m.getCategory().equalsIgnoreCase("Appetizer"))
			{
				flist.add(m);
			}
		}
		for(Menu m : f.getFoodItemData())
		{
			if(m.getCategory().equalsIgnoreCase("Dinner"))
			{
				flist.add(m);
			}
		}
		for(Menu m : f.getFoodItemData())
		{
			if(m.getCategory().equalsIgnoreCase("Dessert"))
			{
				flist.add(m);
			}
		}
		for(Menu m : f.getFoodItemData())
		{
			if(m.getCategory().equalsIgnoreCase("Side Dish"))
			{
				flist.add(m);
			}
		}
		
		f2.setFoodItemData(flist);
		return f2;
	}
}
