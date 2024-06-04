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
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Started.....!!");
		//createTest(result.getMethod().getMethodName());
		createTest(result.getTestClass().getName());
		extentTest.get().log(Status.INFO, "Test Started..!!");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		System.out.println("Test Completed.....!!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.FAIL, "Test Failed..!!");
		File filePath = null;
		try {
			filePath = BaseReusableMethods.captureScreenshot(result.getTestClass().getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//This below code will attach screenshot with the failed step
		extentTest.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(filePath.getAbsolutePath()).build());
	}
	

}
