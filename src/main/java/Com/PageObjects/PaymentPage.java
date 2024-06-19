package Com.PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Com.BaseUtils.CustomAssertion;
import Com.BaseUtils.DriverManager;
import Com.BaseUtils.FunctionUtil;
import Com.BaseUtils.IsPageDisplayed;

public class PaymentPage extends DriverManager implements IsPageDisplayed{
	
	By pageTitle=By.xpath("//div[@class='payment__title']");
	By cvvInputbox=By.xpath("//div[text()='CVV Code ']/../input");
	By nameOnCardInputbox=By.xpath("//div[text()='Name on Card ']/../input");
	By countryInputbox=By.xpath("//input[@placeholder='Select Country']");
	By countrySearchResults=By.xpath("//button[contains(@class, 'list-group-item')]");
	By placeOrderBtn=By.xpath("//a[contains(@class, 'action__submit')]");

	@Override
	public void verifyDisplayed() {
		// TODO Auto-generated method stub
		Boolean status=false;
		status=FunctionUtil.isElementExist(getDriver().findElement(pageTitle));
		CustomAssertion.assertTrue(status, "Payment page is displayed.");
	}
	
	public void enterCVVCode(String cvvCode) {
		driver.findElement(cvvInputbox).sendKeys(cvvCode);
	}
	
	public void enterNameOnCard(String nameOnCard) {
		driver.findElement(nameOnCardInputbox).sendKeys(nameOnCard);
	}

	public void selsectCountry(String country) throws InterruptedException {
		WebElement getCountryInputbox=driver.findElement(countryInputbox);
		FunctionUtil.clickByJavascript(getCountryInputbox);
		FunctionUtil.implicitWait(2);
		getCountryInputbox.sendKeys(country);
		FunctionUtil.implicitWait(2);
		List<WebElement> searchResults = driver.findElements(countrySearchResults);
		FunctionUtil.waitForElementVisible(searchResults.get(0), 10);
		for(WebElement getCountry : searchResults) {
			if(getCountry.getText().equalsIgnoreCase(country)) {
				FunctionUtil.clickByJavascript(getCountry);
				break;
			}
		}
	}
	
	public void placeOrder() {
		FunctionUtil.clickByJavascript(driver.findElement(placeOrderBtn));
	}
}
