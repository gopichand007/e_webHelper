package shield.enus.com.nvidia.www.javatests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.adobe.cq.project.nvidia.testclasses.GCLogin;

public class DRCheckOutTests extends GCLogin{
	

	
	@Test(priority=1)
	public void VerifyOrderNumber(){
		Assert.assertTrue(OrderNumberIsGenerated());
		
		
	} 
	
	@Parameters("productID")
	@Test(priority=2)
	public void VerifyProduct(String productID){
		Assert.assertTrue(ValidProductHascarried(productID));
		
	}
	
	@Parameters("productID")
	@Test(priority=3)
	public void InitialProductCount(String productID){
		Assert.assertTrue(checkInitialProductCount(productID));
	}
	
	
	
	@Test(priority=4)
	public void VerfyCandyRack(){
		Assert.assertTrue(CandyRackIsPresented());
	}
	
	@Parameters({"emailAddress", "password"})
	@Test(priority=5)
	public void ValidLogin(String emailAddress, String password  ){
		boolean loginFlag= doValidLogin( emailAddress, password);
		if(loginFlag){
			
			  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
			  captureEntirePage(screenShotDir,imageName);
			  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName, true );
		}
		
		Assert.assertTrue(loginFlag);
	}
	
	@Test(priority=6)
	public void VerifyBillingAddress(){
		Assert.assertTrue(BilladdressInfoIsDisplayed());
	}
	
	@Test(priority=7)
	public void VerfyPaymentInfo(){
		Assert.assertTrue(PaymentInformationIsdisplayed());
		
	}
	
	@Parameters({"creditCardNumber", "cvv"})
	@Test(priority=8)
	public void  VerifynavigationfromCartandBillingpageToShippingInfopage(String creditCardNumber, String cvv){
		 boolean naivgationFlag=navigatefromCartandBillingpageToShippingInfopage( creditCardNumber,  cvv);
	
		Assert.assertTrue(naivgationFlag);
	}
	
	
	
/*	@Test(priority=9)
	public void VerfyAddressPanleIsDisplayed(){
		Assert.assertTrue( VerifyYourAddressPanelIsDisplayed());
		
	}
	*/
	
	@Test(priority=10)
	public void VerfyShoppingInfoPanelIsDisplayed(){
		
		boolean verifyShoppingflag=ShoppingInfoPanelIsDisplayed();
		
		if(verifyShoppingflag){
			
			  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
			  captureEntirePage(screenShotDir,imageName);
			  Reporter.log("Info: refer this screenshot:"+screenShotDir+" "+imageName, true );
		}
		
		Assert.assertTrue(ShoppingInfoPanelIsDisplayed());
		
	}
	
	@Test(priority=11)
	public void VerifyOrderpanel(){
		boolean verifyorderpanelflag=NavigateToVerifyOrder();
		
		if(verifyorderpanelflag){
			  String imageName=Thread.currentThread().getStackTrace()[1].getMethodName();
			  captureEntirePage(screenShotDir,imageName);
			  Reporter.log("refer this screenshot:"+screenShotDir+" "+imageName, true );
		}
		
		Assert.assertTrue(verifyorderpanelflag);
		
	}
	
	
/*	@Test(priority=12)
	public void completeOrdre() throws InterruptedException{
		driver.findElement(By.cssSelector("#dr_siteButtons>input")).click();
		boolean order= driver.findElement(By.id("dr_ThankYou")).isDisplayed();
		Thread.sleep(1000);
		Assert.assertTrue(order);
	}
	
	*/

}
