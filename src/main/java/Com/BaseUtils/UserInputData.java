package Com.BaseUtils;

import java.io.IOException;

public class UserInputData {
	
	public static String getURL() throws IOException {
		return BaseReusableMethods.getConfigProperty().getProperty("URL");
	}
	
	public static String getBrowser() throws IOException {
		return BaseReusableMethods.getConfigProperty().getProperty("Browser");
	}
	
	public static String getHeadless() throws IOException {
		return BaseReusableMethods.getConfigProperty().getProperty("Headless");
	}
	
	public static String getUsername() throws IOException {
		return BaseReusableMethods.getConfigProperty().getProperty("Username");
	}
	
	public static String getPassword() throws IOException {
		return BaseReusableMethods.getConfigProperty().getProperty("Password");
	}

}
