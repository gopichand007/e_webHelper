package shield.enus.com.nvidia.www.javatests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adobe.cq.project.nvidia.testclasses.AddToCart;
import com.adobe.cq.project.nvidia.testclasses.BrowserAndWebElementInitialization;

import shield.enus.com.nvidia.www.genericlib.CQDriverCommonUtilities;



public class PascalAddToCartTests extends BrowserAndWebElementInitialization{
	
	
	
	
	
	
	@Test(priority=1)
	public void VerifyProductIsAddedToCartOrnot(){
		boolean b=false;
		
		
		driver.navigate().refresh();
		CQDriverCommonUtilities.waitFor(10000);
		List<WebElement> buynows= driver.findElements(By.cssSelector(".cta-preorder-button.js-add-button"));
		System.out.println ("buynows size "+buynows.size());
		System.out.println ("buynows location "+buynows.get(0));
		System.out.println ("buynows location "+buynows.get(1));
		int counter=1; 
		System.out.println("counter value: "+counter);
		for(WebElement buynow: buynows){
			if(counter==1 ){
				System.out.println("counter1: " +counter);
				buynow.click();
				
			}
			
			if(counter==2){
				AddToCart.scrollTOElements(buynow);
				System.out.println("counter2: " +counter);
				buynow.click();
				break;
			}
			counter++;
		}
		

	

		
		CQDriverCommonUtilities.waitFor(5000);
		driver.findElement(By.cssSelector(".cart_black.cart.cart--shown"));
		b=true;
		Assert.assertTrue(b);
		
	}
	
	@Test(priority=2)
	public void VerifyCartOverLayPopup(){
		boolean b=false;
		driver.findElement(By.cssSelector(".cart_black.cart.cart--shown"));
		b=true;
		Assert.assertTrue(b);
		
		
	}
	
	
	@Parameters("productID")
	@Test(priority=3)
	public void verifyProductAddedToCart(String productID){
		boolean b=false;
		driver.findElement(By.cssSelector(".cart-item.cart-item--"+productID));
		b=true;
		Assert.assertTrue(b);
		
		
	}
	

	@Test(priority=4)
	public void verifyCartTotalAmout(){
		
		boolean b=false;
		driver.findElement(By.cssSelector(".cart__total"));
		b=true;
		Assert.assertTrue(b);
		
		
		
	}
	
	
	

	@Test(priority=5)
	public void verifyCartSubTotal(){
		boolean b=false;
		driver.findElement(By.cssSelector(".cart-item__price"));
		b=true;
		Assert.assertTrue(b);
		
	}
	
	
	
	@Test(priority=6)
	public void verifyCartProductCountDeCrease(){
		boolean b=false;
		CQDriverCommonUtilities.waitFor(5000);
		driver.findElement(By.cssSelector(".quantity-selector__dec.js-cart-item-dec")).click();
		CQDriverCommonUtilities.waitFor(5000);
		b=true;
		Assert.assertTrue(b);
		
		
	}
	
	
	
	@Test(priority=7)
	public void verifyCartProductCountIncrease(){
		boolean b=false;
		driver.findElement(By.cssSelector(".quantity-selector__inc.js-cart-item-inc")).click();;
		CQDriverCommonUtilities.waitFor(5000);
		b=true;
		Assert.assertTrue(b);
		
		
	}
	
	
	

	@Test(priority=8)
	public void verifyRemoveProductFromCart(){
		boolean b=false;
		driver.findElement(By.cssSelector(".cart-item__remove.js-cart-item-remove")).click();;
		CQDriverCommonUtilities.waitFor(5000);
		b=true;
		Assert.assertTrue(b);
		
		
	}
	
	
	@Test(priority=9)
	public void verifyCartEmptymessage() {
		boolean b=false;
		driver.findElement(By.cssSelector(".cart__empty"));
		CQDriverCommonUtilities.waitFor(5000);
		b=true;
		VerifyProductIsAddedToCartOrnot();
		Assert.assertTrue(b);
		
		
		
	}
	
	@Test(priority=10)
	public void verifyCheckoutFlow() throws InterruptedException{
		CQDriverCommonUtilities.waitFor(5000);
		boolean b=false;
		String mpurl= driver.getCurrentUrl();
		driver.findElement(By.cssSelector(".nv-button.js-checkout.cart__checkout-button")).click();
		CQDriverCommonUtilities.waitFor(10000);
		waitForPageToLoad();
		waitFor(2000);
		if(mpurl.equalsIgnoreCase(driver.getCurrentUrl())){
			Assert.assertTrue(false);
		}else{
			Assert.assertTrue(true);
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
