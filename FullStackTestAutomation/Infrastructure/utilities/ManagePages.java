package utilities;

import org.openqa.selenium.support.PageFactory;

import pageObjects_wikipedia.MainPage;
import pageObjects_wikipedia.ResultsPage;

public class ManagePages extends Base
{
	public static void init() 
	{
		wikiMain = PageFactory.initElements(driver, MainPage.class);
		wikiResults = PageFactory.initElements(driver, ResultsPage.class);
	}
}
