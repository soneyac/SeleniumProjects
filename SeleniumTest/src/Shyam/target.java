package Shyam;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class target {
public static WebDriver  driver;
	public static void main(String[] args) {
		System.setProperty("WebDriver.gecko.driver","C:\\Users\\Soney_Chandra\\workspace\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.target.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions action= new Actions(driver);
		driver.findElement(By.xpath("//*[@data-lnk='BlackFridaysnea']")).click();
		WebDriverWait wait= new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//* [@type='button' and text()='Black Friday Ad']"))));
		driver.findElement(By.xpath("//* [@type='button' and text()='Black Friday Ad']")).click();
		int tabcount=1;
		List<WebElement> NoOfTabs= driver.findElements(By.xpath("//*[ @class='dwa-hotspots ng-isolate-scope']"));
		//System.out.println(NoOfTabs.size());
		for (WebElement tab: NoOfTabs){
			System.out.println("inside tab "+tabcount+" time");
			List<WebElement> InsideTabs=tab.findElements(By.tagName("path"));
			int internaltabcount=1;
			for (WebElement minitab:InsideTabs){
				System.out.println("inside minitab "+internaltabcount+" time");				
				action.moveToElement(minitab).build().perform();
				Wait wait1= new FluentWait(driver).withTimeout(30,TimeUnit.SECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(org.openqa.selenium.TimeoutException.class);
				wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[ @id='see-details-']"))));
				driver.findElement(By.xpath("//*[ @id='see-details-']")).click();
				System.out.println(driver.findElement(By.xpath("//*[@id='listingModalHeading']")).getText());
				try{
					if (driver.findElement(By.xpath("//*[@ng-if='modal.getListing().tcin']")).isDisplayed()){
					System.out.println(driver.findElement(By.xpath("//*[@ng-if='modal.getListing().tcin']")).getAttribute("value"));
					driver.findElement(By.xpath("//*[@id='closeButton']")).click();}
					}
				
				
				catch(Exception e){
					System.out.println("Online item # is nil");
					driver.findElement(By.xpath("//*[@id='closeButton']")).click();
				}
				internaltabcount=internaltabcount+1;
			}
			tabcount=tabcount+1;
		}
	}

}
