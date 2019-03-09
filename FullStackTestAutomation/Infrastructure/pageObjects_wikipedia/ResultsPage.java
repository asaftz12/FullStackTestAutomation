package pageObjects_wikipedia;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultsPage 
{
	@FindBy(how = How.CLASS_NAME, using = "mw-search-nonefound")
	public WebElement resultField;
}
