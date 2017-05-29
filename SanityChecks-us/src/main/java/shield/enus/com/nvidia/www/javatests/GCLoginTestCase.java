package shield.enus.com.nvidia.www.javatests;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adobe.cq.project.nvidia.testclasses.GCLogin;

public class GCLoginTestCase extends GCLogin {

	
	@Parameters({"gcurlloginurl", "gc_userName", "gc_password", "gc_prodcutURL"})
	@Test(priority=1)
	public void gcLogin(String gcurlloginurl, String gc_userName, String gc_password, String gc_prodcutURL){
		boolean loginFlage= drGCLogin(gcurlloginurl,  gc_userName, gc_password, gc_prodcutURL);
		Assert.assertTrue(loginFlage);
		
	}
	
	
}
