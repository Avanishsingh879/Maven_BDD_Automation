package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Marketing_TestScript {
	
	public static WebDriver driver;
	
	
	@Given("I navigate to application open URL")
	public void i_navigate_to_application_open_URL() throws InterruptedException, IOException {
	    
		Thread.sleep(5000);
		FileInputStream fis=new FileInputStream("Config.properties");
		Properties prop=new Properties();
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver_106.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Url"));
		Thread.sleep(6000);
	}

	@When("User Enter Username and Password by click on login Button")
	public void user_Enter_Username_and_Password_by_click_on_login_Button() throws InterruptedException, IOException {
	    
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		 ////////Take Screenshot///////////
		File folder=new File("Screenshots");
		
		if(folder.exists()&& folder.isDirectory() ) {
			
			File newsrc= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(newsrc, new File("./Screenshots/Login.png"));
			
			System.out.println("Take Screenshot in Folder");
			
			Thread.sleep(2000);
		}
	    driver.findElement(By.xpath("//input[@name='Login']")).click();
	    
	    Thread.sleep(2000);
	}
	

	@Then("Login sucessfully")
	public void login_sucessfully() throws InterruptedException {
		 Thread.sleep(2000);
		   
		   System.out.println("Login Sucessfully");
	}

	@Then("User is in VtigerCRM Home page")
	public void user_is_in_VtigerCRM_Home_page() throws InterruptedException {
		String ActualTtile=driver.getTitle();
		String expTtile="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		if(ActualTtile.equalsIgnoreCase(expTtile)) {
			System.out.println("Title Matched");
		}
		
		else {
			
			System.out.println("Title Not Matched");
		}
	   
		Thread.sleep(2000);
	}
	
	
	@Then("User has click on Marketing tab")
	public void user_has_click_on_Marketing_tab() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Marketing']"));
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		Thread.sleep(2000);
		MouseHover.click();
		Thread.sleep(2000);
	    
		
		
	}

}
