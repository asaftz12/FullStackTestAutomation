package tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import extensions.Verify;
import utilities.CommonOps;
import workflows.Mobile_Mortgage;

public class MortgageApp extends CommonOps
{
	@Test 
	public void test01_verifyRepayment() throws IOException, ParserConfigurationException, SAXException
	{
		Mobile_Mortgage.calculate("1000", "3", "4");
		Verify.textInElement(mortgageMain.repayment, "£30.03");
		//Verify.textInElement(mortgageMain.repayment, "KUKU");
	}
}
