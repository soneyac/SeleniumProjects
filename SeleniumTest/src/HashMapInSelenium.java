import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HashMapInSelenium {
	private HashMap<String,String> userDetails;
	private WebDriver driver;
	
	enum Prop {
		  USER_NAME,
		  PASSWORD
		}
	
	public static void main(String[] args) {
		
		HashMapInSelenium hmp = new HashMapInSelenium();
		hmp.runTest();
		
	}
	
	public void runTest()
	{
		driver.get("https://www.freecrm.com/");
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(getProperty(Prop.USER_NAME, "delivery"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(getProperty(Prop.PASSWORD,"delivery"));
		
		
		
		//driver.close();
	}
	
	public HashMapInSelenium ()
	{
		userDetails= new HashMap<String,String>();
		userDetails.put("Admin", "soney:kl11h414");
		userDetails.put("normal", "mary:kl11h414");
		userDetails.put("delivery", "kate:kl11h414");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Soney_Chandra\\workspace\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
public static String credentials(String role){
	//System.out.println("Inside credentials function");
	HashMap<String,String> hm= new HashMap<String,String>();
	hm.put("Admin", "soney:kl11h414");
	hm.put("normal", "mary:kl11h414");
	hm.put("delivery", "kate:kl11h414");
	//System.out.println(hm.get(role));
	return hm.get(role);
}

public String getProperty(Prop prop,String Role)
{
	String role = userDetails.get(Role);
	
	if(prop == Prop.USER_NAME)
	{
		return role.split(":")[0];
	}
	else if(prop == Prop.PASSWORD)
	{
		return role.split(":")[1];
	}
	
	return null;
}

public static String UserName(String role){
	//System.out.println("Inside username function");
	String username= credentials(role).split(":")[0];
	//System.out.println(username);
	return username;
}
public static String Password(String role){
	//System.out.println("Inside password function");
	String password= credentials(role).split(":")[1];
	//System.out.println(password);
	return password;
}
}
