package Com.BaseUtils;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class FunctionUtil extends DriverManager{
	
	
	public static void click(WebElement element) {
		try {
			waitForElementClickable(element, 10);
			element.click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void clickByJavascript(WebElement element) {
		try {
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", element);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void input(WebElement inputBox, String value) {
		waitForElementVisible(inputBox, 10);
		inputBox.sendKeys(value);
		ExtentManager.getTest().log(Status.INFO, "'"+value+"' entered in the "+inputBox.getAccessibleName()+" field.");
	}
	
	public static boolean isElementExist(WebElement element) {
		boolean displayedStatus=false;
		try {
			waitForElementVisible(element, 10);
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
