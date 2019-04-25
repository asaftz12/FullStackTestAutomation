package extensions;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utilities.CommonOps;

public class RESTAPI extends CommonOps
{
	@SuppressWarnings("unchecked")
	public static void post(String[] params, List<String> courseList) throws ParserConfigurationException, SAXException, IOException
	{
		try 
		{
			requestParams.put("firstName", params[0]);
			requestParams.put("lastName", params[1]);
			requestParams.put("email", params[2]);
			requestParams.put("programme", params[3]);
			requestParams.put("courses", courseList);
			
			httpRequest.header("Content-Type","application/json");
			httpRequest.body(requestParams.toJSONString());
			httpRequest.post(getData("API_RESOURCE"));
			test.log(LogStatus.PASS, "Post succeeded.");

		}
		catch (Exception e)
		{
			test.log(LogStatus.FAIL, "Post has failed, see details: " + e);
			fail("Post has failed, see details: " + e);
		}
	}
	
	public static Response get(String URL)
	{
		resp = httpRequest.get(URL);
		System.out.println("resp equals: "+resp);
		return resp;
	}
}
