package Com.BaseUtils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseReusableMethods extends DriverManager{
	
	
	
	@BeforeClass(alwaysRun = true)
	public void launchApplication() {
		getDriver();
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	@AfterClass(alwaysRun = true)
	public static void tearDown() {
		if (driver != null) {
            driver.quit();
            driver=null;
        }
	}
	
	public static File captureScreenshot(String testCaseName) throws IOException {
		//will invoke if execute through testNG xml
		String destinationPath=System.getProperty("user.dir")+"/test-output/errorImages/"+testCaseName+".png";
		
		TakesScreenshot ts=(TakesScreenshot)getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(destinationPath);
		FileUtils.copyFile(source, destination);
		return destination;
	}

}
