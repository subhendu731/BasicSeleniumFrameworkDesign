package Com.TestCases;

import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Com.BaseUtils.BaseReusableMethods;
import Com.BaseUtils.ExtentManager;
import Com.BaseUtils.TestInfo;
import Com.BaseUtils.UserInputData;
import Com.Enums.Tags;
import Com.PageObjects.BasicPage;
import Com.PageObjects.HomePage;
import Com.PageObjects.LandingPage;
import Com.PageObjects.OrderConfirmationPage;
import Com.PageObjects.OrdersPage;
import Com.PageObjects.PaymentPage;
import Com.PageObjects.ShoppingCartPage;

public class TC_06_Orders_page_validation extends BaseReusableMethods{
	
	@Test
	@TestInfo(TCId = "TC-106", tags = { Tags.Regression })
	public void verify_TC_06_Orders_page_validation() throws IOException, InterruptedException {
		
		BasicPage basicPage=new BasicPage();
		OrdersPage ordersPage=new OrdersPage();
		ExtentTest test = new ExtentManager().getTest();
		
		
		test.log(Status.INFO, "***Step 1: Launch application");
		test.log(Status.INFO, "***Step 2: Login using valid credentials");
		basicPage.loginToApplication();
		
		test.log(Status.INFO, "***Step 3: Navigate to orders page from header");
		test.log(Status.INFO, "***Step 4: Verify orders page is displayed or not");
		basicPage.navigateToOrdersPage();
		
		test.log(Status.INFO, "***Step 5: Verify Your Orders table");
		ordersPage.verifyYourOrdersTable();
		
		test.log(Status.INFO, "***Step 6: Verify 'Go Back to Shop' and 'Go Back to Cart' button is displayed");
		ordersPage.verifyGoBackBtns();
	}

}
