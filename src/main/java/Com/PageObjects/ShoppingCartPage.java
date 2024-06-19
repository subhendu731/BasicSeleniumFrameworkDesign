package Com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Com.BaseUtils.CustomAssertion;
import Com.BaseUtils.DriverManager;
import Com.BaseUtils.FunctionUtil;
import Com.BaseUtils.IsPageDisplayed;

public class ShoppingCartPage extends DriverManager implements IsPageDisplayed{
	
	By myCartHeading=By.xpath("//h1[text()='My Cart']");
	By items=By.xpath("//div[@class='cartSection']/h3");
	By deleteBtn=By.cssSelector(".btn.btn-danger");
	By noProductsinYourCartTxt=By.xpath("//h1[text()='No Products in Your Cart !']");
	By checkoutBtn=By.xpath("//button[text()='Checkout']");
	

	@Override
	public void verifyDisplayed() {
		// TODO Auto-generated method stub
		Boolean status=false;
		status=FunctionUtil.isElementExist(getDriver().findElement(myCartHeading));
		CustomAssertion.assertTrue(status, "Shopping Cart page is displayed.");
	}
	
	public void verifyItemAddedToCart(String item) {
		Boolean status=false;
		String getItemName=driver.findElement(items).getText();
		if(item.equalsIgnoreCase(getItemName)) {
			status=true;
		}
		CustomAssertion.assertTrue(status, "Item '"+item+"' added to cart.");
	}
	
	public void deleteItem() {
		FunctionUtil.click(driver.findElement(deleteBtn));
	}
	
	public void verifyNoProductsinYourCartMsg() {
		WebElement noProductsTxt=driver.findElement(noProductsinYourCartTxt);
		CustomAssertion.assertTrue(FunctionUtil.isElementExist(noProductsTxt), "'No Products in Your Cart !' msg is displayed.");
	}
	
	public void checkout() {
		FunctionUtil.clickByJavascript(driver.findElement(checkoutBtn));
	}

}
