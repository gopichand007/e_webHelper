package com.adobe.cq.project.nvidia.testclasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;





public class VideoComponent extends HeaderAndFooter{
	static Logger log = Logger.getLogger(VideoComponent.class);
		 
	 
	 public boolean homeHerovideoDisplay(){
			boolean bgDisplay= false;
			try{
				bgDisplay= homepage.videoSlide1();
				
				Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" successful", true);
				
				}catch(Exception e){
					log.error("verifyHomePageFirtsColumnBackgroundImage() --> HerovideoDisplay() exception "+e.getMessage());
					Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" exception", true);
		
				}
			return bgDisplay;
		}

	 
	 public boolean homeHerovideoTextDisplay(){
			boolean bgDisplay= false;
			try{
				bgDisplay= homepage.heroVideoTextcomponent();
				Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" successful", true);
				
				}catch(Exception e){
					log.error("verifyHomePageFirtsColumnBackgroundImage() --> heroVideoTextcomponent() exception "+e.getMessage());
					Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" exception", true);
		
				}
			return bgDisplay;
		}
		


   

      	
	
	
	public static void main(String args[]){
		VideoComponent vc = new VideoComponent();
		browserInitialization("firefox","https://www2.nvidia.com/en-us/shield/" );
		shieldHomWebElementInitialization();
		vc.homeHerovideoDisplay();
		vc.homeHerovideoTextDisplay();
		vc.closeBrowser();
		
	 
	}	
	
	

}
