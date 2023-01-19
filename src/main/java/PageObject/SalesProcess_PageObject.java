package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class SalesProcess_PageObject {
	
		
	@FindBy(name="Leads")
	public static WebElement Salads_clka;
	
	@FindBy(linkText="Leads")
	public static WebElement Leads_clk;
	
	@FindBy(xpath="//*[@name='Login']")
	public static WebElement Login_clk;
	
	
	
	public void Leads() 
	{ 
	Leads_clk.click(); 
	
	 } 
	
	
     

}
