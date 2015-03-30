package abstractinterfaces;
import java.io.*;
import java.util.*;
import java.lang.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import menucreate.Food;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.w3c.dom.*;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;


public interface Generator {
	
	public Food generate(Food f);

}
