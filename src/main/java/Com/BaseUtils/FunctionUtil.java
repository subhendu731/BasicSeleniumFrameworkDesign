package Com.BaseUtils;

import org.openqa.selenium.WebElement;

public class FunctionUtil extends DriverManager{
	
	
	public static void click(WebElement element) {
		try {
			element.click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static boolean isElementExist(WebElement element) {
		boolean displayedStatus=false;
		try {
			displayedStatus=element.isDisplayed();
			return displayedStatus;
		}catch(Exception e) {
			return displayedStatus;
		}
	}
	
	
	

}
