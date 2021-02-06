package freeCRM;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Function;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseClass {
	
public WebDriver driver;
public WebDriverWait wait;
public void initialize(){
	System.setProperty("WebDriver.Chrome.Driver", "C:\\Users\\Soney_Chandra\\workspace\\geckodriver.exe");
	driver=new ChromeDriver();
	//driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("https://freecrm.com/");
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	wait= new WebDriverWait(driver, 2000);
}
public void deinitialize(){
driver.quit();
}
public void threadSleep(int time){
	try {
		Thread.sleep(time);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}
