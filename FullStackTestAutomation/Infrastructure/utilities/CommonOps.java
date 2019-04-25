package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.restassured.RestAssured;

public class CommonOps extends Base
{
	/**
	 * This method gets an XML tag name and returns the content of the tag if it exists in DataConfig.xml  
	 * @param nodeName The XML tag name
	 * @return XML tag content
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException
	{
		File fXmlFile = new File("./Configuration/DataConfig.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);		
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}

	/**
	 * This method gets a browser type (string) and initializes the corresponding WebDriver
	 * @param browserType browser type: Chrome, Firefox or IE 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void initBrowser(String browserType) throws ParserConfigurationException, SAXException, IOException 
	{
		switch (browserType.toLowerCase()) 
		{
		case "chrome":
			driver = initChromeDriver();
			break;
		case "firefox":
			driver = initFFDriver();
			break;
		case "ie":
			driver = initIEDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.get(getData("URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		screen = new Screen();
	}
	
	public static void initMobile() throws ParserConfigurationException, SAXException, IOException
	{
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        driver = new AndroidDriver<>(new URL(getData("APPIUM_SERVER_ADDRESS")), dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void initAPI() throws ParserConfigurationException, SAXException, IOException
	{
		RestAssured.baseURI = getData("API_URL");
		httpRequest = RestAssured.given();
	}
	
	/**
	 * This method initializes the Chrome WebDriver
	 * @return Chrome WebDriver
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static WebDriver initChromeDriver() throws ParserConfigurationException, SAXException, IOException
	{
		System.setProperty("webdriver.chrome.driver", getData("ChromeDriverPath"));
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	/**
	 * This method initializes the Firefox WebDriver
	 * @return Firefox WebDriver
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static WebDriver initFFDriver() throws ParserConfigurationException, SAXException, IOException
	{
		System.setProperty("webdriver.gecko.driver", getData("FFDriverPath"));
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	/**
	 * This method initializes the Internet Explorer WebDriver
	 * @return Internet Explorer WebDriver
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static WebDriver initIEDriver() throws ParserConfigurationException, SAXException, IOException
	{
		System.setProperty("webdriver.ie.driver", getData("IEDriverPath"));
		WebDriver driver = new InternetExplorerDriver();
		return driver;
	}


	/**
	 * This method create the Extent Report instance.
	 * The name of the report and its path are located in the project's DataConfig.xml in the Configuration folder 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void instanceReport() throws ParserConfigurationException, SAXException, IOException
	{
		extent = new ExtentReports(getData("ReportFilePath") + "Execution_" + timeStamp + "/" + getData("ReportFileName")+".html");

	}

	/**
	 * This method initialize a report for a single test
	 * @param testName - This is the test name that will appear in the report
	 * @param testDescription - This is the test description that will appear in the report
	 */
	public static void initReportTest(String testName, String testDescription)
	{
		test = extent.startTest(testName, testDescription);
	}

	/**
	 * This method finalizes/conclude the report for a single test.
	 */
	public static void finalizeReportTest()
	{
		extent.endTest(test);
	}

	/**
	 * This method flushes and closes the report instance.
	 */
	public static void finalizeExtentReport()
	{
		extent.flush();
		extent.close();
	}

	public static String takeScreenshot () throws IOException, ParserConfigurationException, SAXException 
	{
		String screenshotPath = getData("ScreenshotPath") + "Execution_" + timeStamp + "/" + "screenshot_" + getRandomNumber () + ".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Copy screenshot to screenshotPath
		FileUtils.copyFile(scrFile, new File(screenshotPath));
		return screenshotPath;
	}

	public static int getRandomNumber () 
	{
		Random rand = new Random();
		return rand.nextInt(9999999) + 1;
	}



	@BeforeClass
	public void beforeClass() throws ParserConfigurationException, SAXException, IOException 
	{
		if (getData("AutomationType").toLowerCase().equals("web"))
		{
			initBrowser(getData("BrowserType"));
		}
		else if (getData("AutomationType").toLowerCase().equals("mobile"))
		{
			initMobile();
		}
		else if (getData("AutomationType").toLowerCase().equals("api"))
		{
			initAPI();
		}
		ManagePages.init();
		instanceReport();

	}

	@AfterClass
	public void afterClass() throws ParserConfigurationException, SAXException, IOException 
	{
		if (!getData("AutomationType").toLowerCase().equals("api"))
			driver.quit();
		finalizeExtentReport();
	}

	@BeforeMethod
	public void beforeMethod(Method method) 
	{
		initReportTest(method.getName().split("_")[0],method.getName().split("_")[1]);
	}

	@AfterMethod
	public void afterMethod() 
	{
		finalizeReportTest();  
	}
}
