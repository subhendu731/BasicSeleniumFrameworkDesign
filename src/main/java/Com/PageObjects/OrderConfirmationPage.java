package Com.PageObjects;

import org.openqa.selenium.By;
import Com.BaseUtils.CustomAssertion;
import Com.BaseUtils.DriverManager;
import Com.BaseUtils.FunctionUtil;
import Com.BaseUtils.IsPageDisplayed;

public class OrderConfirmationPage extends DriverManager implements IsPageDisplayed{
	
	By pageTitle=By.xpath("//h1[text()=' Thankyou for the order. ']");
	

	@Override
	public void verifyDisplayed() {
		// TODO Auto-generated method stub
		Boolean status=false;
		status=FunctionUtil.isElementExist(getDriver().findElement(pageTitle));
		CustomAssertion.assertTrue(status, "Order confirmation page is displayed.");
	}
	
	
}
