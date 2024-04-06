package Driver;

import java.util.Scanner; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverSetup {
	// Declare WebDriver as static to use it across all instances of this class
	static WebDriver webDriver;

	// Method to set up the WebDriver based on user's browser choice
	public static WebDriver setupWebDriver() {
		// Create a Scanner object to get user input
		Scanner scanner = new Scanner(System.in);

		// Infinite loop until a valid browser name is entered
		while(true) {
			// Prompt the user to enter the browser name
			System.out.println("Enter the Browser name: ");
			String browserName = scanner.next();

			// Check if the entered browser name is "Chrome"
			if(browserName.equalsIgnoreCase("Chrome")) {
				// Initialize the WebDriver to ChromeDriver
				webDriver = new ChromeDriver();
				return webDriver;
			}
			// Check if the entered browser name is "Edge"
			else if(browserName.equalsIgnoreCase("Edge")){
				// Initialize the WebDriver to EdgeDriver
				webDriver = new EdgeDriver();
				return webDriver;
			}
			else {
				// If an invalid browser name is entered, show an error message
				System.out.println("Invalid Browser");
			}
		}
	}
}
