package extensions;

import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import utilities.CommonOps;

public class Update extends CommonOps
{
	public static void text(WebElement element, String value) throws IOException, ParserConfigurationException, SAXException
	{

		try 
		{
			// Can implement ExplicitlyWait here
			element.sendKeys(value);
			test.log(LogStatus.PASS,"Text field updated successfully.");
		}
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL,"Failed to update Text field, see details: " + e + "See screenshot: "+ test.addScreenCapture(takeScreenshot()));
			fail("Failed to update Text field");
		}

	}
	
	public static void dropDownText(WebElement element, String value) throws IOException, ParserConfigurationException, SAXException
	{

		try 
		{
			// Can implement ExplicitlyWait here
			Select myValue = new Select (element);
			myValue.selectByVisibleText(value);
			test.log(LogStatus.PASS,"DropDown updated successfully.");
		}
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL,"Failed to update DropDown, see details: " + e + "See screenshot: "+ test.addScreenCapture(takeScreenshot()));
			fail("Failed to update DropDown");
		}

	}
}
