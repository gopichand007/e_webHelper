package shield.enus.com.nvidia.www.businesslib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

	private static final String REGEX = "('/content.*')";
	   private static final String INPUT = "imageTabletUrl:'/content/dam/en-zz/Solutions/SHIELD/new/4apps/Apps-Google-1280.png', imageMobileUrl:'/content/dam/en-zz/Solutions/SHIELD/new/4apps/Apps-Google-295.jpg'";

	   public static void main( String args[] ) {
	      Pattern p = Pattern.compile(REGEX);
	      Matcher m = p.matcher(INPUT);   // get a matcher object
	      int count = 0;

	      while(m.find()) {
	         count++;
	         System.out.println("Match number "+count);
	         System.out.println("start(): "+m.group());
	         System.out.println("end(): "+m.group());
	      }
	   }
}