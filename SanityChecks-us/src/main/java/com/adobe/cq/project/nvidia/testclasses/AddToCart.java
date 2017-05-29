package com.adobe.cq.project.nvidia.testclasses;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import shield.enus.com.nvidia.www.genericlib.CQDriverCommonUtilities;


public class AddToCart extends VideoComponent {
	static String path="C:\\temp\\";

	
	
public boolean CheckButtonText(String productID,  String buttonText){
	
	String addtocartTextFromWeb="";
	
	try{
			String addtoCartButtonpath= homepage.addToCartButtonWebElement(productID);
			WebElement addtoCartButton= driver.findElement(By.xpath(addtoCartButtonpath));
			//scrollTOElements(addtoCartButton);
			addtocartTextFromWeb = addtoCartButton.getText().trim();
			Reporter.log("productID: "+productID+ " provided buttonText: " +buttonText+ " Actual Button Text: " +addtocartTextFromWeb, true  );
				if(buttonText.equalsIgnoreCase(addtocartTextFromWeb))return true;
				else return false;
	}catch(Exception e ){
		Reporter.log("Exception in CheckButtonText productID: "+productID+ " provided buttonText: " +buttonText+ " Actual Button Text: " +addtocartTextFromWeb, true  );
	    
		String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		captureEntirePage(screenShotDir,imageName);
		Reporter.log("Error: refer this screenshot:"+screenShotDir+" "+imageName );
			
		return false;
	}
	
}

public boolean CheckCurrencyValue(String productID,  String currencyValue){
	
	String  currencyTextFromWeb="";
	WebElement addtoCartprice = null;
	
	try{
			String addtoCartpricepath= homepage.addToCartPriceWebElement(productID);
			addtoCartprice= driver.findElement(By.xpath(addtoCartpricepath));
			//scrollTOElements(addtoCartprice);
			currencyTextFromWeb = addtoCartprice.getText().trim();
			Reporter.log("productID: "+productID+ " provided buttonText: " +currencyValue+ " Actual Button Text: " +currencyTextFromWeb, true  );
				if(currencyValue.equalsIgnoreCase(currencyTextFromWeb))return true;
				else return false;
	}catch(Exception e ){
		Reporter.log("Info: webelement: "+addtoCartprice, true );
		Reporter.log("Info: webelement Exception : "+e, true );
		Reporter.log("Error: Exception in CheckButtonText productID: "+productID+ " provided buttonText: " +currencyValue+ "  Actual Button Text: " +currencyTextFromWeb, true  );
		
		String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		captureEntirePage(screenShotDir,imageName);
		Reporter.log("Error: refer this screenshot:"+screenShotDir+" "+imageName );
			
		
		return false;
	}
	
}
		
public boolean addPrductToCrt(String productID){
	
	
	try{
		String addtoCartButtonpath= homepage.addToCartButtonWebElement(productID);
		WebElement addtoCartButton= driver.findElement(By.xpath(addtoCartButtonpath));
		System.out.println("info: Web element"+addtoCartButtonpath);
		CQDriverCommonUtilities.scrollTOElements(addtoCartButton);
		addtoCartButton.click();
		
		Reporter.log("Info: Button call to action works as expected" ,true);
		return true;
  }catch(Exception e){
	  Reporter.log("Error: Button call to action is not working" ,true);
	  
	  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
	  captureEntirePage(screenShotDir,imageName);
	  Reporter.log("Error: refer this screenshot:"+screenShotDir+" "+imageName );
			
	  
	  return false;
	  
  }
	
}


public boolean CheckCartOverLayPopupAppears(String productID){

	
	try{
		homepage.cartPopupDisplay.isDisplayed();
		Reporter.log("Info: Cart overLay pop-up shows after added the product" ,true);
		return true;
		
	}catch(Exception e){
		Reporter.log("Info: Cart overLay pop-up not showing Exception" ,true);
		  
		String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		captureEntirePage(screenShotDir,imageName);
		Reporter.log("Error: refer this screenshot:"+screenShotDir+" "+imageName );
		
		return false;
	}

	
	
	
}
	

public boolean CheckProductAddedToCart(String productID){
	
	try{
		driver.findElement(By.cssSelector(".cart-item.cart-item--"+productID)).isDisplayed();
		Reporter.log("Product is added to cart as expected " ,true);
		return true;
		
	}catch(Exception e){
		Reporter.log(" SHIELD product is not added to cart after click the add to cart " ,true);
		return false;
	}
}

public boolean checkCartCounterUpdate(){
	
	boolean returnvalue=false;
	try{
		 String cc= homepage.CartCounter();
		if (cc.equalsIgnoreCase("1")){
			Reporter.log("Cart Counter has updated once added the product ", true);
			
			
			returnvalue= true;
		}
	}catch (Exception e ){
		Reporter.log("Cart Counter has updated once added the product ", true);
		
		  
		  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		  captureEntirePage(screenShotDir,imageName);
		  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName );
		
		
	}
	return returnvalue;
	
	
	
	
}


public boolean CheckTotalAmoutPresent(){
	boolean returnvalue=false;
	
	try{
		String ct= homepage.CartTotal();
		System.out.println("ct value"+ ct);
		if(!(ct.isEmpty())){
			Reporter.log("Cart totla amount shows as expected" +homepage.cartTotal.getText(), true);
			returnvalue=true;
			
		}
		
	}catch(Exception e){
		Reporter.log("Cart total  amount not shows, getting exception" ,true);
		
		  
		  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		  captureEntirePage(screenShotDir,imageName);
		  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName );
		
		
		
		
	}
	
	return returnvalue;
}
	
public boolean checkSubToalPresent(String productID){
	ArrayList<String> al = new ArrayList<String>();
	 boolean returnvalue=false;
	
	
	try{
		al = homepage.CartProductDetails(productID);
		if(al.size()==3){
			Reporter.log("Cart Product total shows as expected " ,true);
			returnvalue=true;
			for(String st:al){Reporter.log(st, true); }
			
			
		}else{
			Reporter.log("product info div is missing " ,true);

		}
		
	}catch(Exception e){
		Reporter.log("Cart Product total exception " ,true);
		//Reporter.log(e.getMessage(), true);
		//Reporter.log(e.getCause(), true);
		
		  
		  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		  captureEntirePage(screenShotDir,imageName);
		  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName );
		
	}
	
	
	return returnvalue;
}


public boolean  checkProductCountIncreased(String productID){
	boolean rv=false;
	
	try{
		
		String cc= homepage.CartCounter();
		
		Thread.sleep(5000);
		 homepage.CartCountIncrease(productID);
		//Thread.sleep(5000);
		//driver.findElement(By.cssSelector(".quantity-selector__inc.js-cart-item-inc")).click();
		
		 String icc= homepage.CartCounter();
		 
		
		if(icc.equalsIgnoreCase(cc)){
			
			Reporter.log("product count is not increased, issue in navigatinal arrows", true);
	
			
		}else{
			
			Reporter.log("product count is  increased as expected", true);
			rv=true;
		}
		
	}catch(Exception e){
		Reporter.log("product count exception", true);
		//Reporter.log(e.getMessage(), true);
		System.out.println(e.getLocalizedMessage());
		System.out.println(e.getCause());
		
		  
		  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		  captureEntirePage(screenShotDir,imageName);
		  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName );
		
		
	}
	
	return rv;
	
}


public boolean checkProductCountDecreased(String productID){
	boolean rv=false;
	
	try{
		String cc= homepage.CartCounter();
		 Thread.sleep(5000);
		 homepage.CartCountDescrease(productID);
		 String icc= homepage.CartCounter();
		if(icc.equalsIgnoreCase(cc)){
			Reporter.log("product count is not decreased, issue in navigatinal arrows", true);
			
			
		}else{
			Reporter.log("product count is  decreased as expected", true);
			rv=true;
		}
		
	}catch(Exception e){
		Reporter.log("product count exception", true);
		Reporter.log(e.getMessage(), true);
		  
		  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		  captureEntirePage(screenShotDir,imageName);
		  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName );
			
		
		
	}
	return rv;
}

public boolean removeProducts(String productID){
	boolean rv=false;
	
	try{
		homepage.removeProductFromCart(productID);
		if(checkEmptyMessage(productID)){
			Reporter.log("Remove functionalites works as expected ", true);
			rv=true;
		} else{
			Reporter.log("Remove functionalites not working, went to else", true);
			//System.out.println("checkEmptyMessage(productID)" +checkEmptyMessage(productID));
		}
		
	}catch(Exception e){
		Reporter.log("Remove functionalites not working exception", true);
		
		  
		  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		  captureEntirePage(screenShotDir,imageName);
		  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName );
		
	}
	
	return rv;
	
}


public boolean checkEmptyMessage(String productID){
	 boolean rv=false;
	
	try{
		Thread.sleep(5000);

		Reporter.log("product has remvoed from cart", true);

		if (homepage.emptyMessage().length()>=0){
			Reporter.log("Empty message is shows as expected ", true);
			Reporter.log("Empty message from Cart: "+homepage.emptyMessage() , true);
			rv= true;
			
		}else{
			Reporter.log("Empty message is not showing, went to else condition ", true);
		}
		
		
		
	}catch(Exception e){
		Reporter.log("Empty message is not showing, Exception ", true);
		
		
		  
		  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		  captureEntirePage(screenShotDir,imageName);
		  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName );
		
	}
	
	return rv;
}


public boolean CheckCartOverlayClose(){
	boolean rv=false;
	
	try{
		
		homepage.cartClose();
		Reporter.log(" Clicked the Cart pop-up ", true);

		homepage.cartCloseVerify();
		Reporter.log("Cart pop-up is closed", true);
		rv=true;
		
		
	}catch(Exception e){
		
		Reporter.log(" Cart pop-up clsoing issue", true);

		  
		  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		  captureEntirePage(screenShotDir,imageName);
		  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName );
		
		
		
		
		
	}
 return rv;	
}




public boolean checkout(String path, String imageName){
	try{
		String mpurl= driver.getCurrentUrl();
		homepage.ClickAllProductButtons();
		homepage.miniCartWebElement.click();
		homepage.miniCartChecoutButtonWebElement.click();
		waitFor(10000);
		waitForPageToLoad();
		waitFor(10000);
		closeDRPreOrderPopup();
		captureEntirePage(path, imageName);
		if(mpurl.equalsIgnoreCase(driver.getCurrentUrl())){
			return false;
		}else return true;
		
	}catch(Exception e){
		Reporter.log(" Check out exception" +e.getMessage(), true);

		  
		  String imageName1=Thread.currentThread().getStackTrace()[1].getMethodName();
		  captureEntirePage(screenShotDir,imageName1);
		  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName1 );
		
		return false;
		
	}


} 

public boolean specificProductCheckOut(String productID){
	String mpurl= driver.getCurrentUrl();
	addPrductToCrt( productID);
	homepage.miniCartChecoutButtonWebElement.click();
	waitFor(10000);
	waitForPageToLoad();
	waitFor(10000);
	closeDRPreOrderPopup();
	if(mpurl.equalsIgnoreCase(driver.getCurrentUrl())){
		return false;
		
		
		
	}else return true;
	
}


public void closeDRPreOrderPopup(){
	
	try{
		homepage.drPreOrderCloseButton.click();
		System.out.println("Info: DR pre order button has clsoed as excepted");
		waitFor(5000);
	}catch(Exception e){
		System.out.println("Info: DR pre order button not shows");
		waitFor(5000);
		
		  
		  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
		  captureEntirePage(screenShotDir,imageName);
		  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName );
		
	}
	
}


/**
 *  This method used to navigate the second tab in  Shield pro tab in shield tv and HI page.
 */

public static void tabNavigation(){
	
	
	
	try{
		
		List<WebElement> tabs =driver.findElements(By.xpath(".//li[contains(@data-tab, '-tab-2')]"));
		System.out.println("Info:List of tab elemets in the page "+tabs.size() );
		if(tabs.size()==1){
			System.out.println("Info:only one tab component in the page" );
		WebElement tab2= driver.findElement(By.xpath(".//li[contains(@data-tab, '-tab-2')]"));
		scrollTOElements(tab2);
		tab2.click();
		}else{
			System.out.println("Info: two tab component in the page" );
			WebElement we= tabs.get(1);
			scrollTOElements(we);
			we.click();
			
		}
	}catch(Exception e){
		Reporter.log(" webelement not found"+e.getMessage(), true);
	}
	
}


public  static void main(String args[]){
	String pi="318178200";
		AddToCart ad = new AddToCart();
		//browserInitialization("firefox","https://www2.nvidia.com/en-us/shield/" );
		browserInitialization("firefox","https://www.nvidia.com/en-us/shield/shield-tv/" );
		shieldHomWebElementInitialization();
		tabNavigation();
		//System.out.println(ad.CheckButtonText("5087552100", "PREORDER"));
		//System.out.println(ad.CheckCurrencyValue("5087552100", "$ 299.99"));
/*		ad.FirtsColumnBackgroundImage();
		ad.SecondColumnBackgroundImage();
		ad.scndColumn();
	
		
		ad.addPrductToCrt(pi);
		ad.CheckCartOverLayPopupAppears(pi);
		ad.CheckProductAddedToCart(pi);
		ad.checkCartCounterUpdate();
		ad.CheckTotalAmoutPresent();
		ad.checkSubToalPresent(pi);
		ad.checkProductCountIncreased(pi);
		ad.checkProductCountDecreased(pi);
		ad.removeProducts(pi);
		ad.checkEmptyMessage(pi);
		ad.CheckCartOverlayClose();
*/
		
		
		
	}

}
