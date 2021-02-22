import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class testngTest {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.geckodriver.driver", "C:\\Users\\Soney_Chandra\\workspace\\geckodriver.exe");
		driver= new FirefoxDriver();
		//System.setProperty("webdriver.chromedriver.driver", "C:\\libs\\Bin_Drivers\\chromedriver.exe");
		//driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
/*	@Test(priority=1, groups={"search", "google"})
	public void search(){
		driver.findElement(By.xpath("//*[@title='Search']")).sendKeys(Keys.SHIFT,"hello");
		driver.findElement(By.xpath("//*[@title='Search']")).submit();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement link=driver.findElement(By.xpath("//*[@class='hdtb-mitem hdtb-msel hdtb-imb']"));
		AssertJUnit.assertTrue(link.isDisplayed());
			
	}
	
	@Test(priority=2, groups={"logo", "google"}, dependsOnMethods="goToStore")
	public void logoTest(){
		WebElement logo= driver.findElement(By.id("hplogo"));
		AssertJUnit.assertTrue(logo.isDisplayed());
	}*/
	
	@Test(priority=0, groups={"store", "google"})
	public void goToStore(){
		
		WebElement link=driver.findElement(By.xpath("//*[@id='searchform']/div[1]/div[1]/a[2]"));
		link.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String title=driver.getTitle();
		AssertJUnit.assertEquals(title, "Official Google Store for Google Made Devices & Accessories");
			
	}

}
