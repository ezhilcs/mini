package main;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import Driver.WebDriverSetup;
import input.ExcelDataExtractor;
import output.OutputManager;



public class SchoolSearch {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Setup WebDriver using the Driver class
		WebDriver webDriver = WebDriverSetup.setupWebDriver();

		// Set implicit wait time
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Maximize the browser window
		webDriver.manage().window().maximize();

		// Delete all cookies
		webDriver.manage().deleteAllCookies();

		// Open the website using URL
		webDriver.get("https://www.eduvidya.com/");
		Thread.sleep(3000);

		// Click on the details button with help of the locater using id
		webDriver.findElement(By.id("details-button")).click();
		Thread.sleep(2000);

		// Click on the proceed link with help of the locater using id
		webDriver.findElement(By.id("proceed-link")).click();

		// Click on the menu item with help of the locater using Xpath
		webDriver.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[4]/a")).click();

		// Select the school category 
		WebElement categoryElement = webDriver.findElement(By.id("ddl_Category"));
		Select categorySelect = new Select(categoryElement);
		categorySelect.selectByVisibleText(ExcelDataExtractor.extractSchoolName());

		// Select the city
		WebElement cityElement = webDriver.findElement(By.id("ddl_City"));
		Select citySelect = new Select(cityElement);
		citySelect.selectByVisibleText(ExcelDataExtractor.extractCityName());

		// Click on the search button with help of the locater using id
		webDriver.findElement(By.id("btnSearch")).click();

		// Create an Output object
		OutputManager output = new OutputManager();

		// Take a screenshot of the results that are displayed
		output.takeScreenshot(webDriver);

		// Get the list of search results
		List<WebElement> searchResults = webDriver.findElements(By.xpath("//*[@id=\"pnllist\"]/div[2]"));

		// verify search results had displayed
		if(searchResults.size() > 0) {
			// if search results are displayed then print displayed on output excel
			output.writeToExcel("displayed");
			// if search results are displayed then print displayed on output file 
			output.writeToFile("displayed");
			// if search results are displayed then print displayed on console
			System.out.println("displayed");
		}

		// Close the browser
		webDriver.quit();
	}
}

