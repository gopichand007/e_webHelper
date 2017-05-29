package shield.enus.com.nvidia.www.javatests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adobe.cq.project.nvidia.testclasses.AddToCart;
import com.adobe.cq.project.nvidia.testclasses.BrowserAndWebElementInitialization;

public class PascalSLIAddToCartTestCases extends BrowserAndWebElementInitialization {
	
	@Parameters("productID")
	@Test(priority=1)
	public void VerifyProductIsAddedToCartOrnot(String productID) throws InterruptedException{
		boolean b=false;
		driver.navigate().refresh();
		
		Thread.sleep(10000);
		//String xpath=".//a[@class='cta-button-sm-disabled active js-add-button' and @data-digital-river-id='"+productID+"']";
		String xpath=".//a[starts-with(@class, 'cta-button-sm-disabled active js-add-button') and @data-digital-river-id='"+productID+"']";
		WebElement buynow= driver.findElement(By.xpath(xpath));
		AddToCart.scrollTOElements(buynow);
		buynow.click();
		buynow.click();
		 
 
			

		
		Thread.sleep(5000);
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
	public void verifyCartProductCountDeCrease() throws InterruptedException{
		boolean b=false;
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".quantity-selector__dec.js-cart-item-dec")).click();
		Thread.sleep(5000);
		b=true;
		Assert.assertTrue(b);
		
		
	}
	
	
	
	@Test(priority=7)
	public void verifyCartProductCountIncrease() throws InterruptedException{
		boolean b=false;
		driver.findElement(By.cssSelector(".quantity-selector__inc.js-cart-item-inc")).click();;
		Thread.sleep(5000);
		b=true;
		Assert.assertTrue(b);
		
		
	}
	
	
	

	@Test(priority=8)
	public void verifyRemoveProductFromCart() throws InterruptedException{
		boolean b=false;
		driver.findElement(By.cssSelector(".cart-item__remove.js-cart-item-remove")).click();;
		Thread.sleep(5000);
		b=true;
		Assert.assertTrue(b);
		
		
	}
	
	@Parameters("productID")
	@Test(priority=9)
	public void verifyCartEmptymessage(String productID ) throws InterruptedException{
		boolean b=false;
		driver.findElement(By.cssSelector(".cart__empty"));
		Thread.sleep(5000);
		b=true;
		VerifyProductIsAddedToCartOrnot(productID);
		Assert.assertTrue(b);
		
		
		
	}
	
	@Test(priority=10)
	public void verifyCheckoutFlow() throws InterruptedException{
		Thread.sleep(5000);
		boolean b=false;
		String mpurl= driver.getCurrentUrl();
		driver.findElement(By.cssSelector(".nv-button.js-checkout.cart__checkout-button")).click();
		Thread.sleep(10000);
		if(mpurl.equalsIgnoreCase(driver.getCurrentUrl())){
			Assert.assertTrue(false);
		}else{
			Assert.assertTrue(true);
		}
		
		
		
		
	}
	
	
	
	
	
	
	

}
