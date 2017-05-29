package shield.enus.com.nvidia.www.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


public class PropertyLoader {

	static Logger log = Logger.getLogger(PropertyLoader.class);
	static Properties prop = null;
	static String propFile = System.getProperty("user.dir")+"\\config.properties";
	
	
	//Loading the Properties once
	static {
		prop = new Properties();
		//load a properties file
		try {
			prop.load(new FileInputStream(propFile));
			log.debug(propFile + " file loaded successfully");
		} 
		catch (FileNotFoundException e) {
			log.error(propFile + " file Not Found, check the fileName and path", e);
		} 
		catch (IOException e) {
			log.error("Error reading file " + propFile, e);
		}
	}
	
	public static String getPropertyValue(String key) {
		
		String value = prop.getProperty(key);
		if (value == null) {
			log.warn("Property value not present for key: " + key);
		}
		return value;
	}
	
	public static void main(String[] args) {

		String url = getPropertyValue("home_url");
		String browser = getPropertyValue("chrome");

		
		
		System.out.println(url);
		System.out.println(browser);

	}
}
