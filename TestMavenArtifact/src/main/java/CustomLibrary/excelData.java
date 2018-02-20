package CustomLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;

import javax.imageio.stream.FileImageInputStream;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class excelData {

	WebDriver driver;
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public excelData(String excelPath)
	{
		File src= new File(excelPath);
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public String getExcelData(int sheetNo, int row, int col)
	{
		sheet1= wb.getSheetAt(sheetNo);
		
		String data= sheet1.getRow(row).getCell(col).getStringCellValue();
				
		return data;
	}
	
	public int getLastRow(int sheetNo)
	{
		sheet1= wb.getSheetAt(sheetNo);
		int rows=sheet1.getLastRowNum();
		
		return rows;
		
	}
	
	
}
