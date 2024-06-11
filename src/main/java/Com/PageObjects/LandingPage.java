package Com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.BaseUtils.DriverManager;
import Com.BaseUtils.FunctionUtil;

public class LandingPage extends DriverManager{


	By usernameField = By.id("userEmail");
	By passwordField = By.id("userPassword");
	By loginBtn = By.name("login");

	public void enterUsername(String username) {
		WebElement inputBox=driver.findElement(usernameField);
		FunctionUtil.input(inputBox, username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginBtn).click();
	}


}
