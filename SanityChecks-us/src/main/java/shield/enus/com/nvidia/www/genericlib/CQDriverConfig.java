
package shield.enus.com.nvidia.www.genericlib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.log4testng.Logger;

public class CQDriverConfig extends PropertyLoader  {
	
	static Logger log = Logger.getLogger(CQDriverConfig.class);
	public static WebDriver driver;
	
	
/**
 * @author gchand
 *  This method is initiate the driver instance.
 * 	
 * @param browser
 * @param url
 * @return driver
 */
	
	
	public static WebDriver webDriver(String browser, String url) {

		
		switch(browser){
		
		case "firefox":{
				
			System.setProperty("webdriver.gecko.driver", getPropertyValue(browser));
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			 driver = new FirefoxDriver(capabilities);

			
			log.info("Firefox has browser initiated successfully");
			System.out.println("Firefox has browser initiated successfully");
				break;
			}
		
		case "chrome":{
			
			System.setProperty("webdriver.chrome.driver", getPropertyValue("chrome") );
			ChromeOptions options = new ChromeOptions();
			    options.addArguments("--disable-extensions");
				driver = new ChromeDriver(options);

			
			
			log.info("Chrome has browser initiated successfully");
			System.out.println("Chrome has browser initiated successfully");
				break;
			}
		case "ie":{
			
			System.setProperty("webdriver.ie.driver", getPropertyValue("ie"));
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver= new InternetExplorerDriver();
			
			System.out.println("IE has browser initiated successfully");
			log.info("IE browser has initiated successfully");
				break;
			}
			
		default:{
			System.setProperty("webdriver.gecko.driver", getPropertyValue(browser));
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			 driver = new FirefoxDriver(capabilities);

			
			log.info("Default browser(firefox) has initiated successfully");
			break;
		}
			
		}
			
		
		driver.get(url);
		driver.manage().window().maximize();
		
		return driver;
		}
	 
	 public static void main(String[] args) {
		webDriver("ie", "https://wwwdev.nvidia.com/content/nvidiaGDC/us/en_US/shield/homepage_v3/?wcmmode=disabled");
		driver.quit();
	


		 
	 }
	 
	
	

}