import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class test3 {
	public static void main(String args[]){
	int[] array= new int[4];
	array[0]=1;
	array[1]=5;
	array[2]=10;
	array[3]=15;
	for(int i=0;i<array.length;i++){
		System.out.println(array[i]);
	}
	
	String multiarr[][]= new String[4][6];
	System.out.println("rowsize= "+multiarr.length);
	System.out.println("Columnsize= "+multiarr[0].length);
	}
}
