import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseHover {
public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Soney_Chandra\\workspace\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/");	
		Thread.sleep(1000);
    	WebElement mousehoverElement= driver.findElement(By.linkText("Log In"));
    	Actions action= new Actions(driver);
    	action.moveToElement(mousehoverElement).click().perform();
    	Thread.sleep(1000);
    	String titleObtained=driver.getTitle();
    	System.out.println("Title is "+titleObtained);
    	Assert.assertEquals("Cogmento CRM", titleObtained);
    	driver.quit();

	}

}
