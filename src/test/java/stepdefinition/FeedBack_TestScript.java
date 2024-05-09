package stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FeedBack_TestScript {
	
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("User navigate the Application Url")
	public void user_navigate_the_Application_Url() throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_123.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		Thread.sleep(2000);
		System.out.println("Browser Launch");
		
		
	   
	}

	@When("User enter username and password by click on SingIn Page")
	public void user_enter_username_and_password_by_click_on_SingIn_Page() {
		
		
	    
	}

	@Then("User Login Sucessfully")
	public void user_Login_Sucessfully() {
		
		
	   
	}

	@Then("User verify Home Page functionlity")
	public void user_verify_Home_Page_functionlity() {
		
		
	    
	}

	@Then("User verify the FeedBack Page")
	public void user_verify_the_FeedBack_Page() {
		
		
	    
	}
	
	

}
