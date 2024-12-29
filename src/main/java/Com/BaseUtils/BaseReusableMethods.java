package Com.BaseUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Com.Enums.Environment;

public class BaseReusableMethods extends DriverManager{
	
	public static String getEnv;
	public static String defaultEnvFlag;
	
	@Parameters({"envFlag"})
	@BeforeClass(alwaysRun = true)
	public void launchApplication(@Optional String getEnvFlag) throws IOException {
		getDriver();
		
		//Getting default environment from configuration file
		defaultEnvFlag=UserInputData.getDefaultEnvFlag();
		
		//You should check for null first before calling isEmpty() to avoid a NullPointerException.
		getEnv=(getEnvFlag==null || getEnvFlag.isEmpty()) ? defaultEnvFlag : getEnvFlag;
		
		//Getting envFlag value from Enumeration/Enum
		driver.get(Environment.valueOf(getEnv).getURL());
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
		String destinationPath=System.getProperty("user.dir")+"/test-output/ExtentReports/errorImages/"+testCaseName+".png";
		
		TakesScreenshot ts=(TakesScreenshot)getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(destinationPath);
		FileUtils.copyFile(source, destination);
		return destination;
	}
	
	public static Properties getConfigProperty() throws IOException {
		String configFilePath = System.getProperty("user.dir")+"/src/main/resources/Config.properties";
		FileInputStream fis=new FileInputStream(configFilePath);
		Properties prop=new Properties();
		prop.load(fis);
		return prop;
	}
	


}
