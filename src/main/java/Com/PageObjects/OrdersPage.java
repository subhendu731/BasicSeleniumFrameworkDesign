package Com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Com.BaseUtils.CustomAssertion;
import Com.BaseUtils.DriverManager;
import Com.BaseUtils.FunctionUtil;
import Com.BaseUtils.IsPageDisplayed;

public class OrdersPage extends DriverManager implements IsPageDisplayed{
	
	By ordersPageHeading=By.xpath("//h1[text()='Your Orders']");
	By yourOrdersTable=By.xpath("//div[contains(@class, 'container table')]");
	By totalOrdersCount=By.xpath("//tbody/tr/th");
	By ifOrdersWillBeMoreThan7txt=By.xpath("//div[contains(text(), 'If orders Will be more than 7 your last')]");
	By goBackToShopBtn=By.xpath("//button[text()='Go Back to Shop']");
	By goBackToCartBtn=By.xpath("//button[text()='Go Back to Cart']");
	

	@Override
	public void verifyDisplayed() {
		// TODO Auto-generated method stub
		boolean status=false;
		status=FunctionUtil.isElementExist(getDriver().findElement(ordersPageHeading));
		CustomAssertion.assertTrue(status, "Orders page is displayed.");
	}
	
	public void verifyYourOrdersTable() {
		boolean isDisplayed=false;
		boolean isTextDisplayed=false;
		isDisplayed=FunctionUtil.isElementExist(getDriver().findElement(yourOrdersTable));
		CustomAssertion.assertTrue(isDisplayed, "Your Orders table is displayed.");
		List<WebElement> totalOrders=driver.findElements(totalOrdersCount);
		CustomAssertion.assertEquals(totalOrders.size(), 7, "Total numbers of orders getting displayed.");
		isTextDisplayed=FunctionUtil.isElementExist(getDriver().findElement(ifOrdersWillBeMoreThan7txt));
		CustomAssertion.assertTrue(isTextDisplayed, "'If orders Will be more than 7 your last order will get deleted' text is displayed.");
	}
	
	public void verifyGoBackBtns() {
		boolean isGoBackToShopBtnDisplayed=false;
		boolean isGoBackToCartBtnDisplayed=false;
		isGoBackToShopBtnDisplayed=FunctionUtil.isElementExist(getDriver().findElement(goBackToShopBtn));
		isGoBackToCartBtnDisplayed=FunctionUtil.isElementExist(getDriver().findElement(goBackToCartBtn));
		CustomAssertion.assertTrue(isGoBackToShopBtnDisplayed, "'Go Back to Shop' button is displayed.");
		CustomAssertion.assertTrue(isGoBackToCartBtnDisplayed, "'Go Back to Cart' button is displayed.");
	}
	

}
