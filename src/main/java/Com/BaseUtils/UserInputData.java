package Com.BaseUtils;

import java.io.IOException;

public class UserInputData {
	
	public static String getURL() throws IOException {
		return BaseReusableMethods.getConfigProperty().getProperty("URL");
	}
	
	public static String getBrowser() throws IOException {
		return BaseReusableMethods.getConfigProperty().getProperty("Browser");
	}
	
	public static boolean getHeadless() throws IOException {
		String getStringValue=BaseReusableMethods.getConfigProperty().getProperty("Headless");
		return Boolean.parseBoolean(getStringValue);
	}
	
	public static String getUsername() throws IOException {
		return BaseReusableMethods.getConfigProperty().getProperty("Username");
	}
	
	public static String getPassword() throws IOException {
		return BaseReusableMethods.getConfigProperty().getProperty("Password");
	}

}
