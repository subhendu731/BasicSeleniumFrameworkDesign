package Com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Com.BaseUtils.DriverManager;

public class LandingPage extends DriverManager{


	By usernameField = By.id("userEmail");
	By passwordField = By.id("userPassword");
	By loginBtn = By.name("login");

	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginBtn).click();
	}


}
