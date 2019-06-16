package tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import extensions.Verify;
import utilities.CommonOps;
import workflows.Electron_screen;

public class ElectronDemo extends CommonOps
{
	@Test
	public void test_01_GetInfo() throws IOException, ParserConfigurationException, SAXException
	{
		Electron_screen.getInfo();
		Verify.textInElement(electronMain.btn_screenInfoResult, "Your screen is: 1920px x 1080px");
	}
}
