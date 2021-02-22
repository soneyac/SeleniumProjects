import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class deleteFromTable {
public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Soney_Chandra\\workspace\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver,300);
		/*driver.get("https://www.freecrm.com/");		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Log In"))));
    	WebElement mousehoverElement= driver.findElement(By.linkText("Log In"));
    	Actions action= new Actions(driver);
    	action.moveToElement(mousehoverElement).perform();
    	action.perform();
    	Robot robot= new Robot();
    	Point location = mousehoverElement.getLocation();
    	int x = location.getX();
    	int y = location.getY();
    	robot.mouseMove(x, y);
    	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		//Login
    	//driver.findElement(By.linkText("Log In")).click();*/
		driver.get("https://ui.freecrm.com/");
    	driver.findElement(By.name("email")).sendKeys("soneyac@gmail.com");
		driver.findElement(By.name("password")).sendKeys("KL11h+414");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='user-display']"))));
		//Click on Deals
		driver.findElement(By.xpath("//span[text()='Deals']")).click();
		Thread.sleep(3000);
		WebElement table= driver.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid table-scroll']"));
		List<WebElement> rows= table.findElements(By.xpath("//tbody/tr"));
		System.out.println("Total rows= "+rows.size());
		int rowno=1;
		for (WebElement row:rows){
			System.out.println(">>>>>> "+ row.getText());
				if(row.getText().contains("Deal2")){
					//System.out.println("Inside Deal1 and row count is "+rowno);
					DeleteRow(rowno);
					break;
				}
				else{
					rowno=rowno+1;
				//	System.out.println("Inside else statement and row count is "+rowno);
					continue;
				}	
			}
		Thread.sleep(1000);
		Boolean ItemFound= false;
		List<WebElement> refrshedRows= table.findElements(By.xpath("//tbody/tr"));
		System.out.println("RefrshedRow count is "+ refrshedRows.size());
		for (WebElement row:refrshedRows){
			System.out.println("!!!!!! "+ row.getText());
			if(row.getText().contains("Deal2")){
				System.out.println("TestCase Failed");
				break;
			}
			else{
				ItemFound= true;
				continue;
			}
		}
		if(ItemFound){
			System.out.println("TestCase Passed");
		}
		driver.quit();
	}
public static void DeleteRow(int RowCount) throws InterruptedException{
	driver.findElement(By.xpath("//tr["+RowCount+"]/td/div[@class='ui fitted read-only checkbox']")).click();
	driver.findElement(By.xpath("//tr["+RowCount+"]/td/div/button[@class='ui icon inverted button']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='ui tiny modal transition visible active']/div[3]/button[2]")).click();
	
}
}
