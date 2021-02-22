import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class twoWindows {
	public static WebDriver driver;
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Soney_Chandra\\workspace\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ui.freecrm.com/");		
		driver.findElement(By.name("email")).sendKeys("soneyac@gmail.com");
		driver.findElement(By.name("password")).sendKeys("KL11h+414");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		Thread.sleep(5000);
		Robot mouseActions= new Robot();
		mouseActions.keyPress(KeyEvent.VK_CONTROL);
		mouseActions.keyPress(KeyEvent.VK_N);
		mouseActions.keyRelease(KeyEvent.VK_CONTROL);
		mouseActions.keyRelease(KeyEvent.VK_N);
		Thread.sleep(5000);
		Set<String> window_Handles= driver.getWindowHandles();
		int count=0;
		String firstWindowHandleIs=null;
		for(String handle:window_Handles){
			if(count==0){
				count=count+1;
				firstWindowHandleIs=handle;
				continue;
			}
			else{
				driver.switchTo().window(handle);
			}
		}
		driver.navigate().to("https://ui.freecrm.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='settings icon']")).click();		
		driver.findElement(By.xpath("//span[text()='Log Out']")).click();
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(firstWindowHandleIs);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		String pageTitle=driver.getTitle();
		//Assert.assertEquals("Cogmento CRM", pageTitle);
		driver.quit();
	}

}
