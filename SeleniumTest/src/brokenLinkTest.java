import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class brokenLinkTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		/*System.setProperty("webdriver.geko.driver", "C:\\Users\\Soney_Chandra\\workspace\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();*/
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Soney_Chandra\\workspace\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		/*Dimension d= new Dimension(300,500);
		driver.manage().window().setSize(d);*/
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println("No of links is "+links.size());
		ArrayList<WebElement> activelinks = new ArrayList<WebElement>();
		ArrayList<WebElement> jslinks = new ArrayList<WebElement>();
		ArrayList<WebElement> nulllinks = new ArrayList<WebElement>();
		//get active links
		for(int i=0;i<links.size();i++){
			if(links.get(i).getAttribute("href")!=null && !(links.get(i).getAttribute("href").contains("javascript")) ){
				activelinks.add(links.get(i));
			}
			else if(links.get(i).getAttribute("href")!=null && links.get(i).getAttribute("href").contains("javascript")){
				jslinks.add(links.get(i));
				
			}
			else if(links.get(i).getAttribute("href")== null){
				nulllinks.add(links.get(i));	
			}
				
			}
		System.out.println("No of active links is " +activelinks.size());
		System.out.println("No of javascript links is "+jslinks.size());
		System.out.println("No of active links is " +nulllinks.size());
		//checking for the active links
		for(int j=0; j<activelinks.size();j++){
			HttpURLConnection connection= (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response =connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href")+ " response is "+response );
		}*/
		List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println("Total no of links is " +links.size());
		LinkedList<WebElement> activelinks= new LinkedList<WebElement>();
		/*for(int i=0; i<links.size();i++){
			if( links.get(i).getAttribute("href")!=null )
				activelinks.add(links.get(i));
		}*/
		for(WebElement link: links){
			if(link.getAttribute("href")!=null)
				activelinks.add(link);
		}
		System.out.println("No of active links is " +activelinks.size());
		/*for (int j=0; j<activelinks.size();j++)
		{
			HttpURLConnection connection= (HttpURLConnection) new URL( activelinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			int response =connection.getResponseCode();
			connection.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href")+" response code is "+response);
		}*/
		int responsecode=0;
		int WorkingLinkCount=0;
		int NonworkingLinkCount=0;
		int JSlinks=0;
		for (WebElement active: activelinks){
			if(active.getAttribute("href").startsWith("javascript")||active.getAttribute("href").startsWith("mailto")){
			JSlinks=JSlinks+1;
			}
			else{
			//HttpURLConnection connect= (HttpURLConnection) new URL(active.getAttribute("href")).openConnection();
			HttpURLConnection connect= (HttpURLConnection) new URL(active.getAttribute("href")).openConnection();				connect.connect();
			responsecode=connect.getResponseCode();
			connect.disconnect();
			
			}
			if(responsecode==200){
				WorkingLinkCount=WorkingLinkCount+1;
			}
			else{
				NonworkingLinkCount=NonworkingLinkCount+1;
			}
			//System.out.println("HREF is "+active.getAttribute("href"));
		}
System.out.println("Total working links are "+WorkingLinkCount);
System.out.println("Total broken links are "+NonworkingLinkCount);
System.out.println("Total javascripts and Mailto links are "+JSlinks);
driver.close();
	}

}
