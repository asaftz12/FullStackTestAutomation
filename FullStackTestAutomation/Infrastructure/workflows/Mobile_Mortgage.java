package workflows;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extensions.Click;
import extensions.Update;
import utilities.CommonOps;

public class Mobile_Mortgage extends CommonOps
{
	public static void calculate(String amount, String term, String rate) throws IOException, ParserConfigurationException, SAXException
	{
		Update.text(mortgageMain.amount, amount);
		Update.text(mortgageMain.term, term);
		Update.text(mortgageMain.rate, rate);
		Click.go(mortgageMain.calculate);
	}
}
