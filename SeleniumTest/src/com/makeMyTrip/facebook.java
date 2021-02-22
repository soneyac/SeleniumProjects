package com.makeMyTrip;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Main.mainClass;
import PageObjects.facebookFirstPage;
import util.Xls_Reader;
import dataprovider.dataprovider;
public class facebook extends mainClass {
	
	Xls_Reader xlsr= new Xls_Reader("C:\\Users\\Soney_Chandra\\workspace\\SeleniumTest\\src\\util\\Book1.xlsx");
	@DataProvider
/*	public Iterator<String[]> getdatap() {
		dataprovider dp= new dataprovider();
		ArrayList<String[]> getDataString= dp.getData();
			return getDataString.iterator();
		}
	@Test(priority=1, dataProvider="getdatap")
	public void register(){
		facebookFirstPage fp= new facebookFirstPage(driver);
		for(int i=2;i<=xlsr.getRowCount("facebook");i++){
			String fname=xlsr.getCellData("facebook", "firstname", i);
			System.out.println(fname);
			String lname=xlsr.getCellData("facebook", "lastname", i);
			System.out.println(lname);
			String email=xlsr.getCellData("facebook", "email", i);
			System.out.println(email);
			String password=xlsr.getCellData("facebook", "password", i);
			System.out.println(password);
			String bday=xlsr.getCellData("facebook", "bday", i);
			System.out.println(bday);
			String bmonth=xlsr.getCellData("facebook", "bmonth", i);
			System.out.println(bmonth);
			String byear=xlsr.getCellData("facebook", "byear", i);
			System.out.println(byear);
			String sx=xlsr.getCellData("facebook", "sex", i);
			System.out.println(sx);
			fp.register(driver,fname, lname, email, password, bday, bmonth, byear, sx);
		}
		*/
	public void register(String fname, String lname,String email,String password, String btday, String btmonth, String btyear, String sx)
	{
		facebookFirstPage fp= new facebookFirstPage(driver);
		fp.register(driver, fname, lname, email, password, btday, btmonth, btyear, sx);
	}

}
