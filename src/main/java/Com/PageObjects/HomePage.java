package Com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.BaseUtils.CustomAssert;
import Com.BaseUtils.DriverManager;
import Com.BaseUtils.ExtentManager;
import Com.BaseUtils.FunctionUtil;
import Com.BaseUtils.IsPageDisplayed;
import Com.BaseUtils.TestNGListener;

public class HomePage extends DriverManager implements IsPageDisplayed{
	
	
	By homeBtn=By.xpath("//button[@routerlink='/dashboard/']");
	By homePageTitle=By.xpath("//h3[text()='Automation']");
	By productName=By.cssSelector("div[class='card-body'] b");
	By addToCartBtn=By.cssSelector("div.card-body button:nth-of-type(2)");
	By cartBtn=By.xpath("//button[contains(@routerlink, 'cart')]");
	
	 
	
	public void verifyDisplayed() {
		Boolean status=false;
		status=FunctionUtil.isElementExist(getDriver().findElement(homePageTitle));
		CustomAssert.assertTrue(status, "Homepage is displayed.");
	}
	
	public void addItemToCart(String itemName) {
		List<WebElement> allProducts = getDriver().findElements(productName);
		FunctionUtil.waitForElementVisible(allProducts.get(0), 10);
		List<WebElement> allAddToCartBtn = getDriver().findElements(addToCartBtn);
		for(int i=0; i<allProducts.size(); i++) {
			if(allProducts.get(i).getText().equalsIgnoreCase(itemName)) {
				FunctionUtil.click(allAddToCartBtn.get(i));
				CustomAssert.assertTrue(true, "'"+itemName+"' has added to cart.");
			}
		}
	}
	
	public void navigateToShoppingCart() {
		ExtentManager.getTest().log(Status.INFO, "***Navigate to Shopping cart page***");
		ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
		WebElement shoppingCart=driver.findElement(cartBtn);
		FunctionUtil.waitForElementClickable(shoppingCart, 10);
		FunctionUtil.clickByJavascript(shoppingCart);
		shoppingCartPage.verifyDisplayed();
	}


}
