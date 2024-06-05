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
	

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started.....!!");
		createTest(result.getTestClass().getName());
		extentTest.get().log(Status.INFO, "Test Started..!!");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("Test Completed.....!!");
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, "Test Failed..!!");
		File filePath = null;
		try {
			filePath = BaseReusableMethods.captureScreenshot(result.getTestClass().getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//This below code will attach screenshot with the failed step
		extentTest.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(filePath.getAbsolutePath()).build());
	}
	

}
