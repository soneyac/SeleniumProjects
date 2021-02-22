package com.makeMyTrip;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataprovider.dataprovider;
import Main.mainClass;
import PageObjects.facebookFirstPage;

import org.openqa.selenium.OutputType;
public class test extends mainClass{
	@DataProvider
	public Iterator<String[]> GetData(){
		dataprovider dp= new dataprovider();
		ArrayList <String[]> al= dp.dataprovide();
		return al.iterator();
	}
	@Test(dataProvider="GetData")
	public void test(String fname, String lname,String email,String passwrd, String bday, String bmonth, String byear, String sx){
		facebookFirstPage fp= new facebookFirstPage(driver);
		fp.register(driver, fname, lname, email, passwrd, bday, bmonth, byear, sx);
		File file= (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(file, new File("C:\\Users\\Shya\\Desktop\\Screenshots\\facebook.png"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	}