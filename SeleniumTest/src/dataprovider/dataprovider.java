package dataprovider;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;

import util.Xls_Reader;

public class dataprovider {
	
	/*Xls_Reader xlsr= new Xls_Reader("C:\\Users\\Soney_Chandra\\workspace\\SeleniumTest\\src\\util\\Book1.xlsx");
	ArrayList<String[]> getDataSheet= new ArrayList<String[]>();
	public ArrayList getData(){
		for(int i=2; (i<= xlsr.getRowCount("facebook")); i++)
		{
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
		String[] obj={fname, lname, email, password, bday, bmonth, byear, sx};
		getDataSheet.add(obj);
	}
		return getDataSheet;
	}*/
	
	Xls_Reader xls= new Xls_Reader("C:\\Users\\Soney_Chandra\\workspace\\SeleniumTest\\src\\util\\Book1.xlsx");
	ArrayList ar= new ArrayList();
	public ArrayList dataprovide(){
		for(int i=2; i<=xls.getRowCount("facebook");i++){
			String fname= xls.getCellData("facebook", "firstname", i);
			String lname= xls.getCellData("facebook", "lastname", i);
			String emal= xls.getCellData("facebook", "email", i);
			String passwrd= xls.getCellData("facebook", "password", i);
			String bday= xls.getCellData("facebook", "bday", i);
			String bmonth= xls.getCellData("facebook", "bmonth", i);
			String byear= xls.getCellData("facebook", "byear", i);
			String sx= xls.getCellData("facebook", "sex", i);
			String[] Str={fname, lname, emal, passwrd, bday, bmonth, byear, sx};
			ar.add(Str);
		}
		return ar;
	}
	
}
