package testCases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;

import junit.framework.Assert;
import pageObjects.LoginPageObject;

public class LoginTest {

	public static WebDriver driver;
	public static ExtentReports extentReport;
	ExtentHtmlReporter htmlReporter;
	public static ExtentTest testcase;

	/*
	 * static List<String> userNameList = new ArrayList<String>(); static
	 * List<String> passwordList = new ArrayList<String>();
	 * 
	 * @Test(dependsOnMethods = "login") public void loginDataFromExcell()
	 * throws IOException {
	 * 
	 * FileInputStream excel = new
	 * FileInputStream("./src/test/java/dataSheet/dataSheet.xlsx"); Workbook
	 * workbook = new XSSFWorkbook(excel); Sheet sheet = workbook.getSheetAt(1);
	 * 
	 * Iterator<Row> rowIterator = sheet.iterator(); while
	 * (rowIterator.hasNext()) { Row rowValue = rowIterator.next();
	 * rowValue.iterator();
	 * 
	 * Iterator<Cell> columnIterator = rowValue.iterator(); int i = 2; while
	 * (columnIterator.hasNext()) { if (i % 2 == 0) {
	 * userNameList.add(columnIterator.next().getStringCellValue()); } else {
	 * passwordList.add(columnIterator.next().getStringCellValue()); } i++; } }
	 * }
	 */
	/*
	 * String[][] data = { { "Admin", "admin123" }, { "Admin", "admin" }, {
	 * "admin", "admin123" }, { "admin", "Admin123" } };
	 * 
	 * @DataProvider(name = "loginData") public String[][] login() {
	 * 
	 * return data; }
	 */

	@BeforeSuite

	public void launchApp() {

		System.setProperty("webdriver.chrome.driver", "./src/test/java/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		extentReport = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("ExtentReporter.html");
		extentReport.attachReporter(htmlReporter);
		testcase = extentReport.createTest("Verify launch application");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	// @Test(dataProvider = "loginData")

	@Test
	@Parameters({ "UserName", "Password" })
	public void login(String uName, String pWord) throws IOException {

		PageFactory.initElements(driver, LoginPageObject.class);

		LoginPageObject.userName.sendKeys(uName);

		testcase.log(Status.INFO, "Username Entered");

		LoginPageObject.password.sendKeys(pWord);

		testcase.log(Status.INFO, "Password Entered");

		LoginPageObject.loginBtn.click();

		testcase.log(Status.INFO, "Click Button Clicked");

		String dashBoardUrl = driver.getCurrentUrl();

		Assert.assertEquals(dashBoardUrl, "No Title");

		testcase.log(Status.PASS, "Application Launched");

		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File("Sample.png");
		FileHandler.copy(source, dest);
		testcase.addScreenCaptureFromPath("Sample.png");

		testcase.log(Status.FAIL, "Application Not Launched");

	}

	@AfterSuite
	public void quitBrowser() {
		driver.quit();
		extentReport.flush();
	}
}
