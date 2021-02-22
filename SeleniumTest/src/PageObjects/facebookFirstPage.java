package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class facebookFirstPage {
	
	@FindBy (xpath="//*[@name='firstname']")
	private WebElement firstname;
	
	@FindBy (xpath="//*[@name='lastname']")
	private WebElement lasttname;
	
	@FindBy (xpath="//*[@name='reg_email__']")
	private WebElement mail;
	
	@FindBy (xpath="//*[@name='reg_email_confirmation__']")
	private WebElement remail;
	
	@FindBy (xpath="//*[@name='reg_passwd__']")
	private WebElement passwd;
	
	@FindBy (xpath="//*[@name='birthday_day']")
	private WebElement bday;
	
	@FindBy (xpath="//*[@name='birthday_month']")
	private WebElement bmonth;
	
	@FindBy (xpath="//*[@name='birthday_year']")
	private WebElement byear;
	
	@FindBy (xpath="//*[@name='sex']")
	private WebElement sex;
	
	//WebDriver driver;
	
	public facebookFirstPage(WebDriver driver){

		PageFactory.initElements(driver,this);
	}
	
	
	public void register(WebDriver driver,String fname, String lname,String email,String password, String btday, String btmonth, String btyear, String sx)
	{
		firstname.clear();
		firstname.sendKeys(fname);
		lasttname.clear();
		lasttname.sendKeys(lname);
		mail.clear();
		mail.sendKeys(email);
		remail.clear();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		remail.sendKeys(email);
		passwd.clear();
		passwd.sendKeys(password);
		Select select1= new Select(bday);
		select1.selectByValue(btday);
		Select select2= new Select(bmonth);
		select2.selectByValue(btmonth);
		Select select3= new Select(byear);
		select3.selectByValue(btyear);
		sex.click();
	}
		
	}
