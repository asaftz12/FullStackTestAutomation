package pageObjects_Electron;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage 
{
	@FindBy(how = How.ID, using = "button-app-sys-information")
	public WebElement btn_info;
	
	@FindBy(how = How.ID, using = "button-windows")
	public WebElement btn_windows;
	
	@FindBy(how = How.ID, using = "screen-info-demo-toggle")
	public WebElement btn_screenInfo;
	
	@FindBy(how = How.ID, using = "screen-info")
	public WebElement btn_viewDemo;
	
	@FindBy(how = How.ID, using = "got-screen-info")
	public WebElement btn_screenInfoResult;
}
