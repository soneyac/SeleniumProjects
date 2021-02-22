package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightsPage extends BaseClass {
	
	//@FindBy (xpath="//div[@aria-label='close']")
	//@FindBy (xpath="//div[@class='n00je7tq arfg74bv qs9ysxi8 k77z8yql i09qtzwb n7fi1qx3 b5wmifdl hzruof5a pmk7jnqg j9ispegn kr520xx4 c5ndavph art1omkt ot9fgl3s rnr61an3']")
	//@FindBy (xpath="//*[@id='u_0_0']/div/div/div/div/div/div[1]/div[4]/div[2]")
	@FindBy (xpath="//*[@id='logo']")
	private WebElement HideButton;
	@FindBy (xpath="//a[text()='International Holidays ']")
	private WebElement InternationalFlightButton;
	@FindBy (xpath="//a[text()='Indian Holidays ']")
	private WebElement IndiaFlightButton;
	@FindBy (xpath="//button[@class='close' and @aria-label='Close']")
	private WebElement CloseButton;
	@FindBy (xpath="//input[@value='R']")
	private WebElement RoundRadioButton;
	@FindBy (xpath="//input[@value='S']")
	private WebElement OneWayRadioButton;
	@FindBy (xpath="//input[@name='fromCity']")
	private WebElement FromCity;
	@FindBy (xpath="//input[@name='toCity']")
	private WebElement ToCity;
	@FindBy (xpath="//input[@name='departDate']")
	private WebElement DepartDate;
	@FindBy (xpath="//input[@name='returnDate']")
	private WebElement ReturnDate;
	@FindBy (xpath="//select[@id='Adults']")
	private WebElement Adults;
	@FindBy (xpath="//select[@name='Childs']")
	private WebElement Childs;
	@FindBy (xpath="//select[@id='Infants']")
	private WebElement Infants;
	@FindBy (xpath="//select[@name='cabinClass' ]/option")
	private WebElement ClassOfTravel;
	@FindBy (xpath="//button[@id='searchFlightsBtn']")
	private WebElement SearchFlightsButton;
	
	public FlightsPage(){
		PageFactory.initElements(driver, this);
	}
	public void minimizePopup(){
		if(HideButton.isDisplayed()){
		HideButton.click();
		}
		else{
			System.out.println("Button is not enabled");
		}
	}
	public void selectInternationalFlight(){
		InternationalFlightButton.clear();
	}
	public void selectIndianFlight(){
		IndiaFlightButton.clear();
	}
	public void closeFlightPopup(){
		CloseButton.click();
	}
	public void bookOnewayFlight(String fromCity, String toCity, String date, String user){
		OneWayRadioButton.click();
		FromCity.sendKeys(fromCity);//"BLR"
		ToCity.sendKeys(toCity);//"CCJ"
		DepartDate.sendKeys(date);
		Select selectAdults= new Select(Adults);
		selectAdults.deselectByVisibleText(user);
		SearchFlightsButton.click();
	}
}
