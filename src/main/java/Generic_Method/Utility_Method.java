package Generic_Method;

import java.io.File;
import java.util.Properties;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;




public class Utility_Method {
	
	
	//public static WebDriver DriverObject;
	public static Properties file;
    public static JavascriptExecutor Js;
    
	////////////////////////////////////////////////
   
    // TakeScreenshots
    public static void captureScreenShot(WebDriver driver)
    {
                  try {
                                       File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                                       FileUtils.copyFile(screenshot, new File("./Screenshots/Test.png"));
                           } catch (Exception e)
                             {
                                 System.out.println(e.getMessage());
                                  e.printStackTrace();
                              }
        }
    
    // MouseHover
    
    public static void Hover(WebDriver driver, WebElement element) {
    	Actions action = new Actions(driver);
    	action.moveToElement(element).perform();
    }
    
    //Highlight Elelmemt
    public static void highLightElement(WebDriver driver, WebElement element)
    {
    JavascriptExecutor js=(JavascriptExecutor)driver; 

    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

    try 
    {
    Thread.sleep(1000);
    } 
    catch (InterruptedException e) {

    System.out.println(e.getMessage());
    } 

    js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 

    }

    }

























