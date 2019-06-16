package pageObjects_calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage 
{
	@FindBy(how = How.NAME, using = "One")
	public WebElement btn_one;
	
	@FindBy(how = How.NAME, using = "Plus")
	public WebElement btn_plus;
	
	@FindBy(how = How.NAME, using = "Two")
	public WebElement btn_two;
	
	@FindBy(how = How.NAME, using = "Equals")
	public WebElement btn_equals;
	
	@FindBy(how = How.ID, using = "150")
	public WebElement field_result;
	
}
