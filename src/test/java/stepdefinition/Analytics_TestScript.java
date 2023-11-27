package stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Generic_Method.Utility_Method;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Analytics_TestScript {
	
	public static WebDriver driver;
	public static Properties files;
	
	@Given("I navigate to APPlication open UrL")
	public void i_navigate_to_APPlication_open_UrL() throws IOException {
	
		FileInputStream fis=new FileInputStream("Config.properties");
		files=new Properties();
		files.load(fis);
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_119.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(files.getProperty("Url"));
		System.out.println("Browser Launch");	
	 
	}

	@When("user Enter UsernamE and PassworD by clicK on login Button")
	public void user_Enter_UsernamE_and_PassworD_by_clicK_on_login_Button() throws InterruptedException, IOException {
		 
		Thread.sleep(1000);
		WebElement LoginBtn=driver.findElement(By.xpath("//input[@name='Login']"));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(files.getProperty("username"));
		Thread.sleep(1000);
		WebElement Pwd=driver.findElement(By.xpath("//input[@name='user_password']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='admin';",Pwd);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()", LoginBtn);
		System.out.println("Login Sucessfully");
		Thread.sleep(2000);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshot/Anaylitis.png"));
		System.out.println("Takes Screnshot");    
	}

	@Then("user is in VtigerCRM HOme page")
	public void user_is_in_VtigerCRM_HOme_page() throws InterruptedException {
		Thread.sleep(2000);
		String ActualTitle=driver.getTitle();
		String ExpTitle="admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM";
		Assert.assertEquals(ActualTitle, ExpTitle);
		System.out.println("HomePage Title Matched");    
	}

	@Then("User has click on Analytics tab")
	public void user_has_click_on_Analytics_tab() throws InterruptedException {
		
		Thread.sleep(2000);
		WebElement anylitcsBtn=driver.findElement(By.xpath("//a[text()='Analytics']"));
		anylitcsBtn.click();
		Utility_Method.captureScreenShot(driver);
		Thread.sleep(2000);
		
		
		
	}

	@Then("User has click on Reports tab")
	public void user_has_click_on_Reports_tab() {
		
	
		
	    
	}

	@Then("User verify and click on new report in Analytics Page")
	public void user_verify_and_click_on_new_report_in_Analytics_Page() {
		
		
		
	    
	}
	
	
	
	

}













