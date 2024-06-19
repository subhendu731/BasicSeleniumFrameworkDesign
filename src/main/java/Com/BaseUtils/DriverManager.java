package Com.BaseUtils;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static WebDriver driver;
	public static String browser;
	public static boolean headless;

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
		browser = UserInputData.getBrowser();
		headless = UserInputData.getHeadless();

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
		EdgeOptions options=new EdgeOptions();
		if(headless) {
			options.addArguments("--headless=new");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--start-maximized");
		}
		driver = new EdgeDriver(options);
	}

	static void invokeChrome() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		if(headless) {
			options.addArguments("--headless=new");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--start-maximized");
		}
		driver = new ChromeDriver(options);
	}
	
	static void invokeFirefox() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options=new FirefoxOptions();
		if(headless) {
			options.addArguments("--headless=new");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--start-maximized");
		}
		driver=new FirefoxDriver(options);
	}

}
