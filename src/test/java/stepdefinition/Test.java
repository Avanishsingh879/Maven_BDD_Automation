package stepdefinition;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_114.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		
	}

}
