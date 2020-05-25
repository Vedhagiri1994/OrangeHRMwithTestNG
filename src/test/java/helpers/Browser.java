package helpers;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	
	public static WebDriver driver= null;
	
	public static void browser() throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		 
		System.out.println("Enter Browser Name:");
		String browser=sc.nextLine();
		
		if(browser.equals("Firefox")){
			 System.setProperty("webdriver.gecko.driver","./src/test/java/drivers/geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		else if (browser.equals("Chrome")){
			 System.setProperty("webdriver.chrome.driver","./src/test/java/drivers/chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		else if (browser.equals("IE")){
			 System.setProperty("webdriver.ie.driver","./src/test/java/drivers/IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
		}
		else{
			System.out.println("Invalid Browser");
		}
		
		Thread.sleep(5000);
		driver.close();
	}

}
