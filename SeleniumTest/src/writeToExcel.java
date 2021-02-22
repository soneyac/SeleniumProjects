import java.io.*;
import java.util.*;

import org.apache.poi.xssf.usermodel.*;

public class writeToExcel {

	public static void main(String[] args)throws IOException {
		String file="C:\\Users\\Shya\\Desktop\\check.xlsx";
		Queue<String[]> list= new LinkedList<String[]>();
		String[] data1= {"Soney9","Chandra10","soney10@gmail.com","1234","10","5","1979","2"};
		String[] data2= {"Soney4","Chandra11","soney11@gmail.com","1235","11","6","1980","3"};
		String[] data3= {"Soney3","Chandra13","soney13@gmail.com","1236","12","7","1981","4"};
		list.add(data1);
		list.add(data2);
		list.add(data3);
		writefile( file,list);
	}
	
	public static void writefile(String file, Queue<String[]> list) throws IOException{
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowCount=0;
		XSSFRow row=sheet.getRow(rowCount);
		XSSFRow newrow;
		XSSFCell cell;
		int newrowsToBeAdded=list.size();
		FileOutputStream fos= new FileOutputStream(file);
		while(newrowsToBeAdded>0){
			String[] array=list.poll();
			rowCount=sheet.getLastRowNum();
			newrow=sheet.createRow(rowCount+1);
			for(int i=0;i<row.getLastCellNum();i++)
			{
				//System.out.println("inside forloop for the row");
				cell=newrow.createCell(i);
				cell.setCellValue( readData(i,array));
				
			}
			newrowsToBeAdded--;
			rowCount++;
		}
		wb.write(fos);	
		fis.close();
		fos.close();
	}
	
	public static String readData(int cellno, String[] array){
			String result="";
			for(int j=0;j<array.length;j++){
				if(cellno==j){
				result=array[cellno];
				break;
				}
			}
		return result;
	}
}
