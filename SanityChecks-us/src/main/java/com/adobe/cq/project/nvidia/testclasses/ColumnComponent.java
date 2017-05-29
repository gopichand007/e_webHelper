package com.adobe.cq.project.nvidia.testclasses;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;



public class ColumnComponent extends VideoComponent{
	static Logger log = Logger.getLogger(ColumnComponent.class);
	public static  String REGEX ;
	public static  String INPUT;



	
	
	public boolean FirtsColumnBackgroundImage(){
		boolean bgDisplay= false;
		try{
			bgDisplay= homepage.frstbgdisplay();
			Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" successful", true);
			
			}catch(Exception e){
				log.error("verifyHomePageFirtsColumnBackgroundImage() --> frstbgdisplay() exception "+e.getMessage());
				Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" exception", true);
	
			}
		return bgDisplay;
	}

	public boolean SecondColumnBackgroundImage(){
		boolean bgDisplay= false;
		
		try{
			bgDisplay= homepage.scndbgdisplay();
			Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" successful", true);
			}catch(Exception e){
			log.error("homePageSecondColumnBackgroundImage() --> scndbgdisplay() exception "+e.getMessage());
			Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" exception", true);

			
		}
			return bgDisplay;
	
	}
	
	public boolean scndColumn(){
		boolean bgDisplay= false;
		try{
			bgDisplay= homepage.scndbgdisplay();
			Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" successful", true);
			
			}catch(Exception e){
				log.error("homePagescndColumn() --> scndbgdisplay() exception "+e.getMessage());
				Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName()+" exception", true);
	
			}
		return bgDisplay;
	}
	
	
	
//**************************************************** two column layout *************************************************
	public boolean leftColumn(){
		boolean rv= false;
		ArrayList<String> ls= new ArrayList<String>();
		int count=0;

		try{
		
				for(WebElement st: homepage.lftClmn){
					
					if(!(st.getText().isEmpty())){
						count++;
					
						Reporter.log("Left Column: "+count+" "+st.getText(), true);
						rv=true;
				
						}else{
							WebElement st1= st.findElement(By.cssSelector(" script"));
							String st2=st1.getAttribute("textContent");
						
								if(!(st2.isEmpty())){
									count++;
									rv=true;
									ls= URLtrim(st2);
									if(ls.size()>=0){
										for(String s:ls){
											Reporter.log("Left Column: "+count+" "+s, true);
											
										}
										
									}
						
						
						
								}
						
						
					}
				
					
				}
			}catch(Exception e){
				Reporter.log(count+"right column layout component having issue (Excpetion)", true);
		}
		

		
		
		return rv;
		
	}
	

	

	public boolean rightColumn(){
		boolean rv= false;
		ArrayList<String> ls= new ArrayList<String>();
		int count=0;


		try{
		for(WebElement st: homepage.rghtClmn){
			
			if(!(st.getText().isEmpty())){
				count++;
			
				Reporter.log("right Column: "+count+" "+st.getText(), true);
				rv=true;
		
				}else{
					WebElement st1= st.findElement(By.cssSelector(" script"));
					String st2=st1.getAttribute("textContent");
				
						if(!(st2.isEmpty())){
							count++;
							rv=true;
							ls= URLtrim(st2);
							if(ls.size()>=0){
								for(String s:ls){
									Reporter.log("right Column: "+count+" "+s, true);
									
								}
								
							}
				
				
				
						}
				
				
			}
		}
		

		}catch(Exception e){
			
			Reporter.log(count+"right column layout component having issue (Excpetion)", true);
		}
		
		return rv;
		
	}
	
		
	
//*************************************************3 column layout ******************************************************************************	
	
	public boolean threeColumn(){
		boolean rv= false;
		ArrayList<String> ls= new ArrayList<String>();
		int count=0;


		try{
		for(WebElement st: homepage.threeclum){
			
			if(!(st.getText().isEmpty())){
				count++;
			
				Reporter.log("three Column: "+count+" "+st.getText(), true);
				rv=true;
		
				}else{
					WebElement st1= st.findElement(By.cssSelector(" script"));
					String st2=st1.getAttribute("textContent");
				
						if(!(st2.isEmpty())){
							count++;
							rv=true;
							ls= URLtrim(st2);
							if(ls.size()>=0){
								for(String s:ls){
									Reporter.log("three Column: "+count+" "+s, true);
									
								}
								
							}
				
				
				
						}
				
				
			}
		}
		

		}catch(Exception e){
			
			Reporter.log(count+"three column layout component having issue (Excpetion)", true);
		}
		
		return rv;
		
	}
	
		

	
	
//*************************************************************************************************************************************************
	
	private ArrayList<String> URLtrim(String st){
		ArrayList<String> ls= new ArrayList<String>();
		
		String st1=st.toString();
		INPUT= st1;
		REGEX = "(/content.*')";
		
		Pattern p = Pattern.compile(REGEX);
	      Matcher m = p.matcher(INPUT);   // get a matcher object

	      while(m.find()) {
	    	 ls.add(m.group());
	      }
				
		
		
		return ls;
		
	}
	

	
	
	
	public static void main(String args[]){
		ColumnComponent cc = new ColumnComponent();
		browserInitialization("firefox","https://www2.nvidia.com/en-us/shield/android-tv/" );
		shieldHomWebElementInitialization();
		System.out.println(cc.leftColumn());
		System.out.println(cc.rightColumn());
		System.out.println(cc.threeColumn());
		
		cc.FirtsColumnBackgroundImage();
		cc.SecondColumnBackgroundImage();
		cc.scndColumn();
		
	}
	
}
