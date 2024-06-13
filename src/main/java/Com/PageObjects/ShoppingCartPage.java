package Com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Com.BaseUtils.CustomAssert;
import Com.BaseUtils.DriverManager;
import Com.BaseUtils.FunctionUtil;
import Com.BaseUtils.IsPageDisplayed;

public class ShoppingCartPage extends DriverManager implements IsPageDisplayed{
	
	By myCartHeading=By.xpath("//h1[text()='My Cart']");
	By items=By.xpath("//div[@class='cartSection']/h3");
	By deleteBtn=By.cssSelector(".btn.btn-danger");
	By noProductsinYourCartTxt=By.xpath("//h1[text()='No Products in Your Cart !']");
	

	@Override
	public void verifyDisplayed() {
		// TODO Auto-generated method stub
		Boolean status=false;
		status=FunctionUtil.isElementExist(getDriver().findElement(myCartHeading));
		CustomAssert.assertTrue(status, "Shopping Cart page is displayed.");
	}
	
	public void verifyItemAddedToCart(String item) {
		Boolean status=false;
		String getItemName=driver.findElement(items).getText();
		if(item.equalsIgnoreCase(getItemName)) {
			status=true;
		}
		CustomAssert.assertTrue(status, "Item '"+item+"' added to cart.");
	}
	
	public void deleteItem() {
		FunctionUtil.click(driver.findElement(deleteBtn));
	}
	
	public void verifyNoProductsinYourCartMsg() {
		WebElement noProductsTxt=driver.findElement(noProductsinYourCartTxt);
		CustomAssert.assertTrue(FunctionUtil.isElementExist(noProductsTxt), "'No Products in Your Cart !' msg is displayed.");
	}

}
