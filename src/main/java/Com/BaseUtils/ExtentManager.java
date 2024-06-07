package Com.BaseUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	protected static ExtentReports extent;
	protected static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static ExtentReports steUpReportObject() {
		String path = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		extent = new ExtentReports();

		reporter.config().setReportName("Automation Testing");
		reporter.config().setDocumentTitle("Test Results");
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Subhendu Biswas");
		return extent;
	}

	public static ExtentTest createTest(String testName) {
		ExtentTest getTestName = extent.createTest(testName);
		extentTest.set(getTestName);
		return getTestName;
	}
	
	public static ExtentTest getTest() {
		return extentTest.get();
	}

}
