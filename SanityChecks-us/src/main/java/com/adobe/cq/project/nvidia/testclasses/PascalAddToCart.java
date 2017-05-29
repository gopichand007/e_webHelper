package com.adobe.cq.project.nvidia.testclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PascalAddToCart extends AddToCart{
	
	public static void ProductIsAddedToCartOrnot(){
		
		boolean b=false;
		driver.navigate().refresh();
		
		try{
			Thread.sleep(10000);
			List<WebElement> buynows= driver.findElements(By.cssSelector(".cta-preorder-button.js-add-button"));
				int counter=1; 
				for(WebElement buynow: buynows){
					if(counter==1 ){

						buynow.click();
				
					}
					if(counter==2){
						AddToCart.scrollTOElements(buynow);
						buynow.click();
						break;
					}
			counter++;
		}
		
				Thread.sleep(5000);
				driver.findElement(By.cssSelector(".cart_black.cart.cart--shown"));

		}catch (Exception e ){
		
		}
	
		
		
	}
	

}
