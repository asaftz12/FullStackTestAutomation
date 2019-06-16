package workflows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extensions.Click;
import utilities.CommonOps;

public class Electron_screen extends CommonOps
{
	public static void getInfo() throws IOException, ParserConfigurationException, SAXException 
	{
		Click.go(electronMain.btn_windows);
		Click.go(electronMain.btn_info);
		Click.go(electronMain.btn_screenInfo);
		Click.go(electronMain.btn_viewDemo);
	}
}
