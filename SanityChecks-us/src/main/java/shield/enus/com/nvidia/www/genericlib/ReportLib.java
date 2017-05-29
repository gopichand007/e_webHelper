package shield.enus.com.nvidia.www.genericlib;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ReportLib extends CQDriverCommonUtilities {

	Logger log = Logger.getLogger(ReportLib.class);
	public String screenShotDir =System.getProperty("user.dir")+"\\screenshots";
	//static String path="C:\\temp\\";
	
	/**
	 * Method to capture the Screen Shot
	 */
	public void captureSreenShot() {

		log.debug("Inside captureSreenShot method");
		EventFiringWebDriver ef = new EventFiringWebDriver(driver);
		File srcFile = ef.getScreenshotAs(OutputType.FILE);
		File dstDir = new File(screenShotDir);
		try {
			
			FileUtils.copyFileToDirectory(srcFile, dstDir);
			log.info("ScreenShot captured successfully");
		} 
		catch (IOException e) {
			log.error("I/O Exception occured", e);
		}
		
		log.debug("Out of captureSreenShot method");
	}

	/**
	 * Method to capture screen shot in user defined filename and file extension <br>
	 * Support for .png, .jpeg, .gif etc
	 * @param filename
	 */
	public void captureSreenShot(String filename) {

		log.debug("Inside captureSreenShot method");
		
		EventFiringWebDriver ef = new EventFiringWebDriver(driver);
		File srcFile = ef.getScreenshotAs(OutputType.FILE);

		File dstFile = new File(screenShotDir + "//" + filename);
		try {
			
			FileUtils.copyFile(srcFile, dstFile);
			log.info("ScreenShot captured successfully");
		} 
		catch (IOException e) {
			log.error("I/O Exception occured", e);
		}
		
		log.debug("Out of captureSreenShot method");
	}

	
	
	public void captureEntirePage(String screenShotDir, String imagename){

		try{
			BufferedImage srcFile = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver).getImage();
			File outputfile = new File(screenShotDir+imagename+".jpg");
			ImageIO.write(srcFile, "jpg", outputfile);
		}catch(Exception e){
			
		}
		

/*		
	   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("c:\\temp\\screenshot.png"));*/

		
	}
	
	
	
	
	public  static boolean linkSeparateReport(ArrayList<String> p, ArrayList<String> n ){
		boolean rv=false;
		Reporter.log("Total URLs validated: " +(p.size()+n.size()), true);
		Reporter.log("Total URLs Passed: " +p.size()+"  And failed: "+n.size(), true);
		

		
		if(p.size()!=0){
			Reporter.log("***************************passed links************************", true);
			for(String st:p){Reporter.log(st, true);}
			
		}else{
			Reporter.log("***************************no passed links************************", true);
			
		}
		
		if(n.size()!=0){
			Reporter.log("***************************faild links************************", true);
			for(String st:n){Reporter.log(st, true);}
			
		}else{
			Reporter.log("***************************no faild links************************", true);
			rv=true;
			
		}
		
		return rv;
	}
	
	
	
	public static void main(String[] args) {
		ReportLib obj = new ReportLib();
		System.out.println("screenshotdir: "+obj.screenShotDir);
	}
}
