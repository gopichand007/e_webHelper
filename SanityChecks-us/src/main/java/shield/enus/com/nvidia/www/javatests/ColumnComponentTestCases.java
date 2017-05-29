package shield.enus.com.nvidia.www.javatests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.adobe.cq.project.nvidia.testclasses.ColumnComponent;

public class ColumnComponentTestCases extends ColumnComponent {
	
	@Test
	public void verifyFirstColumnBackgroundImage(){
			Assert.assertTrue(FirtsColumnBackgroundImage());
		
	}

	@Test
	public void verifyScndColumnBackgroundImage(){
			Assert.assertTrue(SecondColumnBackgroundImage());
	
	}
/*
	@Test
	public void verifyScndClumDisplay(){
		Assert.assertTrue(scndColumn());
		
	}
 */

  @Test
   public void verifyAllLeftColumn(){
	  
	  if(leftColumn()){
		  Reporter.log("All left columns are displaying as expeted", true);
		  Assert.assertTrue(true);
		  
	  }else{
		  Reporter.log(" left column content is not displaying (Exception)", true);
		  Assert.assertTrue(false);
	  }
	  
  }
	

  @Test
  public void verifyAllRightColumn(){
	  
	  if(rightColumn()){
		  Reporter.log("All right columns are displaying as expeted", true);
		  Assert.assertTrue(true);
		  
	  }else{
		  Reporter.log(" left right content is not displaying (Exception)", true);
		  Assert.assertTrue(false);
	  }
	  
 }

  
 @Test
 public void verifyAllThreeColumn(){
	 
	  if(threeColumn()){
		  Reporter.log("All right columns are displaying as expeted", true);
		  Assert.assertTrue(true);
		  
	  }else{
		  Reporter.log(" left right content is not displaying (Exception)", true);
		  Assert.assertTrue(false);
	  }
	  
 }

	 

  
  
	
	
	
}
