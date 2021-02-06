package freeCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class loginPage extends baseClass{
	/*String[] CRM={
		"CRM for Any Business",
		"HIPAA CRM" ,
		"Dental CRM",
		"Automotive CRM",
		"Call Center CRM",
		"Insurance CRM",
		"Real Estate CRM",
		"Professional Services CRM",
		"Contractor Builder CRM",
		"Independent Sales CRM"};*/
		
	/*@FindBy(xpath="//a[@href='https://ui.cogmento.com']")
	WebElement loginButton;*/
	@FindBy(how=How.XPATH,using="//a[@href='https://ui.cogmento.com']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[@href='about.html']")
	private WebElement About;
	
	@FindBy(xpath="//a[text()='CRM']")
	private WebElement CRMDropdown;

	@FindBy(xpath="//a[text()='Apps']")
	private WebElement AppsDropdown;
	
	@FindBy(xpath="//a[text()='Compare']")
	private WebElement Compare;
	
	@FindBy(xpath="//a[text()='Pricing']")
	private WebElement Pricing;
	
	@FindBy(xpath="//a[text()='Support']")
	private WebElement Support;
	
	@FindBy(xpath="//img[@alt='iTunes']")
	private WebElement AppStore;
	
	@FindBy(xpath="//img[@alt='Android']")
	private WebElement googlePlayStore;
	
	@FindBy(xpath="//h1[text()='Free CRM']")
	WebElement headlineFreeCRM;
	
	@FindBy(xpath="//div[@aria-label='Open Intercom Messenger']")
	WebElement openChat;
	
	@FindBy(xpath="//div[@aria-label='Close Intercom Messenger']")
	WebElement closeChat;
	
	public loginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoginButton(){
		
		loginButton.click();
	}
	
	public void clickAboutButton(){
		//driver.switchTo().defaultContent();
		About.click();
	}
	public void CRMdropdown(String item){
		Select select= new Select(CRMDropdown);
		select.selectByValue(item);
	}
	public void Appsdropdown(String item){
		Select select= new Select(AppsDropdown);
		select.selectByValue(item);
	}
	public void clickCompare(){
		Compare.click();
	}
	public void clickPricing(){
		Pricing.click();
	}
	public void openAppstore(){
		AppStore.click();
	}
	public void openGooglestore(){
		googlePlayStore.click();
	}
	public void clickSuppot(){
	Support.click();
	}
	public String getHeadline(WebDriver driver){
		driver.switchTo().defaultContent();
		return headlineFreeCRM.getText();
	}
}
