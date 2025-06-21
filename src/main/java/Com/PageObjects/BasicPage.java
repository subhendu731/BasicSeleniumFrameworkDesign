package Com.PageObjects;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;
import Com.BaseUtils.CustomAssertion;
import Com.BaseUtils.DriverManager;
import Com.BaseUtils.ExtentManager;
import Com.BaseUtils.FunctionUtil;
import Com.BaseUtils.IsPageDisplayed;
import Com.BaseUtils.UserInputData;

public class BasicPage extends DriverManager{
	
	
	public void loginToApplication() throws IOException {
		LandingPage landingPage = new LandingPage();
		landingPage.enterUsername(UserInputData.getUsername());
		landingPage.enterPassword(UserInputData.getPassword());
		landingPage.clickLoginButton();
	}
	
	public void navigateToShoppingCart() {
		HomePage homePage = new HomePage();
		ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
		
		ExtentManager.getTest().log(Status.INFO, "***Navigate to Shopping cart page***");
		WebElement shoppingCart=driver.findElement(homePage.cartBtn);
		FunctionUtil.waitForElementClickable(shoppingCart, 10);
		FunctionUtil.clickByJavascript(shoppingCart);
		shoppingCartPage.verifyDisplayed();
	}
	
	public void navigateToOrdersPage() {
		HomePage homePage = new HomePage();
		OrdersPage ordersPage=new OrdersPage();
		ExtentManager.getTest().log(Status.INFO, "***Navigate to Orders page***");
	
		WebElement orders=driver.findElement(homePage.ordersBtn);
		FunctionUtil.waitForElementClickable(orders, 10);
		FunctionUtil.clickByJavascript(orders);
		ordersPage.verifyDisplayed();
	}


}
