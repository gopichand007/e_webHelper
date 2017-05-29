package com.adobe.cq.project.nvidia.testclasses;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import shield.enus.com.nvidia.www.genericlib.CQDriverConfig;
import shield.enus.com.nvidia.www.pagefactory.DRWebElemetns;
import shield.enus.com.nvidia.www.pagefactory.gcDigitalRiverWebElements;
import shield.enus.com.nvidia.www.pagefactory.shieldSiteMarkingWebElements;




public class BrowserAndWebElementInitialization extends PageLinkExtractor  {
	
	static Logger log = Logger.getLogger(BrowserAndWebElementInitialization.class);
	public static WebDriver driver;
	public static  shieldSiteMarkingWebElements homepage;
	public static  DRWebElemetns dr;
	 public static gcDigitalRiverWebElements gc ;
	
	 public  static WebDriver browserInitialization(String browswername, String url){
		try{ 
			driver = CQDriverConfig.webDriver(browswername, url );
			Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" successful", true);
			
			}catch(Exception e ){
			log.error("Browser initialization issue for home page "+e.getMessage());
			Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" exception", true);
			}
		return driver;
	 }
	 
	 
	    public void closeBrowser(){
	    	
	    	try{
	    		driver.close();
	    		driver.quit();
	    		
	    	}catch(Exception e){
	    		
	    	}
	    }
	 
	 

public static void shieldHomWebElementInitialization(){
			 try{
				 homepage= PageFactory.initElements(driver, shieldSiteMarkingWebElements.class);
				 Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" successful", true);
			 	}catch(Exception e ){
			 		log.error("Web element initialization issue for home page "+e.getMessage());
			 		Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" exception", true);
			 }
		 }


public static void digitalriverWebElements(){
	 try{
		 dr= PageFactory.initElements(driver, DRWebElemetns.class);
		 Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" successful", true);
	 	}catch(Exception e ){
	 		log.error("Web element initialization issue for home page "+e.getMessage());
	 		Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" exception", true);
	 }
}


public static void gcDRWebElements(){
	 try{
		 gc= PageFactory.initElements(driver, gcDigitalRiverWebElements.class);
		 Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" successful", true);
	 	}catch(Exception e ){
	 		log.error("Web element initialization issue for home page "+e.getMessage());
	 		Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" exception", true);
	 }
}



	 }


