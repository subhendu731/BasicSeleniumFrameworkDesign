package Com.BaseUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static ExtentReports steUpReportObject() {
		String path = System.getProperty("user.dir") + "/Extent-Reports/index.html";
		System.out.println("Creating html report...!!");
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		extent = new ExtentReports();

		reporter.config().setReportName("Automation Testing");
		reporter.config().setDocumentTitle("Test Results");
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Subhendu");
		return extent;
	}

	public static ThreadLocal<ExtentTest> createTest(String testName) {
		ExtentTest getTest = extent.createTest(testName);
		extentTest.set(getTest);
		return extentTest;
	}
	
	public ExtentTest getTest() {
		return extentTest.get();
	}


}
