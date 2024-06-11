package Com.TestCases;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Com.BaseUtils.BaseReusableMethods;
import Com.BaseUtils.ExtentManager;
import Com.PageObjects.HomePage;
import Com.PageObjects.LandingPage;


public class TC_01_Login_to_application extends BaseReusableMethods{

	@Test
	public void verify_TC_01_Login_to_application() throws InterruptedException {
		
		LandingPage landingPage = new LandingPage();
		HomePage homePage = new HomePage();
		ExtentTest test = new ExtentManager().getTest();

		
		test.log(Status.INFO, "***Step 1: Launch application");
		test.log(Status.INFO, "***Step 2: Login using valid credentials");
		landingPage.enterUsername("bsubhendu1996@gmail.com");
		landingPage.enterPassword("Sb@12345");
		landingPage.clickLoginButton();
		
		test.log(Status.INFO, "***Step 3: Verify homepage is displayed");
		homePage.verifyDisplayed();
		
	}

}
