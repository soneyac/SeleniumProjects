package POM;

import junit.framework.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestScripts extends BaseClass{
	FlightsPage fp;
	@BeforeTest
	public void setUp(){
		initialization();
		fp=new FlightsPage();
	}
	@AfterTest
	public void tearDown(){
		//driver.quit();
	}
	@Test
	public void OneWayFlightBooking(){
		try{
		Thread.sleep(5000);	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		fp.minimizePopup();
		fp.closeFlightPopup();
		fp.bookOnewayFlight("CCJ", "BLR", "10/10/2022", "3");
	}
}
