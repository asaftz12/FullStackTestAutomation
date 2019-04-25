package tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import extensions.Verify;
import utilities.CommonOps;
import workflows.API_Actions;

public class Students extends CommonOps
{
	@Test
	public void test01_VerifyStudentCreated () throws ParserConfigurationException, SAXException, IOException
	{
		API_Actions.postNewStudents();
		Verify.contains(API_Actions.getDetails().getBody().asString(), "asaftz12@gmail.com");
	}
	
}
