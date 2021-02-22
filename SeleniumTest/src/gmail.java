import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class gmail {

	public static void main(String[] args) throws InterruptedException {
		/*System.setProperty("webdriver.geko.driver", "C:\\Users\\Soney_Chandra\\workspace\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();*/
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Soney_Chandra\\workspace\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.gmail.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("identifierId")).clear();
		driver.findElement(By.id("identifierId")).sendKeys("soneychandra@gmail.com");
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ap28ae+4219");
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
		Thread.sleep(5000);
		while(driver.findElement(By.xpath("//img[@class='amJ T-I-J3']")).isEnabled()){
			Select select= new Select(driver.findElement(By.xpath("//span[@class='asa bjy']")));
			select.deselectByVisibleText("Mark all as read");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//img[@class='amJ T-I-J3']")).click();
			Thread.sleep(5000);
		}
		driver.close();
		
		
	}

}
