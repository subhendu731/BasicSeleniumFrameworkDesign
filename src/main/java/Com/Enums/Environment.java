package Com.Enums;

public enum Environment {
	
	DEV("https://rahulshettyacademy.com/client/"),
	QA("https://rahulshettyacademy.com/client/"),
	STAGING(""),
	PROD("");
	
	private final String url;
	
	Environment(String url) {
		this.url=url;
	}

	public String getURL() {
		return url;
	}
	
}
