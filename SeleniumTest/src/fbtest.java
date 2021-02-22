import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class fbtest {
	public static void main(String[] args){
	WebDriver driver;
	System.setProperty("webdriver.driver.gekodriver", "C:\\Users\\Soney_Chandra\\workspace\\geckodriver.exe");
	driver= new FirefoxDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("Soney");
	driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("Soney");
	}

}
