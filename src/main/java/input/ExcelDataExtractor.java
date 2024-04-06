package input;

import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataExtractor {
	String schoolName;
	String cityName;
	
	// Method to extract school name from the Excel file
	public static String extractSchoolName() throws IOException {
		// Open the Excel workbook
		Workbook workbook = new XSSFWorkbook("C:\\Users\\2318934\\eclipse-workspace\\miniproject\\src\\main\\java\\input\\xlout.xlsx");
		
		// Get the first sheet
		Sheet sheet = workbook.getSheet("sheet1");
		
		// Get the first row
		Row FirstRow = sheet.getRow(0);
		
		// Get the value of the first cell
		String schoolCategory = FirstRow.getCell(0).toString();
		
		return schoolCategory;
	}
	
	// Method to extract city name from the Excel file
	public static String extractCityName() throws IOException {
		// Open the Excel workbook
		Workbook workbook = new XSSFWorkbook("C:\\Users\\2318934\\eclipse-workspace\\miniproject\\src\\main\\java\\input\\xlout.xlsx");
		
		// Get the first sheet
		Sheet sheet = workbook.getSheet("sheet1");
		
		// Get the first row
		Row FirstRow = sheet.getRow(0);
		
		// Get the value of the second cell
		String cityName = FirstRow.getCell(1).toString();
		
		return cityName;
	}
}

