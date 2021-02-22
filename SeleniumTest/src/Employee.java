import java.util.ArrayList;
import java.util.List;


public class Employee {
private int Employeeid;
private  String EmployeeFName;
private String EmployeeLName;
private String Address;

public Employee(int Employeeid,String EmployeeFName,String EmployeeLName,String Address){
	this.Employeeid=Employeeid;
	this.EmployeeFName=EmployeeFName;
	this.EmployeeLName= EmployeeLName;
	this.Address=Address;
}

public int getEmployeeid()
{
	return Employeeid;
}

public String getEmployeeFName()
{
	return EmployeeFName;
}

public String getEmployeeLName()
{
	return EmployeeLName;
}

public String getAddress()
{
	return Address;
}

public String toString()
{
	//return "[\r\n ID "+this.Employeeid+"\r\n Firstname "+this.EmployeeFName+"\r\n last name "+this.EmployeeLName+"\r\n address "+ this.Address +"]\r\n";
	return this.Employeeid+" "+this.EmployeeFName+" "+this.EmployeeLName+" "+ this.Address ;
}

public List<String> getDataAsString()
{
	ArrayList<String> data = new ArrayList<String>();
	data.add("" + this.Employeeid);
	data.add(this.EmployeeFName);
	data.add(this.EmployeeLName);
	data.add(this.Address);
	
	return data;
	
	
}


}
