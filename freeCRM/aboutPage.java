package freeCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class aboutPage extends baseClass{
	
@FindBy(xpath="//a[@href='https://register.freecrm.com/register/']")
WebElement SignUp;
@FindBy(xpath="//h1[text()='Free CRM About Us']")
WebElement headline;
@FindBy(xpath="//a[@href='index.html']")
WebElement backToLoginPage;
@FindBy(xpath="//div[@aria-label='Open Intercom Messenger']")
WebElement openChat;

@FindBy(xpath="//div[@aria-label='Close Intercom Messenger']")
WebElement closeChat;
public aboutPage(WebDriver driver){
	PageFactory.initElements(driver, this);
}

public void toSignupPage(){
	SignUp.click();
}

public String checkHeadline(WebDriver driver){
	driver.switchTo().defaultContent();
	return headline.getText();
}
public void backtoLoginPage(WebDriver driver){
	driver.switchTo().defaultContent();
	backToLoginPage.click();
}

}
