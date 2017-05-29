package shield.enus.com.nvidia.www.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class gcDigitalRiverWebElements  {
	
	@FindBy(how=How.ID, using="j_username") public WebElement gc_userName;
	@FindBy(how=How.ID, using="j_password") public WebElement gc_password;
	@FindBy(how=How.ID, using="login") public WebElement gc_login;
	
	//After login 
	@FindBy(how=How.ID, using="sitePulse_pod") public WebElement gc_SiteTrends;
	
	
	//change the site
	@FindBy(how=How.ID, using="selectedSite") public WebElement gc_siteSelection;
	
	
	

}
