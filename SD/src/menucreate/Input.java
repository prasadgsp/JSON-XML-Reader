package menucreate;

import java.io.*;
import java.lang.*;
import java.util.*;

import abstractinterfaces.Formatter;
import abstractinterfaces.Generator;
import abstractinterfaces.Reader;

@SuppressWarnings("unused")
public class Input {


	public static void main(String[] args)
	{
		ReaderFactory rf=new ReaderFactory();
		FormatFactory ff=new FormatFactory();
		GeneratorFactory gf=new GeneratorFactory();
		String readerch="";
		String outputch="";
		String categorych="";
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		System.out.println("MENU GENERATION");
		System.out.println("****************************\n");
		System.out.println("Do you wish to retrieve menus of restaurants from Great Britain or United States?\nType GB for Great Britain or US for United States");
		readerch=sc.next();
		if(readerch==null||(!readerch.equalsIgnoreCase("GB")&&!readerch.equalsIgnoreCase("US")))
		{
			System.out.println("As no proper input was given assuming default input GB");
			readerch="GB";
		}
		
		
		System.out.println("\nWhat Restaurant Category would you prefer?\nType either Diner, Evening or AllDay");
		categorych=sc.next();
		if(categorych==null||(!categorych.equalsIgnoreCase("Diner")&&!categorych.equalsIgnoreCase("Evening")&&!categorych.equalsIgnoreCase("AllDay")))
		{
			System.out.println("As no proper input was given assuming default input All Day");
			outputch="AllDay";
		}
		
		
		System.out.println("\nWhat File Output would you prefer?\nType either HTML, XML or Text");
		outputch=sc.next();
		if(outputch==null||(!outputch.equalsIgnoreCase("HTML")&&!outputch.equalsIgnoreCase("Text")&&!outputch.equalsIgnoreCase("XML")))
		{
			System.out.println("As no proper input was given assuming default input Text");
			outputch="Text";
		}
	
		
		//Calling appropriate reader according to country, XML for GB and JSON for US
		Reader read=rf.createReader(readerch);
		Food f=read.reader(readerch);
		
		
		//Calling appropriate Menu Generator based on Restaurant Category chosen
		Generator generate=gf.createGenerator(categorych);
		f=gf.generator(generate, f);
		
		
		//Calling appropriate Menu Formatter based on Output Format chosen
		Formatter format = ff.createFormat(outputch);
		format.format(f);
		//Output file generated at Project location
	
		System.out.println("Output File Generated Successfully at location of Project Workspace");
	}
	
}
