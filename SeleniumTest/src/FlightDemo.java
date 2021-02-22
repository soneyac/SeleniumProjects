import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlightDemo {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Soney_Chandra\\workspace\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.mercurytravels.co.in/flights");
		try{
			Thread.sleep(10000);	
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		WebElement iFrame = driver.findElement(By.xpath("//*[@id='fb-root']/div[2]/span/iframe"));
		
		WebElement iframe1=driver.findElement(By.xpath("//*[@id='fb-root']/div[3]/div/iframe[1]"));
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='fb-root']/div[2]/span/iframe")));
		
		System.out.println(" iframe is displayed " + iframe1.isDisplayed() + " iframe is Enabled  " + iframe1.isEnabled() + " iframe is Selected " + iframe1.isSelected() );
		
		driver.switchTo().frame(iframe1);
//		System.out.println(" iframe is displayed " + iFrame.isDisplayed() + " iframe is Enabled  " + iFrame.isEnabled() + " iframe is Selected " + iFrame.isSelected() );
				
		//System.out.println("inside iframe" + driver.getPageSource());
		wait= new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='logo']")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='close']")));
		//driver.findElement(By.xpath("//div[@class='_909e']")).click();
		//driver.findElement(By.xpath("//div[@aria-label='close']")).click();
		driver.findElement(By.xpath("//*[@id='logo']")).click();
	}

}
