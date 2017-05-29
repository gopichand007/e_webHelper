package com.adobe.cq.project.nvidia.testclasses;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import shield.enus.com.nvidia.www.genericlib.ReportLib;


public class PageLinkExtractor extends ReportLib{
	
	

	 
	public static  ArrayList <String> AnchorLinkExtratcor(){
		 LinkedHashSet <String> hs = new LinkedHashSet <String>();
		 
		 List<WebElement> wbLinks= driver.findElements(By.tagName("a"));
		for (WebElement Links: wbLinks){
				
				String link= Links.getAttribute("href");
				
				try{
					if(link.contains("http")){ hs.add(link);}
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				
				link= Links.getAttribute("data-href");
				try{
					if(link.contains("http")){ hs.add(link);}
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				
						
		}
		
		ArrayList <String> ar= new ArrayList <String>(hs);
		return ar;
		
		
	}
	
	public static  ArrayList <String> srcExtractor(){
		LinkedHashSet <String> hs = new LinkedHashSet <String>();
		List<WebElement> wbLinks= driver.findElements(By.tagName("img"));
		for (WebElement Links: wbLinks){
			String link= Links.getAttribute("src");
			try{
				if(link.contains("http")){ hs.add(link);}
			}catch(Exception e){
				System.out.println(e.getMessage()+"srcExtractor");
			}
			
		}
		ArrayList <String> ar= new ArrayList <String>(hs);	
	return ar;	
	}

	
	


}
