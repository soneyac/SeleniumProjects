import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.List;

import com.itextpdf.text.*;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.*;

import org.apache.commons.io.output.ProxyWriter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;


public class getDataFromjdbc {
	static String file= "C:\\Users\\Shya\\Desktop\\newExcel.xlsx";
	static XSSFWorkbook wb= new XSSFWorkbook();
	static String sheetname="employee";
	static XSSFSheet sheet= wb.createSheet(sheetname);
	static XSSFRow row;
	public static void main(String[] args) throws IOException,  DocumentException {
		String username="postgres";
		String password="admin";
		String url="jdbc:postgresql://localhost/postgres";
		List<Employee> emp= new LinkedList<Employee>();
		int rowNo=0;
		
		
		
		try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found " + ex);
        } catch (InstantiationException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		try {
			Connection connection=DriverManager.getConnection(url, username, password);
			
			Statement stmt = connection.createStatement();
			
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            //System.out.println("id  name");

            while (rs.next()) {
               /* int id = rs.getInt("EmployeeID");
                String name = rs.getString("EmployeeFName");
                //System.out.println(id + "   " + name);*/
            	Employee e= new Employee(rs.getInt("Employeeid"),
            			rs.getString("EmployeeFName"), 
            			rs.getString("EmployeeLName"),
            			rs.getString("Address"));
            	System.out.println(e);
            	System.out.println("@@@@"+rowNo);
            	writeExcel(e,rowNo);
            	rowNo++;
            	emp.add(e);
            }
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<List<String>> employeeData = new ArrayList<List<String>>();
		for(Employee each: emp){
      	  //System.out.println(each.getDataAsString());
      	  employeeData.add(each.getDataAsString());
        }
		
		//System.out.println(employeeData);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File(file));
			wb.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Making pdf report");
		makePDF();
	}
	public static void writeExcel(Employee emp,int rowNo) throws IOException{
		int columnNo=0;
		row=sheet.createRow(rowNo);
		XSSFCell cell;
		Object[] objects= {emp.getEmployeeid(),emp.getEmployeeFName(),emp.getEmployeeLName(),emp.getAddress()};
		for(Object obj:objects){
			cell=row.createCell(columnNo++);
			cell.setCellValue(String.valueOf(obj));
		}
		
	}
	public static void makePDF() throws FileNotFoundException, IOException, DocumentException{
		
			FileInputStream fis= new FileInputStream(file);
			wb= new XSSFWorkbook(fis);
			sheet=wb.getSheet(sheetname);
			Iterator<Row> rowIterator=sheet.iterator();
			com.itextpdf.text.Document doc= new com.itextpdf.text.Document();
			PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\Shya\\Desktop\\newPDF.pdf") );
			doc.open();
			PdfPTable table= new PdfPTable(4);
			PdfPCell tablecell;
			while (rowIterator.hasNext()){
				Row row1=rowIterator.next();
				Iterator<Cell> cellIterator= row1.cellIterator();
				while(cellIterator.hasNext()){
					tablecell=new PdfPCell ();
					Cell cell1= cellIterator.next();
						//table.addCell(tablecell);
						switch(cell1.getCellType()) {
						case Cell.CELL_TYPE_STRING:
                         tablecell=new PdfPCell(new Phrase(cell1.getStringCellValue()));
                         table.addCell(tablecell);
                        break;
						}
						
					}
				}
			doc.add(table);
			doc.close();
			fis.close();
			}
			
		
		
		
}


