package Com.TestCases;

import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Com.BaseUtils.BaseReusableMethods;
import Com.BaseUtils.ExtentManager;
import Com.BaseUtils.FunctionUtil;
import Com.BaseUtils.UserInputData;
import Com.PageObjects.HomePage;
import Com.PageObjects.LandingPage;
import Com.PageObjects.ShoppingCartPage;

public class TC_04_Delete_item_from_cart_and_verify_item_removed_successfully extends BaseReusableMethods{
	
	@Test
	public void verify_TC_04_Delete_item_from_cart_and_verify_item_removed_successfully() throws IOException {
		
		LandingPage landingPage = new LandingPage();
		HomePage homePage = new HomePage();
		ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
		ExtentTest test = new ExtentManager().getTest();
		String inputItem="IPHONE 13 PRO";
		
		
		test.log(Status.INFO, "***Step 1: Launch application");
		test.log(Status.INFO, "***Step 2: Login using valid credentials");
		landingPage.enterUsername(UserInputData.getUsername());
		landingPage.enterPassword(UserInputData.getPassword());
		landingPage.clickLoginButton();
		
		test.log(Status.INFO, "***Step 3: Add at least one item to cart");
		homePage.addItemToCart(inputItem);
		homePage.navigateToShoppingCart();
		
		test.log(Status.INFO, "***Step 4: Delete the added item from cart");
		shoppingCartPage.deleteItem();
		
		test.log(Status.INFO, "***Step 5: Verify 'No Products in Your Cart !' message");
		shoppingCartPage.verifyNoProductsinYourCartMsg();
		
	}

}
