package Com.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Com.BaseUtils.BaseReusableMethods;
import Com.PageObjects.HomePage;
import Com.PageObjects.LandingPage;

public class TC_01_Login_to_application extends BaseReusableMethods{

	@Test
	public void verify_TC_01_Login_to_application() throws InterruptedException {
		
		LandingPage landingPage = new LandingPage();
		HomePage homePage = new HomePage();
		
		
		System.out.println("Step-1: Login to application");
		landingPage.enterUsername("bsubhendu1996@gmail.com");
		landingPage.enterPassword("Sb@12345");
		landingPage.clickLoginButton();
		
		System.out.println("Step-2: Verify homepage is displayed");
		homePage.verifyDisplayed();
		Assert.assertTrue(false);
	}

}
