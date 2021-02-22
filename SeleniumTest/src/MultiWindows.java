import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MultiWindows {
	public static WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("Chrome.driver", "C:\\Users\\Soney_Chandra\\workspace\\geckodriver.exe");
		 driver= new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.get("http://the-internet.herokuapp.com/");
		 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	@Test(priority=0)
	public void test1(){
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		String header=driver.findElement(By.tagName("h3")).getText();
		Assert.assertEquals(header , "Opening a new window");
	}
	@Test(priority=2)
	public void test3(){
		driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
		WebElement element= driver.findElement(By.id("dropdown"));
		Select select= new Select(element);
		select.selectByVisibleText("Option 1");
		File file=(File) ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\Shya\\Desktop\\MultiWindows.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=1)
	public void test2(){
	driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
	driver.findElement(By.linkText("Click Here")).click();
	Set<String> handles= driver.getWindowHandles();
	for (String windowHandle : handles) {
		//switch to each browser window
		driver.switchTo().window(windowHandle);
		String title = driver.getTitle();
		if(title=="New Window"){
			driver.close();
		}
		}
	}
	@Test(priority=3)
	public void test4(){
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		String left=driver.findElement(By.xpath("/html/body")).getText();
		Assert.assertEquals(left, "LEFT");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
		driver.switchTo().frame("frame-middle");
		String middle=driver.findElement(By.xpath("//div[@id='content']")).getText();
		Assert.assertEquals(middle, "MIDDLE");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
		driver.switchTo().frame("frame-right");
		String right=driver.findElement(By.xpath("/html/body")).getText();
		Assert.assertEquals(right, "RIGHT");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-bottom");
		String bottom=driver.findElement(By.xpath("/html/body")).getText();
		Assert.assertEquals(bottom, "BOTTOM");
	}
	@Test(priority=4)
	public void test5(){
		driver.findElement(By.xpath("//a[text()='Hovers']")).click();
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(" //*[@id='content']/div/div[2]/img"))).perform();
		String name= driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/h5")).getText();
		Assert.assertEquals(name, "name: user2");
		//driver.findElement(By.xpath("//a[@href='/users/2']")).click();
	}
	@Test(priority=5)
	public void test6(){
		driver.findElement(By.xpath("//a[text()='Frames']")).click();
		driver.findElement(By.xpath("//a[text()='iFrame']")).click();
		driver.switchTo().frame("mce_0_ifr");
		//getAttribute("Value")
		String p=driver.findElement(By.xpath("//*[@id='tinymce']/p")).getText();
		//System.out.println(p);
		Assert.assertEquals(p, "Your content goes here.");
		driver.findElement(By.xpath("//*[@id='tinymce']/p")).clear();
		Actions action= new Actions(driver);
		WebElement element=driver.findElement(By.xpath("//*[@id='tinymce']/p"));
		action.moveToElement(element).click().sendKeys("Hi! how are you?").perform();
		String p1=driver.findElement(By.xpath("//*[@id='tinymce']/p")).getText();
		Assert.assertEquals(p1, "Hi! how are you?");
	}
	@Test(priority=6)
	public void test7(){
		
		try {
			String username = URLEncoder.encode("admin", StandardCharsets.UTF_8.toString());
			String password = URLEncoder.encode("admin", StandardCharsets.UTF_8.toString());
			String url = "http://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
			driver.get(url);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	String p=driver.findElement(By.xpath("//div[@class='example']/p")).getText();
	Assert.assertEquals(p, "Congratulations! You must have the proper credentials.");
	}
	@Test(priority=7)
	public void test8(){
		driver.findElement(By.xpath("//a[text()='Challenging DOM']")).click();
		List<WebElement> rows= driver.findElements(By.xpath("//tr"));
		int rowno=0;
		for(WebElement row: rows){
				//System.out.println(row.getText());
				//driver.findElement(By.xpath("//tbody/tr/td[7]/a[text()='edit']")).click();
			if(row.getText().contains("Apeirian2")){
				String check=driver.findElement(By.xpath("//tbody/tr["+rowno+"]/td[1]")).getText();
				System.out.println(check);
				Assert.assertEquals(check, "Iuvaret2");						
				driver.findElement(By.xpath("//tbody/tr["+rowno+"]/td[7]/a[text()='edit']")).click();
			}
			rowno+=1;
		}
	}
		@Test(priority=8)
		public void test9(){
			driver.findElement(By.xpath("//a[text()='Context Menu']")).click();
			Actions action = new Actions(driver);
			WebElement ele=driver.findElement(By.id("hot-spot"));
			action.moveToElement(ele).contextClick(ele).perform();
			Alert alert= driver.switchTo().alert();
			alert.accept();
	}
		@Test(priority=9)
		public void test10(){
			driver.findElement(By.xpath("//a[text()='Digest Authentication']")).click();
			try{
				String username=URLEncoder.encode("admin",StandardCharsets.UTF_8.toString());
				String password=URLEncoder.encode("admin",StandardCharsets.UTF_8.toString());
				String url="http://"+username+":"+password+"@the-internet.herokuapp.com/digest_auth";
				driver.get(url);
				String textcheck=driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
				Assert.assertEquals(textcheck, "Digest Auth");
		}
		catch(UnsupportedEncodingException e){
				e.printStackTrace();
			}
		}	
	@Test(priority=17)
	 //Code not working
	public void test18(){
		driver.findElement(By.xpath("//a[text()='Drag and Drop']")).click();
		Actions action = new Actions(driver);
		WebElement source= driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement target= driver.findElement(By.xpath("//div[@id='column-b']"));
		//action.clickAndHold(source).moveToElement(target).release(target).build().perform();
		//action.dragAndDrop(source, target).perform();
		Point SLocation=source.getLocation();
		Point Tlocation=target.getLocation();
		//action.dragAndDropBy(source, SLocation.getX(), Tlocation.getY());
		//action.clickAndHold(source).dragAndDropBy(target,  SLocation.getX(), Tlocation.getY()).release(target).perform();
		action.clickAndHold(source).dragAndDrop(source, target).release(target).perform();
	}
	@Test(priority=10)
	public void test11(){
		driver.findElement(By.xpath("//a[text()='Dynamic Controls']")).click();
		driver.findElement(By.id("checkbox")).click();
		String before=driver.findElement(By.xpath("//button[@type='button']")).getText();
		//System.out.println(before);
		Assert.assertEquals(before, "Remove");
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		try{
			Thread.sleep(5000);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		String after=driver.findElement(By.xpath("//button[@type='button']")).getText();
		//System.out.println(after);
		Assert.assertEquals(after, "Add");
		String text= driver.findElement(By.xpath("//p[@id='message']")).getText();
		Assert.assertEquals(text, "It's gone!");
	}
	@Test(priority=11)
	public void test12(){
		driver.findElement(By.xpath("//a[text()='Entry Ad']")).click();
		try{
			Thread.sleep(1000);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//p[text()='Close']")).click();
		driver.switchTo().defaultContent();
		String text=driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		Assert.assertEquals(text,"Entry Ad");
	}	
	@Test(priority=12)
	public void test13(){
		driver.findElement(By.xpath("//a[text()='File Download']")).click();
		driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
		try{
			Thread.sleep(5000);
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		File file= new File("C:\\Users\\Shya\\Downloads"+"\\some-file.txt");
		if(file.exists()){
			System.out.println("download successful");
		}
		else{
			System.out.println("download is unsuccessful");
		}
		
	}
	@Test(priority=13)
	public void test14(){
		driver.findElement(By.xpath("//a[text()='File Upload']")).click();
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Shya\\Desktop\\xpaths.txt");
		driver.findElement(By.id("file-submit")).click();
		Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "xpaths.txt");
		
	}
	@Test(priority=14)
	public void test15(){
		driver.findElement(By.xpath("//a[text()='JQuery UI Menus']")).click();
		driver.findElement(By.xpath("//a[@id='ui-id-2']")).click();
		driver.findElement(By.xpath("//a[@id='ui-id-5']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='example']/h3")).getText(), "JQuery UI");
		driver.findElement(By.xpath("//a[text()='Menu']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='example']/h3")).getText(), "JQueryUI - Menu");	
	}	
	@Test(priority=18)
	public void test19(){
		driver.findElement(By.xpath("//a[text()='JavaScript Alerts']")).click();
		driver.findElement(By.xpath("//button[@onClick='jsAlert()']")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//button[@onClick='jsConfirm()']")).click();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//button[@onClick='jsPrompt()']")).click();
		driver.switchTo().alert().sendKeys("hello");
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You entered: hello");
		
	}
	@Test(priority=15)
	public void test16(){
		driver.findElement(By.xpath("//a[text()='JavaScript onload event error']")).click();
	String result="This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.";
	String actual=driver.findElement(By.xpath("//p")).getText();
	Assert.assertEquals(actual,result);
	}
	@Test(priority=16)
	public void test17(){
		driver.findElement(By.xpath("//a[text()='Key Presses']")).click();
		driver.findElement(By.id("target")).sendKeys(Keys.TAB);
		String result=driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(result,"You entered: TAB");
	}
}