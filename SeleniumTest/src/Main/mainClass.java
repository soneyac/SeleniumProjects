package Main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class mainClass {
	public WebDriver driver;
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.driver.gekodriver", "C:\\Users\\Soney_Chandra\\workspace\\geckodriver.exe");
		driver= new FirefoxDriver();
		//driver.get("https://www.makemytrip.com/");
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
