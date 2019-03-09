package tests;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import extensions.Verify;
import utilities.CommonOps;
import workflows.Web_WikipediaSearch;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.sikuli.script.FindFailed;

public class Wikipedia extends CommonOps
{

	@Test 
	public void test01_searchValue() throws IOException, ParserConfigurationException, SAXException, FindFailed 
	{
		Web_WikipediaSearch.go("Asaf Tzabari", "Simple English");
		Verify.textInElement(wikiResults.resultField, "There were no results matching the query.");
		Verify.image("./ImageRepository/facebookLogo.png");
	}

}
