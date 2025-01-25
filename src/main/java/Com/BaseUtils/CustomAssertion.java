package Com.BaseUtils;

import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CustomAssertion{
	
	static ExtentTest test;

    public CustomAssertion(ExtentTest test) {
        this.test = test;
    }
	
	
	public static void assertTrue(boolean flag, String info) {
		Assert.assertTrue(flag);
		test.log(Status.PASS, info);
	}
	
	public static void assertFalse(boolean flag, String info) {
		Assert.assertFalse(flag);
		test.log(Status.PASS, info);
	}
	
	public static void assertEquals(int actual, int expected, String info) {
		Status getStatus = (actual==expected) ? Status.PASS : Status.FAIL;
		test.log(getStatus, "Actual: "+actual+", "+"Expected: "+expected+", "+info);
		Assert.assertEquals(actual, expected);
	}
	
	public static void assertEquals(String actual, String expected, String info) {
		Status getStatus = (actual==expected) ? Status.PASS : Status.FAIL;
		test.log(getStatus, "Actual: "+actual+", "+"Expected: "+expected+", "+info);
		Assert.assertEquals(actual, expected);
	}


}
