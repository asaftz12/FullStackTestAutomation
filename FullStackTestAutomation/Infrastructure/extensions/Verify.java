package extensions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import utilities.CommonOps;

public class Verify extends CommonOps 
{
	public static void textInElement(WebElement element, String expectedValue) throws IOException, ParserConfigurationException, SAXException
	{
		try 
		{
			// Can implement ExplicitlyWait here
			assertEquals(element.getText(),expectedValue);
			test.log(LogStatus.PASS,"Text found in element successfully.");
		}
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL,"Error with finding text, see details: " + e + "See screenshot: "+ test.addScreenCapture(takeScreenshot()));
			fail("Error with finding text");
		}

		catch (AssertionError e) 
		{
			test.log(LogStatus.FAIL,"Text NOT found in element, see details: " + e + "See screenshot: "+ test.addScreenCapture(takeScreenshot()));
			fail("Text NOT found in element");
		}
	}

	public static void image(String imagePath) throws FindFailed, IOException, ParserConfigurationException, SAXException 
	{
		try 
		{
			screen.find(imagePath);	
			test.log(LogStatus.PASS,"Image found successfully.");
		}
		catch (Exception e) 
		{
			test.log(LogStatus.FAIL,"Failed to find image, see details: " + e + "See screenshot: "+ test.addScreenCapture(takeScreenshot()));
			fail("Failed to find image");
		}
	}
	
	public static void contains(String response, String text)
	{
		try 
		{
			assertTrue(response.contains(text));
			test.log(LogStatus.PASS,"Contains passed successfully.");
		}
		catch (AssertionError e)
		{
			test.log(LogStatus.FAIL,text + " is not contained in: " + response + ". see details: " + e);
			fail(text + " is not contained, see details: " + e);
		}
		
	}
}
