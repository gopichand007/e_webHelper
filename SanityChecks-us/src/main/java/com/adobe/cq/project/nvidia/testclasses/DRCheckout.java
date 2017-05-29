package com.adobe.cq.project.nvidia.testclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class DRCheckout extends BrowserAndWebElementInitialization {
	
	
public WebElement productRowFindHelper(String productID){
		
		try{
			waitForElementPresent( dr.productXpath(productID), "xpath");
			WebElement productWE= driver.findElement(By.xpath(dr.productXpath(productID)));
			return productWE;
			
		}catch(Exception e){
			Reporter.log("Error: Exception in productFindHelper ",true);
			return null;
		}
		
	}
	
	
public int quntityValueHelper(String productID){
		
		try{
			WebElement quantity = driver.findElement(By.xpath(dr.productQuantity(productID)));
			return  Integer.parseInt(quantity.getAttribute("value"));
		}catch(Exception e){
			
			Reporter.log("Error: Exception in quntityValueHelper ",true);
			return 0;	
		}
	}
	
	
public boolean OrderNumberIsGenerated(){
		 boolean ord= false;
		 
		try{ 
			String order=dr.orderWL.getText();
			if(order.trim().length()>=4){
				ord=true; 
				Reporter.log("Info: Order number: "+ order, true);}
			
			
		}catch(Exception e){
			Reporter.log("Exception: Exception CheckOrderNumber() ", true);  
			  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
			  captureEntirePage(screenShotDir,imageName);
			  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName );
			
		}
		return ord;
	}
	
	
	
public boolean ValidProductHascarried(String productID){
		boolean product=false;
		
		try{
			WebElement productName=productRowFindHelper(productID);
			product =productName.isDisplayed();
			Reporter.log(productName.getText(), true);
		}catch(Exception e ){
			Reporter.log("Exception in checkCheckedOutProductIsValid ",true);
			
			  
			  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
			  captureEntirePage(screenShotDir,imageName);
			  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName );
			
			}
		return product;
			}

public boolean checkInitialProductCount(String productID){
	if(quntityValueHelper(productID)==1){
		Reporter.log("Info: product count is  1", true);
		
		return true;
		}else 
	return false;}


	
	
	
public boolean CandyRackIsPresented(){
		boolean candyRack=false;
		
		try{
			candyRack=dr.candyRack.isDisplayed();
			if(candyRack){ Reporter.log("Candy rack section is displayed as expected ", true); Reporter.log(dr.candyRack.getText(), true);}
			Reporter.log("Candy rack section is not displayed", true);
			
			
			
		}catch(Exception e){
			Reporter.log("Exception in CheckCandyRackPresence ",true);
			
			  
			  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
			  captureEntirePage(screenShotDir,imageName);
			  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName );
			
			
		} return candyRack;
		

		
	}
	


public boolean doValidLogin(String emailAddress, String password){
		
		try{
			scrollTOElements(dr.loginForm);
			dr.loginID.sendKeys(emailAddress);
			dr.loginPass.sendKeys(password);
			dr.br_loginButton.click();
			waitForPageToLoad();
			waitForElementPresent(dr.loginConfirmationWE);
			
			Reporter.log("Info: Login successful", true);
			return true;
				
		}catch(Exception e){
			Reporter.log("Info: Exceptionin doValidLogin", true);
			
			  
			  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
			  captureEntirePage(screenShotDir,imageName);
			  Reporter.log("Error:refer this screenshot:"+screenShotDir+" "+imageName, true );
			  return false;
			
			
		}
			
		}
	
	
public boolean BilladdressInfoIsDisplayed(){
	 boolean bd=webElementIsDisplayed(dr.dr_billingAddress);
	 if(bd) Reporter.log("Info: Billing information has displayed", true);
	 else Reporter.log("Warm:Billing information is not displayed, issue", true);
	return bd;
}		
			
public boolean PaymentInformationIsdisplayed(){
	
	boolean continu=false;
	continu=webElementIsDisplayed(dr.dr_paymentContainer);
	 if(continu)Reporter.log("Info: payment information has displayed", true);
	 else Reporter.log("Warn:payment information is not displayed issue ", true);
	return continu; }


public boolean navigatefromCartandBillingpageToShippingInfopage(String creditCardNumber, String cvv){
	 boolean nv=false;
	
	try{
		dr.creditCardNumberWE.clear();
		
		dr.creditCardNumberWE.sendKeys(creditCardNumber );
		dr.dr_cardSecurityCode.sendKeys(cvv);
		buttonClick(dr.dr_CartAndBillinInfo_continue);
		nv=VerifyYourAddressPanelIsDisplayed();
		if(nv) Reporter.log("Info:Navigated from cart and billing page to shipping page ", true);
		else Reporter.log("Warn:Navigating issue from cart and billing page to shipping page ", true);
		

		
	}catch(Exception e){
		Reporter.log("Error: Exception in navigateToShippingInfopage()", true);
		
		  
		  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		  captureEntirePage(screenShotDir,imageName);
		  Reporter.log("Error: refer this screenshot:"+screenShotDir+" "+imageName, true );
		
		
	}
	
	
	
	
	return nv;
	
	
	
	
}

public boolean VerifyYourAddressPanelIsDisplayed(){
	boolean vryuraddress= false;
	
	try{ 
		Reporter.log("info: VerifyYourAddressPanelIsDisplayed()- VerifyYourAddress pop ups ha shown:", true);
		vryuraddress=webElementIsDisplayed(dr.dr_verifyYouraddress);
		buttonClick(dr.dr_verifyYouraddress_useThisAddress);
		vryuraddress=true;
		Reporter.log("Info:VerifyYourAddressPanelIsDisplayed(): ", true);
	}catch(Exception e ){
		Reporter.log("Error: Exceptionin VerifyYourAddressPanelIsDisplayed(): "+dr.dr_verifyYouraddress_useThisAddress, true);
		
		  
		  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		  captureEntirePage(screenShotDir,imageName);
		  Reporter.log("Error: refer this screenshot:"+screenShotDir+" "+imageName, true );
		
	}
	
	
	return vryuraddress;
}

public boolean ShoppingInfoPanelIsDisplayed(){
	boolean sip= false;
	try{
		webElementIsDisplayed(dr.dr_shipping);
		buttonClick(dr.dr_CartAndBillinInfo_continue);
		sip=VerifyYourAddressPanelIsDisplayed();
		 
		if (sip) Reporter.log("Info:Shopping Information Panel Is Displayed", true);
		else Reporter.log(" Warn:Issue , Shopping Infarmation Panel Is not Displayed", true);
		
		
	
		
	} catch(Exception e ){Reporter.log("Error: Exceptin in ShoppingInfoPanelIsDisplayed()");
	
	  
	  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
	  captureEntirePage(screenShotDir,imageName);
	  Reporter.log("Error: refer this screenshot:"+screenShotDir+" "+imageName, true );
	
		}

	
	return sip;
	
}



public boolean NavigateToVerifyOrder(){
	boolean ntvo=false;
	ntvo= webElementIsDisplayed(dr.verifyOder);
	
	if(ntvo) Reporter.log("Verify order page is displayed as expected", true);
	else Reporter.log("Issue, Verify order page is not displayed as expected", true);
	
	return ntvo;
	
	
}



public static void main(String[] args){
	DRCheckout obj= new DRCheckout();
	browserInitialization("firefox","https://store.nvidia.com/store/nvidia/en_US/buy/productID.5088793700/quantity.1" );
	digitalriverWebElements();
	System.out.println("OrderNumberIsGenerated()  "+obj.OrderNumberIsGenerated());
	System.out.println("ValidProductHascarried(5088793700)  "+obj.ValidProductHascarried("5088793700"));
	System.out.println("CandyRackIsPresented()  "+obj.CandyRackIsPresented());
	System.out.println("doValidLogin() "+obj.doValidLogin("gopihy+1@gmail.com", "Nv@123456"));
	System.out.println("BilladdressInfoIsDisplayed()  "+obj.BilladdressInfoIsDisplayed());
	System.out.println("PaymentInformationIsdisplayed()  "+obj.PaymentInformationIsdisplayed());
	System.out.println("navigatefromCartandBillingpageToShippingInfopage()  "+obj.navigatefromCartandBillingpageToShippingInfopage("4444333322221111", "321"));
	
	System.out.println("ShoppingInfoPanelIsDisplayed()  "+obj.ShoppingInfoPanelIsDisplayed());
	System.out.println("NavigateToVerifyOrder(()"+obj.NavigateToVerifyOrder());
	
/*	browserInitialization("firefox","https://store.nvidia.com/store/nvidia/en_US/buy/productID.5088793700/quantity.1" );
	digitalriverWebElements();
	System.out.println("OrderNumberIsGenerated()  "+obj.OrderNumberIsGenerated());
	System.out.println("ValidProductHascarried(5088793700)  "+obj.ValidProductHascarried("5088793700"));
	System.out.println("CandyRackIsPresented()  "+obj.CandyRackIsPresented());
	System.out.println("doValidLogin() "+obj.doValidLogin("gopihy+1@gmail.com", "Nv@123456"));
	System.out.println("BilladdressInfoIsDisplayed()  "+obj.BilladdressInfoIsDisplayed());
	System.out.println("PaymentInformationIsdisplayed()  "+obj.PaymentInformationIsdisplayed());
	System.out.println("navigatefromCartandBillingpageToShippingInfopage()  "+obj.navigatefromCartandBillingpageToShippingInfopage("4444333322221111", "321"));
	
	System.out.println("ShoppingInfoPanelIsDisplayed()  "+obj.ShoppingInfoPanelIsDisplayed());
	System.out.println("NavigateToVerifyOrder(()"+obj.NavigateToVerifyOrder());*/
	
	

	
	
}

	 
	 

	

}
