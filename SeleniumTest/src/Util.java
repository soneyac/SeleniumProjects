import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;



public class Util {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static HashMap readcsv() throws Exception{
		String line = "";  
		String splitBy = ","; 
		HashMap<Integer,String[]> credentials= new HashMap<Integer,String[]>();
		int i=0;
		try   
		{  
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Shya\\Desktop\\SeleniumTestData.csv"));  
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		String[] role = line.split(splitBy);    // use comma as separator 
		credentials.put(i, role);
		System.out.println("Key is "+i+" [roles=" + role[0] + ", UserName=" + role[1] + ", Password=" + role[2] +"]");  
		i+=1;
		}  
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();  
		} 
		return credentials;	
	}
	

}
