package marathon_03;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadXLdata {
   
	public static String[][] ReadXL(String Sheet) throws IOException {
		XSSFWorkbook xl=new XSSFWorkbook("./data/Marathon_xl_001.xlsx");
		//XSSFSheet sheet = xl.getSheetAt(0);
		XSSFSheet sheet = xl.getSheet(Sheet);
		int totalRow = sheet.getLastRowNum();
        int totalcell = sheet.getRow(0).getLastCellNum();
        String[][] data= new String[totalRow][totalcell];
        for (int i = 1; i <= totalRow; i++) {
        	XSSFRow row = sheet.getRow(i);
        	
        	for (int j = 0; j < totalcell; j++) {
				String Value = row.getCell(j).getStringCellValue();
				System.out.println(Value);
				
				data[i-1][j]= Value;
			}
			
		}
        
        xl.close();
        return data;
	}
   

}
