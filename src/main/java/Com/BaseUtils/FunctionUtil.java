package Com.BaseUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public static void waitForElementVisible(WebElement element, int seconds) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementClickable(WebElement element, int seconds) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

}
