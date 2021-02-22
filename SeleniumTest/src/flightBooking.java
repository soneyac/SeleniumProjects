import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class flightBooking {
public static WebDriver driver;
@BeforeMethod
	public void setUp() {
		System.setProperty("Chrome.driver", "C:\\Users\\Soney_Chandra\\workspace\\geckodriver.exe");
		 driver= new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.get("https://phptravels.com/demo/");
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 //System.out.println(driver.getTitle());
		
		// driver.findElement(By.xpath("//div[@class='mc-closeModal']")).click();
		
		/*String actualResult=driver.findElement(By.xpath("//h1[@class='cw wow fadeIn title animated']")).getText();
		System.out.println(actualResult);
		System.out.println(driver.findElement(By.xpath("//h1[@class='cw wow fadeIn title animated']")).getAttribute("value"));
		Assert.assertEquals(actualResult , "We Love Customization's");*/
		//System.out.println(driver.getTitle());
		
	}
	@Test(priority=0)
	public void title1(){
		 Assert.assertEquals(driver.getTitle() , "Demo Script Test drive - PHPTRAVELS");
	}
	@Test(priority=1)
	public void title2(){
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//a[text()='Customizations']")).click();
		Assert.assertEquals(driver.getTitle() , "Integrated suppliers API's XML Json - PHPTRAVELS");
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
