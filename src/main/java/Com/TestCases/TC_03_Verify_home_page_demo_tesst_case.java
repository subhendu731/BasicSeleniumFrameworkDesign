package Com.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Com.BaseUtils.BaseReusableMethods;
import Com.BaseUtils.ExtentManager;
import Com.BaseUtils.TestInfo;
import Com.BaseUtils.UserInputData;
import Com.Enums.Tags;
import Com.PageObjects.HomePage;
import Com.PageObjects.LandingPage;

public class TC_03_Verify_home_page_demo_tesst_case extends BaseReusableMethods{

	@Test
	@TestInfo(TCId = "TC-103", tags = { Tags.Sanity })
	public void verify_TC_03_Verify_methods() throws InterruptedException, IOException {
		
		LandingPage landingPage = new LandingPage();
		HomePage homePage = new HomePage();
		ExtentTest test = new ExtentManager().getTest();
		
		test.log(Status.INFO, "***Step 1: Launch application");
		test.log(Status.INFO, "***Step 2: Login using valid credentials");
		landingPage.enterUsername(UserInputData.getUsername());
		landingPage.enterPassword(UserInputData.getPassword());
		landingPage.clickLoginButton();
		
		test.log(Status.INFO, "***Step 3: Verify homepage is displayed");
		homePage.verifyDisplayed();
		Assert.assertEquals(3, 3);
	}

}
