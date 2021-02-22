package POM;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//C:\Users\Soney_Chandra\workspace\SeleniumTest\src\POM\configuration.properties
public class BaseClass {
	protected WebDriver driver;
	private Properties property;
	public BaseClass(){
		try{
			property= new Properties();
			FileInputStream fis= new FileInputStream("C:\\Users\\Soney_Chandra\\workspace\\SeleniumTest\\src\\POM\\configuration.properties");
			property.load(fis);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void initialization(){
		String browsername=property.getProperty("browser");
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Soney_Chandra\\workspace\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browsername.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Soney_Chandra\\workspace\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(property.getProperty("url"));
		
	}
}
