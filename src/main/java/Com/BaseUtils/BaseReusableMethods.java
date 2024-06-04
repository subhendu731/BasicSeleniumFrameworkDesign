package Com.BaseUtils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseReusableMethods extends DriverManager{
	
	@BeforeTest
	public void launchApplication() {
		getDriver();
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	public static File captureScreenshot(String testCaseName) throws IOException {
		//will invoke if execute through testNG xml
		String destinationPath=System.getProperty("user.dir")+"/Extent-Reports/"+testCaseName+".png";
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(destinationPath);
		FileUtils.copyFile(source, destination);
		System.out.println("Test case failed & screenshot captured...");
		return destination;
	}

}
