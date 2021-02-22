import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.icu.impl.duration.TimeUnit;



public class fluentWait {

	public static void main(String[] args) {
		System.setProperty("WebDriver.geko.driver", "C:\\Users\\Soney_Chandra\\workspace\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("www.google.com/");
		//Wait<WebDriver> wait= new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECOND).pollingEvery(20, TimeUnit.SECOND).ignoring(NoSuchElementException.class);

	}

}
