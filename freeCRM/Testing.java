package freeCRM;

import junit.framework.Assert;




import org.testng.annotations.*;

public class Testing extends baseClass{
	loginPage lp;
	aboutPage ap;

	@BeforeMethod
	  public void setup() {
	  initialize();
	  lp= new loginPage(driver);
	  ap= new aboutPage(driver);
	  }
		
	@AfterMethod
	public void tearDown(){
		deinitialize();
	}

	
	@Test(priority=0)
	public void login(){
		lp.clickLoginButton();
		Assert.assertEquals("Cogmento CRM", driver.getTitle());
	}
	@Test(priority=1)
	public void aboutScreen(){
		lp.clickAboutButton();
		threadSleep(2000);
		Assert.assertEquals(ap.checkHeadline(driver), "Free CRM About Us");
	}
	@Test(priority=2)
	public void backToLoginScreen(){
		lp.clickAboutButton();
		threadSleep(2000);
		ap.backtoLoginPage(driver);
		Assert.assertEquals(lp.getHeadline(driver), "Free CRM");
	}
	

}
