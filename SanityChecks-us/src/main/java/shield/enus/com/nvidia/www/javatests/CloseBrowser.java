package shield.enus.com.nvidia.www.javatests;


import org.testng.annotations.AfterTest;

import com.adobe.cq.project.nvidia.testclasses.BrowserAndWebElementInitialization;


public class CloseBrowser {
	
	@AfterTest
	public void  closeBrowser(){
			 
		BrowserAndWebElementInitialization.driver.close();
		BrowserAndWebElementInitialization.driver.quit();
		
		   
	   }
			
	

}
