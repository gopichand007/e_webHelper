package shield.enus.com.nvidia.www.javatests;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.adobe.cq.project.nvidia.testclasses.VideoComponent;






public class VideoCompnentTestCases extends VideoComponent  {
	static Logger log = Logger.getLogger(VideoCompnentTestCases.class);

	@Test
	public void verifyHeroVideo(){
		Assert.assertTrue(homeHerovideoDisplay());
		
	}
	
	@Test
	public void verifyHeroVideoText(){
		Assert.assertTrue(homeHerovideoTextDisplay());
		
	}
	

	


	
	

}

