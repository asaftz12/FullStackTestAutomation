package workflows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extensions.Click;
import extensions.Update;
import utilities.CommonOps;

public class Web_WikipediaSearch extends CommonOps
{
	public static void go(String searchValue, String language) throws IOException, ParserConfigurationException, SAXException
	{
		Update.text(wikiMain.searchBar, searchValue);
		Update.dropDownText(wikiMain.selectLanguage, language);
		Click.go(wikiMain.searchButton);
	}
}