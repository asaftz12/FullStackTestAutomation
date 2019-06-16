package workflows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import extensions.Click;
import utilities.CommonOps;

public class Desktop_calc extends CommonOps
{
	public static void add (WebElement first, WebElement second) throws IOException, ParserConfigurationException, SAXException
	{
		Click.go(first);
		Click.go(calcMain.btn_plus);
		Click.go(second);
		Click.go(calcMain.btn_equals);
	}
}
