package shield.enus.com.nvidia.www.genericlib;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.log4testng.Logger;


public class CQDriverCommonUtilities extends CQDriverConfig {

	static Logger log = Logger.getLogger(CQDriverCommonUtilities.class);
	
	enum FindBy { ID, NAME, XPATH, LINKTEXT, TAGNAME, CLASSNAME }
	
	/**
	 * Thread will sleep till specified time interval  
	 * @param millis
	 */
	public static final void waitFor(long millis) {
			try {Thread.sleep(millis);} catch (InterruptedException e) {System.err.println("Wait was interrupted");}
		}

	
	/**
	 * Web Driver will wait until specified element is visible in view source.
	 * @param seconds
	 * @param wb
	 */
	
	public static void waitTillElementIsVisible(long seconds, WebElement wb) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(wb));
		} catch (NoSuchElementException e) {
			System.err.println("Wait was interrupted");
		}
	}


	/**
	 * Implicit wait for PageLoad
	 */
	
	public void waitForPageToLoad() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	
	public boolean waitForElementPresent(WebElement we){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(we));
			Reporter.log("Info: waitForElementPresent success "+we, true );
			return true;
		}catch(Exception e){
			Reporter.log("Error: Exception waitForElementPresent "+we, true );
			return false;
			
		}
		
	}
	
	
	public boolean webElementIsDisplayed(WebElement we){
		
		try{
			waitForElementPresent(we);
			scrollTOElements(we);
			Reporter.log("Info: webElementIsDisplayed "+we , true);
			return we.isDisplayed();
		}catch(Exception e){
			Reporter.log("Error: Exception in webElementIsDisplayed: "+we , true);
			return false;
		}
		
	}
	
	
	
	
	public void buttonClick(WebElement we){
		
		try{
			waitForElementPresent(we);
			we.click();
			Reporter.log("info: buttonClick() "+ we, true );
			
		}catch(Exception e){
			Reporter.log("Error: Exception in buttonClick() "+ we, true );
			
			
		}
		
	}
	
	
	
	
	/**
	 * WebDriver wait until the Element Present in UI, Max wait = 10 seconds 
	 * @param locator
	 * @param findBy
	 */
	public static void waitForElementPresent(String locator, String findBy) {
		log.debug("Inside waitForElementPresent method");
		log.info("Locator: " + locator + "| findby: " + findBy);

		FindBy findBylocator = null;
		try {
			findBylocator = FindBy.valueOf(findBy.toUpperCase());
			WebDriverWait wait = new WebDriverWait(driver, 5);

			if (findBylocator != null) {

				switch (findBylocator) {
				case ID:
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
					break;

				case NAME:
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
					break;

				case XPATH:
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
					break;

				case LINKTEXT:
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
					break;

				case CLASSNAME:
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
					break;
					
				default:
					log.debug("Entering into default XPATH selection");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
					break;
				}
			}
		} 
		catch (IllegalArgumentException e) {
			log.error("Enum Constant not defined for the given findBy "
					+ findBy, e);
		}
		catch (Exception e){
			log.error("Exception occured while locating the WebElement", e);
			
		}
		
		log.debug("Out of waitForElementPresent method");
	}

	/**
	 * Method to find the text in UI <br>
	 * Returns true is the Text is found else return false
	 * @param expectedText
	 * @return true/false
	 */
	public boolean verifyTextPresent(String expectedText) {
		
		log.debug("Inside verifyTextPresent method");
		log.info("Expected text: '" + expectedText + "'");
		boolean flag = false;
		
		String entirePageSource = driver.getPageSource();
		
		if (entirePageSource.contains(expectedText)) {
			log.info("Expected Text found in the page");
			flag = true;
		} 
		else {
			log.warn("Expected Text not found in the page");
		}
		
		log.debug("Out of verifyTextPresent method");
		return flag;
	}

	/**
	 * Method return list of WebElement 
	 * @param locator
	 * @param findBy
	 * @return List<WebElement>
	 */
public List<WebElement> findElements(String value, String findBy) {

		log.debug("Inside findElements method");
		log.info("value: " + value + "| findby: " + findBy);

		List<WebElement> list = null;

		try {
			FindBy findBylocator = FindBy.valueOf(findBy.toUpperCase());

			if (findBylocator != null) {

				switch (findBylocator) {
				case XPATH:
					list = driver.findElements(By.xpath(value));
					break;

				case TAGNAME:
					list = driver.findElements(By.tagName(value));
					break;

				default:
					log.debug("Entering into default XPATH selection");
					list = driver.findElements(By.xpath(value));
					break;
				}
			}
		} 
		catch (IllegalArgumentException e) {
			log.error("Enum Constant not defined for the given findBy "
					+ findBy, e);
		}
		catch (Exception e){
			log.error("Exception occured while finding the weblements", e);
			
		}
		
		log.debug("Out of findElements method");
		return list;
	}

	/**
	 * Method to get the Alert Text
	 * @return alert text
	 */
	public String getAlertText() {
		
		log.debug("Inside getAlertText method");
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		
		log.info("Alert text: '" + alertText + "'");
		log.debug("Out of getAlertText method");
		
		return alertText;
	}
	
	/**
	 * Method to accept the alert
	 */
	public void acceptAlert(){
		log.debug("Inside acceptAlert method");
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		log.info("Alert text: '" + alertText + "'");
		
		alert.accept();
		log.debug("Out of acceptAlert method");
	}
	
	/**
	 * Method to rejectAlert the alert
	 */
	public void rejectAlert(){
		log.debug("Inside dismissAlert method");
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		log.info("Alert text: '" + alertText + "'");
		
		alert.dismiss();
		log.debug("Out of rejectAlert method");
	}
	
	/**
	 * Method to select all element in a WebList
	 * @param element
	 */
	public void selectAllWebListElements(WebElement element) {
		
		log.debug("Inside selectAllWebListElements method");
		Select select = new Select(element);
		List<WebElement> list = select.getOptions();
		
		log.debug("WebList data: ");
		for (int i = 0; i < list.size(); i++) {
			WebElement webElement = list.get(i);
			log.debug(webElement.getText());
			select.selectByIndex(i);
		}
		
		log.debug("Out of selectAllWebListElements method");
	}
	
	public void maxmizeWindow(){
		driver.manage().window().maximize();
	}
	
	public void clickLink(String value){
		driver.findElement(By.linkText(value)).click();
	}
	

	

public static void scrollTOElements(WebElement addtoCartButton){
	
	try{
		

		
		
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].scrollIntoView();", addtoCartButton);
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-300)", "");
		Thread.sleep(1000);
		Reporter.log("info: Web element scrolling success "+addtoCartButton, true);
		
	}catch(Exception e){
		Reporter.log("Error: Web element scrolling issue "+addtoCartButton, true);

		
	}

	
}






	
}
