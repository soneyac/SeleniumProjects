import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SeleniumTest 
{
	
	public static void main(String args[])
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\libs\\Bin_Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
	String baseUrl = "http://www.facebook.com";
	// launch Firefox and direct it to the Base URL
	driver.get(baseUrl);
	driver.findElement(By.id("email")).sendKeys("soneyac");
	driver.findElement(By.id("pass")).sendKeys("kl11h414");
	driver.findElement(By.cssSelector("[value='Log In']")).click();
	driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
	driver.findElement(By.id("pageLoginAnchor")).click();
	System.out.println("@@@@");
	driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
	System.out.println("#####");
	//List<WebElement> list= driver.findElements(By.xpath("html/body/div[22]/div/div/div/div/div[1]/div/div/ul/li"));
	//System.out.println(list.size()); 
	//System.out.println("***");
	//driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
	//WebDriverWait wait= new WebDriverWait(driver,1000);
	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("show_me_how_logout_1"))));
	System.out.println("!!!");
	
	//<a class="_54nc" href="#" data-gt="{&quot;ref&quot;:&quot;async_menu&quot;,&quot;logout_menu_click&quot;:&quot;menu_logout&quot;}" role="menuitem"><span><span class="_54nh"><form class="_w0d" action="https://www.facebook.com/logout.php" data-nocookies="1" id="show_me_how_logout_1" method="post" onsubmit="return window.Event &amp;&amp; Event.__inlineSubmit &amp;&amp; Event.__inlineSubmit(this,event)"><input type="hidden" name="fb_dtsg" value="AQGucqsfqTn0:AQFizN92FGdx" autocomplete="off"><input type="hidden" autocomplete="off" name="ref" value="mb"><input type="hidden" autocomplete="off" name="h" value="AfcXj36VCFbPc0R0"></form>Log Out</span></span></a>
//WebElement ele= driver.findElement(By.xpath("//form[contains(@class,'_w0d')]"));
	
	//List<WebElement> elements= driver.findElements(By.xpath("//a[contains(@class,'_54nc')]"));
	driver.findElement(By.xpath("//a[contains(@data-gt,'{\"ref\":\"async_menu\",\"logout_menu_click\":\"menu_logout\"}')]")).click();;
	/*for(WebElement ele:elements)
	{
		System.out.println(ele.getAttribute("data-gt"));
		if(ele.getAttribute("data-gt")!=null && ele.getAttribute("data-gt").contains("menu_logout"))
		{
			ele.click();
			break;
		}
	}
	*/
	}
	
}
