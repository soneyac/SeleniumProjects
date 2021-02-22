import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SelectFromAjaxDropdown {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static void main(String[] args) {
		System.setProperty("WebDriver.ChromeDriver", "C:\\Users\\Soney_Chandra\\workspace\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("sss");
		try{
			Thread.sleep(1000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		List<WebElement> listOfElements= driver.findElements(By.xpath("//ul[@class='erkvQe']/li"));
		for(WebElement element:listOfElements){
			//System.out.println(element.getTagName());
			String text= element.getText();
			//System.out.println(text);
			//System.out.println("@@@@@@");
			if(text.equalsIgnoreCase("sssniperwolf house")){
				//System.out.println("Inside if");
				element.click();
				break;
			}
		}
		try{
			Thread.sleep(1000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String searchData= driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).getAttribute("value");
		//System.out.println(searchData);
		if(searchData.equalsIgnoreCase("sssniperwolf house")){
			System.out.println("TestCase is a PASS");
			driver.quit();
		}
		else{
			System.out.println("TestCase is a FAIL");
			driver.quit();
		}
	}

}
