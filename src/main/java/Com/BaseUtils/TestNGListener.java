package Com.BaseUtils;

import java.io.File;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class TestNGListener extends ExtentManager implements ITestListener {

	ExtentReports extent = ExtentManager.steUpReportObject();
	private ThreadLocal<CustomAssertion> customAssertions = new ThreadLocal<>();

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started.....!!");
		createTest(result.getTestClass().getName());
		extentTest.get().log(Status.INFO, "Test Started..!!");
		try {
			System.out.println("Browser_Flag: "+DriverManager.browserFlag);
			//System.out.println("Browser: "+UserInputData.getBrowser());
			System.out.println("Headless: "+UserInputData.getHeadless());
			System.out.println("Environment_Flag: "+BaseReusableMethods.getEnv);
			//System.out.println("URL: "+UserInputData.getURL());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Giving Extent knowledge to custom assertion
        customAssertions.set(new CustomAssertion(ExtentManager.getTest()));
	}
	
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.INFO, "Test Completed..!!");
		extent.flush();
		System.out.println("Passed = "+result.getTestClass().getName());
	}

	public void onFinish(ITestContext context) {
		//extent.flush();
		System.out.println("Execution Completed.......!!");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Failed = "+result.getTestClass().getName());
		//extentTest.get().log(Status.FAIL, "Test Failed..!!");
		File filePath = null;
		try {
			filePath = BaseReusableMethods.captureScreenshot(result.getTestClass().getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//This below code will attach screenshot with the failed step
		extentTest.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(filePath.getAbsolutePath()).build());
		extent.flush();
	}
	

}
