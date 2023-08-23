package utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

    static XSSFSheet sheet;
	
	public static String [][] getExcelData() {
	  
		try 
		{
		FileInputStream file = new FileInputStream("D:\\Data Excel sheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
	    sheet = workbook.getSheet("Sheet1");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		int row = sheet.getLastRowNum();
	//	System.out.println("Rows are : " + row);
		
		int column = sheet.getRow(0).getLastCellNum();
	//	System.out.println("Columns are : " + column);
		
		String data [][] = new String [row][column];    // to retrieve data from table, create array of string.
		
		for(int i=0 ; i<row ; i++) 
		{ 
			for(int j=0 ; j<column ; j++) 
			{
			//	String data = sheet.getRow(i).getCell(j).toString();
			//	System.out.print(data + "   ");
				
				data [i][j] = sheet.getRow(i+1).getCell(j).toString();					
			}
			
		}
	
		return data;
		
	}		
}
