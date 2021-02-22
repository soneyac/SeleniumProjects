import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.*;


public class test2 {
	public static void main(String args[]){
		System.setProperty("webdriver.geckodriver.driver", "C:\\Users\\Soney_Chandra\\workspace\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.google.com/");
		/*Actions action= new Actions(driver);
		org.openqa.selenium.interactions.Action act= action.click(driver.findElement(By.xpath("//*[@title='Search']")))
				.keyDown(Keys.SHIFT).sendKeys("test").keyUp(Keys.SHIFT).build();
		act.perform();*/
		driver.findElement(By.xpath("//*[@title='Search']")).sendKeys(Keys.SHIFT,"hello");
		driver.findElement(By.xpath("//*[@title='Search']")).submit();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement link=driver.findElement(By.xpath("//*[@class='hdtb-mitem hdtb-msel hdtb-imb']"));
		if (link.isDisplayed())
		{
			System.out.println("Test is pass");
			File f1= (File)((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
			try{
				FileUtils.copyFile(f1, new File("C:\\Users\\Shya\\Desktop\\Screenshots\\googletest.png"));
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Test is fail");
			
		}
		driver.quit();

	}
}
