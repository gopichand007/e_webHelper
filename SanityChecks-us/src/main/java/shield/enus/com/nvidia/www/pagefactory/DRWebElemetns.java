package shield.enus.com.nvidia.www.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DRWebElemetns  {

	//Cart And Billing Info page web elements
	public String productXpath(String productID){
		 return ".//td[@class='dr_productName' and @data-pid='"+productID+"']";
		 
		 }
	
		//orderWL
	     @FindBy(how=How.ID, using="dr_orderNumber")public WebElement orderWL;
	     
	     //QuantityWL
	    public String productQuantity(String productID){
	    	return productXpath(productID)+"/following-sibling::td/div/input[1]"; 
	    	
	    } 
	     
	
		//Candyrack
	     @FindBy(how=How.ID, using="dr_candyRackHeader") public WebElement candyRack;	
	
	
		//LoginWebElements
	     @FindBy(how=How.ID, using="dr_login") public WebElement loginForm;
	     @FindBy(how=How.ID, using="loginID") public WebElement loginID;
	     @FindBy(how=How.ID, using="loginPass") public WebElement loginPass;
	     @FindBy(how=How.ID, using="dr_cc_login") public WebElement br_loginButton;
	     
	     
	    //After login 
	     
	     //Cart and billing info:
	     @FindBy(how=How.ID, using="dr_billingContainer") public WebElement dr_billingAddress;
	     @FindBy(how=How.ID, using="dr_paymentContainer") public WebElement dr_paymentContainer;
	     @FindBy(how=How.ID, using="cardSecurityCode") public WebElement dr_cardSecurityCode;
	     @FindBy(how=How.XPATH, using=".//*[@id='dr_siteButtons']/input[@class='dr_button']") public WebElement dr_CartAndBillinInfo_continue;
	     
	     
	     //Credit card update
	     @FindBy(how=How.ID, using="ccNum")public WebElement creditCardNumberWE;
	     @FindBy(how=How.ID, using="dr_ShoppingCart") public WebElement loginConfirmationWE;
	     
	     
	     
	     //verify your address pop-up
	     @FindBy(how=How.ID, using="dr_suggestionForm") public WebElement dr_verifyYouraddress;
	     @FindBy(how=How.ID, using="selectionButton") public WebElement dr_verifyYouraddress_useThisAddress;
	     
	     
	     // shipping info
	     @FindBy(how=How.ID, using="dr_shipping") public WebElement dr_shipping;
	     @FindBy(how=How.CSS, using="#dr_siteButtons>input") public WebElement dr_shipping_continue;
	     
	     
	     //Verify order 
	     @FindBy(how=How.ID, using="dr_ConfirmOrder") public WebElement verifyOder;  
	     

	     
	    
	     
	     
	
	
}
