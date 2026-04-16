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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static WebDriver driver;
	public static boolean headless;
	public static String browserFlag;
	public static String defaultBrowserFlag;

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
		headless = UserInputData.getHeadless();

		if (browserFlag == null) {
			browserFlag = defaultBrowserFlag;
		}

		if (browserFlag != null) {
			browserFlag = browserFlag.trim().toLowerCase();
		}

		switch (browserFlag) {
		case "chrome":
			invokeChrome();
			break;

		case "edge":
			invokeEdge();
			break;

		case "firefox":
			invokeFirefox();
			break;

		default:
			System.out.println("Invalid or unsupported browser flag: " + browserFlag + ". Using Chrome instead.");
			invokeChrome();
		}
		if (driver != null) {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		}
		return driver;
	}

	static void invokeEdge() {
		try {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			if (headless) {
				options.addArguments("--headless=new");
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--start-maximized");
			}
			driver = new EdgeDriver(options);
		} catch (Exception e) {
			System.err.println("Edge driver setup failed. Falling back to Chrome. Error: " + e.getMessage());
			invokeChrome();
		}
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

	@Parameters("browserFlag")
	@BeforeClass(alwaysRun = true)
	public void setBrowserFlag(@Optional("chrome") String getBrowserFlag) throws IOException {
		
		//@Optional will be called when browserFlag parameter is missing in testNG.xml
		//Getting default browserFlag from configuration file
		defaultBrowserFlag = UserInputData.getDefaultBrowserFlag();
		browserFlag = (getBrowserFlag == null || getBrowserFlag.isEmpty()) ? defaultBrowserFlag : getBrowserFlag;
		if (browserFlag != null) {
			browserFlag = browserFlag.trim();
		}
	}
}
