import java.io.*;
import org.apache.poi.xssf.usermodel.*;
import java.util.*;



public class ReadExcel {

	public static void main(String[] args)throws IOException{
		String file="C:\\Users\\Soney_Chandra\\workspace\\SeleniumTest\\src\\util\\Book1.xlsx";
		List<String> cellvalue=	read(file);
		System.out.println(cellvalue.toString());
			}
			
			public static List<String> read(String file) throws IOException{
				FileInputStream fis= new FileInputStream(file);
				XSSFWorkbook wb= new XSSFWorkbook(fis);
				XSSFSheet ws= wb.getSheetAt(0);
				int rowCount=ws.getLastRowNum();
				int firstRow=ws.getFirstRowNum();
				List<String> cellvalue=new ArrayList<String>();
				
				XSSFRow row;
				XSSFCell cell;
				for(int i=firstRow+1;i<rowCount;i++)
				{
					row=ws.getRow(i);
					int firstCol=row.getFirstCellNum();
					int colCount=row.getLastCellNum();
					for(int j=firstCol;j<colCount;j++)
					{
						cell=row.getCell(j);
						cellvalue.add(cell.getStringCellValue());
					}
				}
				return cellvalue;
			}

}
