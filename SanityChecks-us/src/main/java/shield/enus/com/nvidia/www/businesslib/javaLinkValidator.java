package shield.enus.com.nvidia.www.businesslib;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.testng.Reporter;

import shield.enus.com.nvidia.www.genericlib.ReportLib;

public class javaLinkValidator {
	public static String domain= "https://www2.nvidia.com/";
	//public static String domain= "https://wwwstage.nvidia.com/"; 
	//public static String domain1= "http://www2.nvidia.com/en-us/shield/apps";
	
	

	public static int URlValidator(String url ){
		int rv=0;
		URL weburl;
		HttpURLConnection connection = null;			     

		
		if(url != null ){
		try{
			weburl= new URL(url);
			connection = (HttpURLConnection)weburl.openConnection();
			connection.setConnectTimeout(15000);
			connection.setReadTimeout(15000);
			connection.setRequestMethod("GET");
			connection.connect();
			rv= connection.getResponseCode();
			
			if(rv==301 || rv==302){
				String redirectURl=handleingRedirect(url);
				rv=URlValidator(redirectURl);
				
				
			}
			
				
		}catch(Exception e){
			System.out.println(e.getMessage()+"URlValidator");
		
		}
		
		}	
		return rv;
	}
	
	
	public static String handleingRedirect(String url){
		  URL resourceUrl, base, next;
		  HttpURLConnection connection;
		  String location;
		  try{
		
			  while (true)
			  {
			     resourceUrl = new URL(url);
			     connection= (HttpURLConnection) resourceUrl.openConnection();
			     connection.setConnectTimeout(15000);
			     connection.setReadTimeout(15000);
			     connection.setInstanceFollowRedirects(false);   // Make the logic below easier to detect redirections
			     connection.setRequestProperty("User-Agent", "Mozilla/5.0");
			 	
			     
			     
			     switch (connection.getResponseCode())
			     {
			        case HttpURLConnection.HTTP_MOVED_PERM:
			        case HttpURLConnection.HTTP_MOVED_TEMP:
			           location = connection.getHeaderField("Location");
			           base     = new URL(url); 
			           next     = new URL(base, location);
			           url      = next.toExternalForm();

			          
			           continue;
			     }
	
			     break;
			  }
		  
		  }catch(Exception e){
			  Reporter.log("handleingRedirect exception"+e, true);
		  }
		
		return url;
	
	
	
	
	}
	
	public static boolean ListLinksValidator(ArrayList<String> alo){

		int serverResposne = 0;
		ArrayList<String> ar;
		ArrayList<String> par = null;
		ArrayList<String> nar = null;
		
		try{
			 ar = new ArrayList<String>();
			 par = new ArrayList<String>();
			 nar = new ArrayList<String>();
			 ar=alo;
			
			for (int i=0; i<ar.size(); i++ ){
				System.out.println("URL Validation is progress...... "+(ar.size()-i));
			
				try{
					 serverResposne=javaLinkValidator.URlValidator (ar.get(i));
					if(serverResposne==200){par.add(""+serverResposne+" :"+ar.get(i));}
					else{
						if(domain.equalsIgnoreCase(ar.get(i))){
						}else{
						nar.add(""+serverResposne+" :"+ar.get(i));
						}
					}
					}catch(Exception e){nar.add(""+serverResposne+" :"+ar.get(i));}
				}//for loop
			
		}catch(Exception e){Reporter.log("CheckNavigationalFooterLinks() exception", true);}
			return ReportLib.linkSeparateReport(par,nar);
	
	}
	

	public static void main(String args[]){
		javaLinkValidator jlv = new javaLinkValidator();
		System.out.println(URlValidator("https://shield.nvidia.com/games/android/badland2"));
		
	}
}




