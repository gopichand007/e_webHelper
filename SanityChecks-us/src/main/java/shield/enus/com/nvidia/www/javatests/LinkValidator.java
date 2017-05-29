package shield.enus.com.nvidia.www.javatests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.adobe.cq.project.nvidia.testclasses.PageLinkExtractor;
import shield.enus.com.nvidia.www.businesslib.javaLinkValidator;





public class LinkValidator extends PageLinkExtractor{

@Test	
public void anchorURLValidator(){
	
		ArrayList <String> ar = new ArrayList<String>();
		ar= PageLinkExtractor.AnchorLinkExtratcor();
		Assert.assertTrue( javaLinkValidator.ListLinksValidator(ar));
		

		
		
}
@Test
public void imageLinkValidator(){
	ArrayList <String> ar = new ArrayList<String>();
	ar= PageLinkExtractor.srcExtractor();
	Assert.assertTrue( javaLinkValidator.ListLinksValidator(ar));
	


	
}


}





