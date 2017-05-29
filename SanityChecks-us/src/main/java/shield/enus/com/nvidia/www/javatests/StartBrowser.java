package shield.enus.com.nvidia.www.javatests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.adobe.cq.project.nvidia.testclasses.BrowserAndWebElementInitialization;


public class StartBrowser {
	
	static WebDriver driver;

	
	@Parameters({"browsername", "home_url"})
	@BeforeTest
	 public void browserInitiation(String browswername, String url){
		WebDriver driver =BrowserAndWebElementInitialization.browserInitialization( browswername,  url);
		BrowserAndWebElementInitialization.shieldHomWebElementInitialization();
		BrowserAndWebElementInitialization.digitalriverWebElements();
		BrowserAndWebElementInitialization.gcDRWebElements();
		
		}
	
}
