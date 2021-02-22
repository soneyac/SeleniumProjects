package com.makeMyTrip;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Main.mainClass;
import PageObjects.facebookFirstPage;
import dataprovider.dataprovider;

public class fbtest extends mainClass{
	@DataProvider
	public Iterator<String[]> getData(){
		dataprovider dp= new dataprovider();
		ArrayList<String[]> al= dp.dataprovide();
		return al.iterator();
	}
/*@Test(dataProvider="getData")
public void ScreenshotScript(String fname, String lname,String email,String passwrd, String bday, String bmonth, String byear, String sx){
	facebookFirstPage fp= new facebookFirstPage(driver);
	fp.register(driver, fname, lname, email, passwrd, bday, bmonth, byear, sx);
}*/
}
