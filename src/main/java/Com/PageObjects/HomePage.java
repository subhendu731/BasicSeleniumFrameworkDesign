package Com.PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;
import Com.BaseUtils.CustomAssertion;
import Com.BaseUtils.DriverManager;
import Com.BaseUtils.ExtentManager;
import Com.BaseUtils.FunctionUtil;
import Com.BaseUtils.IsPageDisplayed;

public class HomePage extends DriverManager implements IsPageDisplayed{
	
	
	By homeBtn=By.xpath("//button[@routerlink='/dashboard/']");
	By homePageTitle=By.xpath("//h3[text()='Automation']");
	By productName=By.cssSelector("div[class='card-body'] b");
	By addToCartBtn=By.cssSelector("div.card-body button:nth-of-type(2)");
	By cartBtn=By.xpath("//button[contains(@routerlink, 'cart')]");
	By ordersBtn=By.xpath("//button[contains(@routerlink, 'myorders')]");
	
	 
	
	public void verifyDisplayed() {
		Boolean status=false;
		status=FunctionUtil.isElementExist(getDriver().findElement(homePageTitle));
		CustomAssertion.assertTrue(status, "Homepage is displayed.");
	}
	
	public void addItemToCart(String itemName) {
		List<WebElement> allProducts = getDriver().findElements(productName);
		FunctionUtil.waitForElementVisible(allProducts.get(0), 10);
		List<WebElement> allAddToCartBtn = getDriver().findElements(addToCartBtn);
		for(int i=0; i<allProducts.size(); i++) {
			if(allProducts.get(i).getText().equalsIgnoreCase(itemName)) {
				FunctionUtil.click(allAddToCartBtn.get(i));
				CustomAssertion.assertTrue(true, "'"+itemName+"' has added to cart.");
			}
		}
	}
	



}
