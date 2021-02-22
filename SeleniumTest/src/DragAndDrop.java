import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DragAndDrop {
	public static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("WebDriver.ChromeDriver", "C:\\Users\\Soney_Chandra\\workspace\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		Actions action= new Actions(driver);
		WebElement drag1=driver.findElement(By.xpath("//li[@id='credit2']"));
		WebElement drop1=driver.findElement(By.xpath("//li[@class='placeholder']"));
		action.dragAndDrop(drag1, drop1).build().perform();
		WebElement drag2=driver.findElement(By.xpath("//li[@class='block13 ui-draggable']"));
		WebElement drop2=driver.findElement(By.xpath("//li[@class='placeholder']"));
		action.dragAndDrop(drag2, drop2).build().perform();
	}

}
