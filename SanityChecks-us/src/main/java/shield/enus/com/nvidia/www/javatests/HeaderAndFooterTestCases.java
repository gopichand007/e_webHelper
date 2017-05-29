package shield.enus.com.nvidia.www.javatests;

import org.testng.annotations.Test;

import com.adobe.cq.project.nvidia.testclasses.HeaderAndFooter;

import junit.framework.Assert;

public class HeaderAndFooterTestCases extends HeaderAndFooter{
	
	

	@Test
	public void verifyHeaderNavigationalLinks(){
		Assert.assertTrue(CheckNavigationalheadreLinks());
	}
	
	
	@Test
	public void verifyFooterNavigationalLinks(){
		Assert.assertTrue(CheckNavigationalFooterLinks());
	}
	

	@Test
	public void verifyGlobalFooterNavigationalLinks(){
		Assert.assertTrue(CheckGloblaFooterLinks());
	}
	

	@Test
	public void verifylobalFooterSocialMediaLinks(){
		Assert.assertTrue(CheckGlobalFooterSocialMediaLinks());
	}
	



}


