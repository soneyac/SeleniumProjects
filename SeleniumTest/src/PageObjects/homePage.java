package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class homePage {
	@FindBy (id="hp-widget__sfrom")
	private WebElement fromPlace;
	
	@FindBy (id="hp-widget__sTo")
	private WebElement toPlace;
	
	@FindBy (id="hp-widget__depart")
	private WebElement departDate;
	
	@FindBy (id="hp-widget__return")
	private WebElement returnDate;
	
	@FindBy (id="hp-widget__paxCounter")
	private WebElement passengers;
	
	@FindBy (id="hp-widget__class")
	private WebElement classType;
	
	@FindBy (id="searchBtn")
	private WebElement searchButton;
	
	@FindBy (xpath="//*[@id='js-switch__option']/div[1]")
	private WebElement oneway;
	
	@FindBy (xpath="//*[@id='js-switch__option']/div[2]")
	private WebElement roundTrip;
	
	@FindBy (xpath="//*[@id='js-switch__option']/div[1]")
	private WebElement multiCity;
	
	public homePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void bookOnewayTicket(WebDriver driver, String from_p, String to_p){
		oneway.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		fromPlace.clear();
		fromPlace.sendKeys(from_p);
		toPlace.clear();
		toPlace.sendKeys(to_p);
		//departDate.sendKeys(date);
		//passengers.sendKeys(pass_no);
		//classType.
		searchButton.click();
	}

}
