package Com.PageObjects;

import org.openqa.selenium.By;
import Com.BaseUtils.CustomAssert;
import Com.BaseUtils.DriverManager;
import Com.BaseUtils.FunctionUtil;
import Com.BaseUtils.IsPageDisplayed;

public class ShoppingCartPage extends DriverManager implements IsPageDisplayed{
	
	By myCartHeading=By.xpath("//h1[text()='My Cart']");
	By items=By.xpath("//div[@class='cartSection']/h3");
	

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

}
