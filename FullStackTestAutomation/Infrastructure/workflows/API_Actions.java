package workflows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extensions.RESTAPI;
import io.restassured.response.Response;
import utilities.CommonOps;

public class API_Actions extends CommonOps
{
	private static String[] details = {"Asaf","Tzabari","asaftz12@gmail.com","Engineer"};
	private static List<String> subjects = new ArrayList<String>();
	
	public static void postNewStudents() throws ParserConfigurationException, SAXException, IOException
	{
		subjects.add("Math");
		subjects.add("English");
		subjects.add("Computers");
		subjects.add("Biology");
		
		RESTAPI.post(details, subjects);
	}
	
	public static Response getDetails() throws ParserConfigurationException, SAXException, IOException 
	{
		return RESTAPI.get(getData("API_URL") + getData("API_RESOURCE") + "/list");
	}
}
