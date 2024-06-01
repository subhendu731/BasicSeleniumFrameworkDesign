package Com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Com.BaseUtils.DriverManager;
import Com.BaseUtils.FunctionUtil;
import Com.BaseUtils.IsPageDisplayed;

public class HomePage extends DriverManager implements IsPageDisplayed{
	
	
	By homeBtn=By.xpath("//button[@routerlink='/dashboard/']");
	By homePageTitle=By.xpath("//h3[text()='Automation']");
	
	
	public void verifyDisplayed() {
		Boolean status;
		status=FunctionUtil.isElementExist(driver.findElement(homePageTitle));
		Assert.assertTrue(status);
	}


}
