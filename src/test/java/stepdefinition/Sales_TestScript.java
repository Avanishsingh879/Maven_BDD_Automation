package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
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
import org.openqa.selenium.interactions.SendKeysAction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Sales_TestScript {
	
	
	public static WebDriver driver;
	public static Properties file;
	

	@Given("I navigate to application open URl")
	public void i_navigate_to_application_open_URl() throws InterruptedException, IOException {
	    
		FileInputStream fis=new FileInputStream("Config.properties");
		file=new Properties();
		file.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_106.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(file.getProperty("Url"));
		System.out.println("Browser launch");
		
	}

	@When("User Enter Username and Password By click on Login button")
	public void user_Enter_Username_and_Password_By_click_on_Login_button() throws InterruptedException, IOException {
	    
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(file.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(file.getProperty("password"));
		Thread.sleep(1000);
		File Folder=new File("Screenshots");
		if(Folder.exists()&& Folder.isDirectory()) {
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Screenshots/Login.png"));
		}
		
		System.out.println("Taking ScreenShot");
		
		driver.findElement(By.xpath(file.getProperty("Login"))).click();
		System.out.println("Login Page Verify");
		
		Thread.sleep(2000);
	}
	

	@Then("Login sucessfullY")
	public void login_sucessfullY() throws InterruptedException {
		 Thread.sleep(2000);
		   
		   System.out.println("Login Sucessfully");
	}

	@Then("User is in VtigerCRM home page")
	public void user_is_in_VtigerCRM_home_page() throws InterruptedException {
		
		Thread.sleep(2000);
		String ActualValue=driver.getTitle();
		String ExceptedValue="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		
		Assert.assertEquals(ExceptedValue, ActualValue);
		System.out.println("Home Page Verify");
		
		//if(ActualValue.equalsIgnoreCase(ActualValue)) {
			
			//System.out.println("Home Page Title Verify");
		//}
		
		//else {
			
			//System.out.println("Home Page Tile is not Verify");
		//}
		
	}
	
	
	@Then("User has click on Sales tab")
	public void user_has_click_on_Sales_tab() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement MouseHover=driver.findElement(By.xpath("//a[text()='Sales']"));
		Actions act=new Actions(driver);
		act.moveToElement(MouseHover).build().perform();
		System.out.println("MouseHover Done");
		Thread.sleep(2000);
	    	
	}
	
	@Then("User has click on Leads tab")
	public void user_has_click_on_Leads_tab() throws InterruptedException {
		
		
	    	
	}
	
	// Creating New Campaign
	
	@Then("User verify the Creating Leads in Sales by click on Save button")
	public void user_verify_the_Creating_Leads_in_Sales_by_click_on_Save_button() throws InterruptedException {
	    
		
		
		
	}

	
	

}
