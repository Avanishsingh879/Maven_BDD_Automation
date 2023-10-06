package stepdefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Inventory_TestScript {
	
	public static WebDriver driver;
	public static Properties file;
	
	
	@Given("I navigate to application open UrL")
	public void i_navigate_to_application_open_UrL() throws IOException {
		
		FileInputStream fis=new FileInputStream("Config.properties");
		file=new Properties();
		file.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_116.exe");
		driver=new ChromeDriver();
		driver.get(file.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Browser Launch");
	    
	}

	@When("user Enter Username and Password by click on login Button")
	public void user_Enter_Username_and_Password_by_click_on_login_Button() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(file.getProperty("username"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(file.getProperty("password"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		System.out.println("Login Sucessfully");
		Thread.sleep(1000);
		
		
	    
	}

	@Then("login sucessfully")
	public void login_sucessfully() {
		
		System.out.println("Login Successfully");
		
	    
	}

	@Then("user is in VtigerCRM Home page")
	public void user_is_in_VtigerCRM_Home_page() throws InterruptedException {
		
		Thread.sleep(1000);
		String actualTitle=driver.getTitle();
		String expTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		Assert.assertEquals(actualTitle, expTitle);
		System.out.println("Title Matched");
		
		
	    
	}

	@Then("User has click on Inventory tab")
	public void user_has_click_on_Inventory_tab() throws InterruptedException {
		
		Thread.sleep(1000);
		WebElement linksBtn=driver.findElement(By.xpath("//a[text()='Inventory']"));
		linksBtn.click();
		System.out.println("Inverntoy Links clickable");
		Thread.sleep(1000);
		
	    
	}
	
	@Then("User verify the Creating Products in Marketing by click on Save button")
	public void user_verify_the_Creating_Products_in_Marketing_by_click_on_Save_button() throws InterruptedException {
		
		Thread.sleep(1000);
		
		
	   
	}
	
	
	

}
