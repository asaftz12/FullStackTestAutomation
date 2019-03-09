package pageObjects_wikipedia;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage 
{
	@FindBy(how = How.ID, using = "searchInput")
	public WebElement searchBar;
	
	@FindBy(how = How.ID, using = "searchLanguage")
	public WebElement selectLanguage;
	
	@FindBy(how = How.CSS, using = "button[type='submit")
	public WebElement searchButton;
}
