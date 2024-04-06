package output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class OutputManager {
	String excelData;
	String fileData;
	
	// Method to write data to an Excel file
	public  void writeToExcel(String excelData) {
		this.excelData = excelData;
		
		// Create a new workbook and sheet
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("sheet2");
		
		// Create a new row in the sheet
		Row row = sheet.createRow(0);
		
		// Create a new cell in the row and set its value
		Cell cell = row.createCell(0);
		cell.setCellValue(excelData);
		
		// Write the workbook to a file
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\2318934\\eclipse-workspace\\miniproject\\src\\main\\java\\output\\xlout2.xlsx");
			workbook.write(fileOutputStream);
		} catch(Exception e) {
			// Handle exception
		}
	}
	
	// Method to write data to a text file
	public void writeToFile(String fileData) throws IOException {
		this.fileData = fileData;
		
		// Create a new file
		File file = new File("C:\\Users\\2318934\\eclipse-workspace\\miniproject\\src\\main\\java\\output\\file.txt");
		file.createNewFile();
		
		// Write data to the file
		FileWriter writer = new FileWriter(file);
		writer.write(fileData);
		writer.close();
	}
	
	// Method to take a screenshot
	public void takeScreenshot(WebDriver driver) throws IOException {
		// Take screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// Define destination file
		File dest = new File("C:\\Users\\2318934\\eclipse-workspace\\miniproject\\src\\main\\java\\output\\img.png");
		
		// Copy screenshot to destination file
		FileHandler.copy(src, dest);
	}
}

