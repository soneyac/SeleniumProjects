package com.makeMyTrip;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Main.mainClass;
import PageObjects.homePage;

public class makeMyTrip extends mainClass{
	
		WebDriver driver;
		@Test (priority=1)
		public void oneway_trip(){
			homePage hp= new homePage(driver);
			hp.bookOnewayTicket(driver,"Goa", "Kochi");
		
	}


}
