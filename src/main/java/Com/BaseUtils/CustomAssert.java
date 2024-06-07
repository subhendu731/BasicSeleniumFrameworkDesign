package Com.BaseUtils;

import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CustomAssert{
	
	static ExtentTest test;

    public CustomAssert(ExtentTest test) {
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

}
