import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadFromCSV {
	WebDriver driver;

	enum Properties {
		  USER,
		  USER_NAME,
		  PASSWORD
		}
	
	public void runTest(HashMap data, Integer j){
		driver.get("https://www.freecrm.com/");
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(getproperty(data,j,Properties.USER_NAME));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(getproperty(data,j,Properties.PASSWORD));
		driver.quit();
	}
	public static void main(String[] args) throws Exception {
		
		ReadFromCSV read= new ReadFromCSV();
		HashMap data= Util.readcsv();
		for (int j=0;j<data.size();j++)
		{
		read.callWebdriver();
		read.runTest(data,j);
		}		
		//read.hashmaptests(data);
	}
	public void callWebdriver(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Soney_Chandra\\workspace\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public String getproperty(HashMap data,Integer j, Properties prop){
		
			String[] usercredentials =(String[]) data.get(j);
			if(prop==Properties.USER){
				System.out.println("USER is "+usercredentials[0]);
				return usercredentials[0];
			}
			else if(prop == Properties.USER_NAME)
			{
				System.out.println("USER_NAME is "+usercredentials[1]);
				return usercredentials[1];
			}
			else if(prop == Properties.PASSWORD)
			{
				System.out.println("PASSWORD is "+usercredentials[2]);
				return usercredentials[2];
			}
		return null;
	}
	public void hashmaptests(HashMap data){
		for(Object key:data.keySet()){
			String[] values= (String[])data.get((Integer)key);
			for(String value:values){
				System.out.println(value);
			}
		System.out.println("**********");
		}
		for(Object values1:data.values()){
			for (String value1:(String[]) values1){
				System.out.println(value1);
			}
			System.out.println("$$$$$$$$$");
		}
	}
}
