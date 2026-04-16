package Com.Enums;

public enum ConsoleColorCode {
	
	RESET("\u001B[0m"),
	RED("\u001B[31m"),
	GREEN("\u001B[32m"),
	PURPLE("\u001B[35m"),
	BLUE("\u001B[34m"),
	YELLOW("\u001B[33m");
	
	private final String colorCode;

	ConsoleColorCode(String colorCode) {
		// TODO Auto-generated constructor stub
		this.colorCode=colorCode;
	}
	
	
	public String getColorCode() {
		return colorCode;
	}

}
