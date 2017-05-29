package com.adobe.cq.project.nvidia.testclasses;


import java.lang.reflect.Method;

import org.testng.Reporter;

public class GCLogin extends DRCheckout {
	
	
	public boolean drGCLogin(String gcurl, String gc_userName, String gc_password, String gc_prodcutURL){
		boolean gc_login_flage =false;
		
		
		
		try{
			
			driver.get(gcurl);
			gc.gc_userName.clear();
			gc.gc_userName.sendKeys(gc_userName);
			gc.gc_password.clear();
			gc.gc_password.sendKeys(gc_password);
			gc.gc_login.click();
			if(webElementIsDisplayed(gc.gc_SiteTrends))gc_login_flage=true;
			gc.gc_siteSelection.sendKeys("Nvidia 2 (nvidia2)");
			 System.in.read();
			 driver.get(gc_prodcutURL);
			
		}catch(Exception e){
			Reporter.log("Exception in drGCLogin()"+e,  true);
		    String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
			captureEntirePage(screenShotDir,imageName);
			Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName );
			
		}
		return gc_login_flage;
	}
	
	
	public static void main(String [] args){
		GCLogin obj = new GCLogin();
		browserInitialization("firefox","https://gc.digitalriver.com/gc/ent/login.do" );
		gcDRWebElements();
		obj.drGCLogin("https://gc.digitalriver.com/gc/ent/login.do","rprasad", "Nvidi@2016", "http://gc.digitalriver.com/store/nvidia/en_US/buy/productID.5087552300/quantity.1");

		
	}
	
	

}
