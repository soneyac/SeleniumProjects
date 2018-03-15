import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class ScreenshotScript {
	public static void main(String args[]){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Soney_Chandra\\workspace\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Soney_Chandra\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);*/
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		File scrcp=(File) ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(scrcp,new File("C:\\Users\\Shya\\Desktop\\Screenshots\\facebook.png"));
		}
		catch (IOException e){
			e.printStackTrace();
		}
		driver.quit();
	}
	

}
