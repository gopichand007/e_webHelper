package shield.enus.com.nvidia.www.pagefactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

import shield.enus.com.nvidia.www.genericlib.CQDriverCommonUtilities;
import shield.enus.com.nvidia.www.genericlib.CQDriverConfig;


public class shieldSiteMarkingWebElements{
	
	static Logger log = Logger.getLogger(shieldSiteMarkingWebElements.class);
	public static final String Page_Iframe = "//iframe[@id='cq-cf-frame']";
	public static WebDriver driver;

	public static  String REGEX = "('/content.*')";
	public static  String INPUT;

//****************************************************Header and footer****************************************************************************		
@FindBy(how=How.CSS, using=".page-footer-link-set__links>li>a") public  List<WebElement> nvgtnlFooterURLWebList;
@FindBy(how=How.CSS, using=".global-footer__links>li>a") public  List<WebElement> globalFooterURLWebList;
@FindBy(how=How.CSS, using=".sub-brand-item>a") public  List<WebElement> brandNavigationList;
@FindBy(how=How.CSS, using=".page-footer__social>a") public  List<WebElement> globalFooterSocialURlsList;




/**
 * All anchor links will grab respective div
 * @author gchand
 * @param web element list, it may have the duplicates 
 * @return array list which is the unique list list  ***/

	public ArrayList<String> specificWebElementsAnchorLinks(List<WebElement> webElementList){
			HashSet<String> hs = new HashSet<String>();
				for(WebElement wb:webElementList ){
					hs.add(wb.getAttribute("href"));
				
				
					}
			ArrayList<String> al = new ArrayList<String>(hs);
			return al;
			
		}

	
	
//*****************************************Add to cart**************************************************************************** 
	
	@FindBy(how=How.CSS, using=".cart_white.cart.cart--shown")
	public WebElement cartPopupDisplay;
	
	@FindBy(how=How.CSS, using=".nav-badge.cart-counter")
	public WebElement CartCounterValue;
	
	@FindBy(how=How.CSS, using=".cart__total")
	public WebElement cartTotal;
	
	@FindBy(how=How.CSS, using=".cart__empty")
	public WebElement emptyMessageClass;
	
	
	@FindBy(how=How.CSS, using=".cart__close")
	public WebElement cartClose;
	
	
	@FindBy(how=How.XPATH, using=".//*[@class='cart_white cart']")
	public WebElement cartpopupclose;
	
	
	public void cartCloseVerify(){
		cartpopupclose.getText();
	}
	
	
	public void cartClose(){
			cartClose.click();
		
	}
	
	
	public String emptyMessage(){
		return emptyMessageClass.getText();
		
		
	}

	 
	public void CartCountIncrease(String productID){
		System.out.println("CartCountIncrease 1");
		driver.findElement(By.xpath(".//li[@class='cart-item cart-item--"+productID+"']/div[1]/a[2]")).click();
		//driver.findElement(By.xpath(".//*[@class='cart-item cart-item--318178200']/div[1]/a[2]")).click();
		System.out.println("CartCountIncrease 2");
	}
	
	public void CartCountDescrease(String productID){
		driver.findElement(By.xpath(".//li[@class='cart-item cart-item--"+productID+"']/div[1]/a[1]")).click();
	}
	
	
	public void removeProductFromCart(String productID){
		driver.findElement(By.xpath(".//a[@class='cart-item__remove js-cart-item-remove' and @data-digital-river-id='"+productID+"']")).click();
	}
	
	public String  CartCounter(){
		return CartCounterValue.getText();
		}
	
	public String CartTotal(){
		return cartTotal.getText();
		
	}
	

	public String addToCartButtonWebElement (String productID) {
		String addtoCartButtonXpath=".//div[starts-with(@class,'product-row__item js-product-item') and @data-digital-river-id='"+productID+"']/div[2]/a";
		return addtoCartButtonXpath;

	}
	

	

	public String addToCartPriceWebElement (String productID) throws InterruptedException{
		String addtoCartPriceXpath=".//div[starts-with(@class,'product-row__item js-product-item') and @data-digital-river-id='"+productID+"']/div[1]";
		return addtoCartPriceXpath;
	
	}

	@FindBy(how=How.CSS, using =".cta-preorder-button.js-add-button.btn") List <WebElement> productsCTA;
	
	public void ClickAllProductButtons(){
		

		//for(WebElement clickButton:productsCTA ){
		for(int i=0; i<productsCTA.size(); i++){	
			try{
				//System.out.println("Debug productsCAT size"+productsCTA.size());
				WebElement clickButton=productsCTA.get(i); 
				CQDriverCommonUtilities.scrollTOElements(clickButton);
				clickButton.click();
				
				
				System.out.println("Debug productsCAT: "+productsCTA.toString());
			}catch(Exception e ){Reporter.log("ClickAllProductButtons: Exception in CheckoutFlow, ignorable", true);}
			}
			
	}
	
	 @FindBy(how=How.CSS, using =".nav-cart-link") public WebElement miniCartWebElement;
	 @FindBy(how=How.CSS, using=".nv-button.js-checkout.cart__checkout-button") public WebElement miniCartChecoutButtonWebElement;


	public ArrayList<String> CartProductDetails(String productID){
		ArrayList<String> al = new ArrayList<String>();
		al.add(driver.findElement(By.xpath(".//*[@class='cart-item cart-item--"+productID+"']/div[1]")).getText());
		al.add(driver.findElement(By.xpath(".//*[@class='cart-item cart-item--"+productID+"']/div[2]")).getText());
		al.add(driver.findElement(By.xpath(".//*[@class='cart-item cart-item--"+productID+"']/div[3]")).getText());
		return al;
		
	}
	
	
 @FindBy(how=How.CSS, using=".closeLink.dr_button") public WebElement drPreOrderCloseButton;

//*****************************************video component web elements**************************************************************************** 
	
	
	@FindBy(how=How.ID, using="slides1") WebElement videoSlide1;
	@FindBy(how=How.CSS, using="article") WebElement vidoeURL;
	@FindBy(how=How.CLASS_NAME, using= "content-cell") WebElement heroVideoText;
	@FindBy(how =How.CSS, using="source[src^='/content/dam']") List<WebElement> videoLinks;
	@FindBy(how=How.CLASS_NAME, using="cta-preorder-button js-add-button") List<WebElement> BuyNows;

	
	public void click1stBuynow(){
		int counter =0;
		for(WebElement BuyNow: BuyNows ){
			if(counter==0 )BuyNow.click();
			counter++;
			if(counter==1)BuyNow.click();
			
		}
	}
	
	
	
	public boolean videoSlide1(){
		
		boolean vs=videoSlide1.isDisplayed();
		 if(vs){
			 ArrayList<String> ar= new ArrayList<String>();  
			ar=videoURL();
			 for(String ars:ar ){
				 Reporter.log(ars, true);
			 }
		 }
		
		return vs;
	}

	

	public boolean heroVideoTextcomponent(){
		 boolean hvt=heroVideoText.isDisplayed();
		 if(hvt){
			 //ArrayList<String> ar= new ArrayList<String>();  
			 Reporter.log(heroVideoTexthelper(), true);
		
		 }
		
		return hvt;
	}


	
	public String heroVideoTexthelper(){
		//ArrayList<String> ar= new ArrayList<String>();
		String ar =heroVideoText.getText();
		
		
		return ar;
	}
	
	public ArrayList<String> videoURL(){
		
		ArrayList<String> ar= new ArrayList<String>();
		for(WebElement videoURL: videoLinks){
		System.out.println(videoURL.getAttribute("src"));
		ar.add(videoURL.getAttribute("src"));

		}
		return ar;
	}
	

	
	public ArrayList<String> videofbImageURL(){
		ArrayList<String> ar= new ArrayList<String>();
		
		 ar.add(vidoeURL.getAttribute("data-bcgimagetablet"));
		 ar.add(vidoeURL.getAttribute("data-bcgimagemobile"));
		 ar.add(vidoeURL.getAttribute("data-bcgimagepc"));
		 ar.add(vidoeURL.getAttribute("style"));
		return ar;
		 
	}
	

	

//*****************************************background column component web elements**************************************************************************** 
	@FindBy(how=How.XPATH, using=".//div[@class='row ' and starts-with(@id,'columnlayout' )]/div[1]") 
			WebElement Bg_FrstColumnLayoutxpath;
	@FindBy(how=How.XPATH, using=".//div[@class='row ' and starts-with(@id,'columnlayout')]/div[1]") 
	WebElement Bg_scndColumnLayoutxpath;

	public boolean frstbgdisplay(){
		return Bg_FrstColumnLayoutxpath.isDisplayed();
	}
	
	
	public boolean scndbgdisplay(){
		return Bg_scndColumnLayoutxpath.isDisplayed();
	}

	

//*****************************************2 column component**************************************************************************** 
	@FindBy(how=How.CSS ,using=".column-container.background-white.clearfix.p-t-60.p-b-60 ")
	WebElement scndclmlyt;
	
	
	public boolean scndClmDisplay(){
		return scndclmlyt.isDisplayed();
	}


	@FindBy(how=How.CSS, using=".column.left-column")  public List<WebElement> lftClmn;	
	@FindBy(how=How.CSS, using=".column.right-column")  public List<WebElement> rghtClmn;
	

	


	
//*****************************************3 column component**************************************************************************** 

	@FindBy(how=How.CSS, using=".column.small-12.medium-12.large-4")  public List<WebElement> threeclum;
	
	

	
//**********************************************Pascal ****************************************

	@FindBy(how=How.XPATH, using= ".//*[@id='titanx']/div[2]/div[2]/a/span") public static WebElement Herobanner_TitanX_Buy_now;	
	@FindBy(how=How.XPATH, using= ".//*[@id='shop']/div/div[3]/div[1]/div[2]/a/span") public WebElement ShopNow_TitanX_Buy_now;
	
	
//************************************************Apereal******************************************** 	
	
	
	public shieldSiteMarkingWebElements(WebDriver ldriver) {
		this.driver= ldriver;
	}
	
	public static void main(String args[])throws InterruptedException{
		//WebDriver driver = CQDriverConfig.webDriver("firefox", "https://www2.nvidia.com/en-us/shield/" );
		//WebDriver driver = CQDriverConfig.webDriver("firefox", "https://wwwdev.nvidia.com/content/nvidiaGDC/zz/en_ZZ/shield/apps/" );
		WebDriver driver = CQDriverConfig.webDriver("firefox", "https://www.nvidia.com/en-us/geforce/products/10series/titan-x-pascal/");
		shieldSiteMarkingWebElements homepage= PageFactory.initElements(driver, shieldSiteMarkingWebElements.class);
		
		driver.get("https://www.nvidia.com/en-us/geforce/products/10series/titan-x-pascal/");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='titanx']/div[2]/div[2]/a/span")).click();

	
		
		
		
		
		
		//System.out.println("heroImageandVideo: "+homepage.videoSlide1());
		//System.out.println("heroImageandVideotext"+homepage.heroVideoTextcomponent());
		//homepage.leftColumn();
		//homepage. videofbImageURL();
		//homepage.videoURL();
		
		//homepage.frstbgdisplay();
		//homepage.scndbgdisplay();
		//homepage.scndClmDisplay();
		//homepage.addToCartWebElement("318178200");
		

	}
	
}
