package stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tools_TestScript {
	
	public static WebDriver driver;
	public static Properties file;
	
	@Given("I navigate to application Open URl")
	public void i_navigate_to_application_Open_URl() throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_116.exe");
		driver=new ChromeDriver();
		FileInputStream fis=new FileInputStream("Config.properties");
	    file=new Properties();
	    file.load(fis);
	    driver.get(file.getProperty("Url"));
	    driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
		
	}

	@When("User Enter Username and Password by click On login Button")
	public void user_Enter_Username_and_Password_by_click_On_login_Button() throws InterruptedException {
	    
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(file.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(file.getProperty("password"));
		driver.findElement(By.xpath("//input[@name='Login']")).click();
	    Thread.sleep(2000);
	}

	@Then("Login SucessfullY")
	public void login_SucessfullY() {
	    
		System.out.println("Login Sucessfully");
	}

	@Then("User is in vtigerCRM Home page")
	public void user_is_in_vtigerCRM_Home_page() throws InterruptedException {
	   
		Thread.sleep(2000);
		String actualResult=driver.getTitle();
		String ExceptedResult="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		if(actualResult.equalsIgnoreCase(ExceptedResult)) {
			
			System.out.println("Title Matched:  " + ExceptedResult );
			//System.out.println(ExceptedResult");
		}
		
		else {
			
			System.out.println("Title is not Matched");
		}
		
	}

	@Then("User has click on Tools tab")
	public void user_has_click_on_Tools_tab() throws InterruptedException {
	    
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[text()='Tools']")).click();
		WebElement Hover=driver.findElement(By.xpath("//a[text()='Tools']"));
		Actions action=new Actions(driver);
		action.moveToElement(Hover).build().perform();
		Thread.sleep(1000);
	}
	
	@Then("User verify and create Documents in Tools Page")
	public void user_verify_and_create_Documents_in_Tools_Page() {
		
		WebElement links=driver.findElement(By.linkText("Documents"));
		links.click();
		
	    
	}

}
