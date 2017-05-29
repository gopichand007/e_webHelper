package com.adobe.cq.project.nvidia.testclasses;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import shield.enus.com.nvidia.www.businesslib.javaLinkValidator;


public class HeaderAndFooter extends BrowserAndWebElementInitialization{
	

	public boolean GenericAnchorLinkChecker(List<WebElement> wb){
		boolean rv=false;
		try{
		ArrayList<String> ar=homepage.specificWebElementsAnchorLinks(wb);
		javaLinkValidator.ListLinksValidator(ar);
		rv=true;
		}catch(Exception e){
			Reporter.log("GenericAnchorLinkChecker(), Exception", true);
		}
		return rv ;
		
	}
	
	
	public boolean CheckNavigationalFooterLinks(){
		return GenericAnchorLinkChecker(homepage.nvgtnlFooterURLWebList);
	}
	
	
	public boolean CheckGloblaFooterLinks(){
		return GenericAnchorLinkChecker(homepage.globalFooterURLWebList);
	}
	
	public boolean CheckNavigationalheadreLinks(){
		return GenericAnchorLinkChecker(homepage.brandNavigationList);
	}
	
	
	public boolean CheckGlobalFooterSocialMediaLinks(){
		return GenericAnchorLinkChecker(homepage.globalFooterSocialURlsList);
	}
	
	

	
	
	public static void main(String args[]){
		HeaderAndFooter hf= new HeaderAndFooter();

		browserInitialization("firefox","https://www2.nvidia.com/en-us/shield/android-tv/" );
		shieldHomWebElementInitialization();
		hf.CheckNavigationalFooterLinks();
		hf.CheckGloblaFooterLinks();
		hf.CheckNavigationalheadreLinks();
		
	}

}
