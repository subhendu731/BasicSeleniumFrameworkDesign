package Com.BaseUtils;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			try {
				createDriver();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driver;
	}

	public static WebDriver createDriver() throws IOException {
		String browser = UserInputData.getBrowser();
		String headless = UserInputData.getHeadless();

		switch (browser) {
		case "chrome":
			invokeChrome();
			break;

		case "edge":
			invokeEdge();
			break;

		default:
			System.out.println("invalid browser....");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;
	}

	static void invokeEdge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	static void invokeChrome() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(option);
	}
	

}
