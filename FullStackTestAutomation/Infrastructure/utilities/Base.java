package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageObjects_wikipedia.*;

public class Base 
{
	public static WebDriver driver;
	public static Screen screen;
	public static MainPage wikiMain;
	public static ResultsPage wikiResults;
	
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-HH-mm-ss").format(Calendar.getInstance().getTime());
	
}
