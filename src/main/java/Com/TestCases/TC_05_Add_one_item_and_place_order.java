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
import Com.PageObjects.OrderConfirmationPage;
import Com.PageObjects.PaymentPage;
import Com.PageObjects.ShoppingCartPage;

public class TC_05_Add_one_item_and_place_order extends BaseReusableMethods{
	
	@Test
	@TestInfo(TCId = "TC-105", tags = { Tags.Regression })
	public void verify_TC_05_Delete_item_from_cart_and_verify_item_removed_successfully() throws IOException, InterruptedException {
		
		LandingPage landingPage = new LandingPage();
		HomePage homePage = new HomePage();
		ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
		PaymentPage paymentPage=new PaymentPage();
		OrderConfirmationPage orderConfirmationPage=new OrderConfirmationPage();
		ExtentTest test = new ExtentManager().getTest();
		String inputItem="IPHONE 13 PRO";
		
		
		test.log(Status.INFO, "***Step 1: Launch application");
		test.log(Status.INFO, "***Step 2: Login using valid credentials");
		landingPage.enterUsername(UserInputData.getUsername());
		landingPage.enterPassword(UserInputData.getPassword());
		landingPage.clickLoginButton();
		
		test.log(Status.INFO, "***Step 3: Add at least one item to cart");
		homePage.addItemToCart(inputItem);
		
		test.log(Status.INFO, "***Step 4: Navigate to shopping cart and checkout");
		homePage.navigateToShoppingCart();
		shoppingCartPage.checkout();
		
		test.log(Status.INFO, "***Step 5: Fill all the payment details and place order");
		paymentPage.verifyDisplayed();
		paymentPage.enterCVVCode("123");
		paymentPage.enterNameOnCard("testing");
		paymentPage.selsectCountry("india");
		paymentPage.placeOrder();
		
		test.log(Status.INFO, "***Step 6: Verify order confirmation page");
		orderConfirmationPage.verifyDisplayed();
	}

}
