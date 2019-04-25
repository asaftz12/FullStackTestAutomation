package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//import pageObjects_wikipedia.*;

public class Base 
{
	public static WebDriver driver;
	public static Screen screen;
	public static DesiredCapabilities dc = new DesiredCapabilities();

	
	public static pageObjects_wikipedia.MainPage wikiMain;
	public static pageObjects_wikipedia.ResultsPage wikiResults;
	public static pageObjects_Mortgage.MainPage mortgageMain;
	
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static RequestSpecification httpRequest;
	public static JSONObject requestParams = new JSONObject();
	public static Response resp;
	
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(Calendar.getInstance().getTime());
	
}
