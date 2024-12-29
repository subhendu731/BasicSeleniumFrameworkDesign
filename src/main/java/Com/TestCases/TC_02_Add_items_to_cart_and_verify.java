package Com.TestCases;

import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Com.BaseUtils.BaseReusableMethods;
import Com.BaseUtils.ExtentManager;
import Com.BaseUtils.Tags;
import Com.BaseUtils.TestInfo;
import Com.BaseUtils.UserInputData;
import Com.PageObjects.HomePage;
import Com.PageObjects.LandingPage;
import Com.PageObjects.ShoppingCartPage;

public class TC_02_Add_items_to_cart_and_verify extends BaseReusableMethods{
	
	@Test
	@TestInfo(TCId = "TC-102", tags = { Tags.Regression })
	public void verify_TC_02_Add_items_to_cart_and_verify() throws IOException {
		
		LandingPage landingPage = new LandingPage();
		HomePage homePage = new HomePage();
		ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
		ExtentTest test = new ExtentManager().getTest();
		String inputItem="ADIDAS ORIGINAL";
		
		
		test.log(Status.INFO, "***Step 1: Launch application");
		test.log(Status.INFO, "***Step 2: Login using valid credentials");
		landingPage.enterUsername(UserInputData.getUsername());
		landingPage.enterPassword(UserInputData.getPassword());
		landingPage.clickLoginButton();
		
		test.log(Status.INFO, "***Step 3: Verify homepage is displayed");
		homePage.verifyDisplayed();
		
		test.log(Status.INFO, "***Step 4: Add at least one item to cart");
		homePage.addItemToCart(inputItem);
		homePage.navigateToShoppingCart();
		
		test.log(Status.INFO, "***Step 5: Verify item added to the cart successfully");
		shoppingCartPage.verifyItemAddedToCart(inputItem);
		
	}

}
