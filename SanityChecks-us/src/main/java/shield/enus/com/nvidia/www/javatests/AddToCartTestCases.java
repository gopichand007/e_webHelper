package shield.enus.com.nvidia.www.javatests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adobe.cq.project.nvidia.testclasses.AddToCart;


public class AddToCartTestCases extends AddToCart{
	
	@Parameters("productID")
	@Test(priority=1)
	public void  addProductToCart(String productID ){
		        if(productID.equalsIgnoreCase("5087552100")
				|| productID.equalsIgnoreCase("5088905300")// US
				|| productID.equalsIgnoreCase("5088796100")
				|| productID.equalsIgnoreCase("5089535200")// UK
				|| productID.equalsIgnoreCase("5088794700")
				|| productID.equalsIgnoreCase("5088905400")//DE
				|| productID.equalsIgnoreCase("5088796700")
				|| productID.equalsIgnoreCase("5088906100")//IT
				|| productID.equalsIgnoreCase("5088796200")
				|| productID.equalsIgnoreCase("5088905600")//FR
				|| productID.equalsIgnoreCase("5088796500")
				|| productID.equalsIgnoreCase("5088905900")//NL
				|| productID.equalsIgnoreCase("5088796300")
				|| productID.equalsIgnoreCase("5088905700")//NO
				
				
				
				)
			
		{tabNavigation();}
		Assert.assertTrue(addPrductToCrt(productID));
		
	}
	

	@Parameters({"productID","ButtonText"} )
	@Test(priority=2)
	public void verifyButtonText(String productID,  String buttonText){

		Assert.assertTrue(CheckButtonText( productID, buttonText));
		
	}
	
	
	@Parameters({"productID","currencyValue"} )
	@Test(priority=2)
	public void verifyPrice(String productID,  String currencyValue){
		Assert.assertTrue(CheckCurrencyValue( productID, currencyValue));
		
	}
	
	
	
	
	@Parameters("productID")
	@Test(priority=3)
	public void verifyCartOverLayPopup(String productID){
		Assert.assertTrue(CheckCartOverLayPopupAppears(productID));
		
		
	}
	
	
	@Parameters("productID")
	@Test(priority=4)
	public void verifyProductAddedToCart(String productID){
		Assert.assertTrue(CheckProductAddedToCart( productID));
		
		
	}
	
	
	@Test(priority=5)
	public void verifyCartTotalAmout(){
		Assert.assertTrue(CheckTotalAmoutPresent());
		
		
	}
	
	
	@Parameters("productID")
	@Test(priority=6)
	public void verifyCartSubTotal(String productID){
		Assert.assertTrue(checkSubToalPresent(productID));
		
		
	}
	
	@Test(priority=7)
	public void verifyCartCounterUpdate(){
		Assert.assertTrue(checkCartCounterUpdate());
		
		
	}
	
	@Parameters("productID")
	@Test(priority=8)
	public void verifyCartProductCountIncrease(String productID){
		Assert.assertTrue(checkProductCountIncreased(productID));
		
		
	}
	
	@Parameters("productID")
	@Test(priority=9)
	public void verifyCartProductCountDeCrease(String productID){
		Assert.assertTrue(checkProductCountDecreased(productID));
		
		
	}
	
	
	@Parameters("productID")
	@Test(priority=10)
	public void verifyRemoveProductFromCart(String productID){
		Assert.assertTrue(removeProducts(productID));
		
		
	}
	
	@Parameters("productID")
	@Test(priority=11)
	public void verifyCartEmptymessage(String productID){
		Assert.assertTrue(checkEmptyMessage(productID));
		
		
	}
	
	
	@Test(priority=12)
	public void verifyCartClose(){
		Assert.assertTrue(CheckCartOverlayClose());
		
		
	}
	
	@Parameters({"path","imageName"})
	@Test(priority=12)
	public void verifyCheckout(String path,  String imageName){
		Assert.assertTrue(checkout(path, imageName));
		
	}
	
	
	@Parameters("productID")
	@Test(priority=13)
	public void  specificProductCheckout(String productID){
		Assert.assertTrue(specificProductCheckOut(productID));
	}
	
	
	
	
	
}
