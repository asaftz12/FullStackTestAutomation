package tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import extensions.Verify;
import utilities.CommonOps;
import workflows.Desktop_calc;

public class Calculator extends CommonOps
{
	@Test
	public void test01_Verify1Plus2() throws IOException, ParserConfigurationException, SAXException
	{
		Desktop_calc.add(calcMain.btn_one, calcMain.btn_two);
		Verify.textInElement(calcMain.field_result, "3");
	}
}
