package extensions;

import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import utilities.CommonOps;

public class Click extends CommonOps
{
	public static void go(WebElement element) throws IOException, ParserConfigurationException, SAXException 
	{
		try 
		{
			// Can implement ExplicitlyWait here
			element.click();
			test.log(LogStatus.PASS, "Element clicked successfully.");
		}
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL, "Failed to click on element, see details: " + e + "See screenshot: "+ test.addScreenCapture(takeScreenshot()));
			fail("Failed to click on element");
		}
	}
}
