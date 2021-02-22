import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
public class googleTest {
public WebDriver driver;
@BeforeMethod
	public void setup() {
		System.setProperty("chromeDriver", "C:\\Users\\Soney_Chandra\\workspace\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
}
@Test
public void test1() {
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.xpath("//span[text()='selenium']")).click();
		String actual=driver.findElement(By.xpath("//span[text()='SeleniumHQ Browser Automation']")).getText();
		Assert.assertEquals(actual,"SeleniumHQ Browser Automation");
	}
@AfterMethod
public void teardown() {
driver.quit();
}

}
