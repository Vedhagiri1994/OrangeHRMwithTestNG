package testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.AddUserObjects;
import testCases.LoginTest;

public class AddUser extends LoginTest{

	/*
	 * @Test(priority=1) public void addUser() throws InterruptedException{
	 * 
	 * Thread.sleep(3000); driver.findElement(By.linkText("Admin")).click();
	 * driver.findElement(By.id("btnAdd")).click();
	 * 
	 * WebElement userRole = driver.findElement(By.id("systemUser_userType"));
	 * Select s = new Select(userRole); s.selectByIndex(0);
	 * 
	 * driver.findElement(By.id("systemUser_employeeName_empName")).
	 * sendKeys("Linda Anderson");
	 * driver.findElement(By.id("systemUser_userName")).sendKeys("Sathish Kumar"
	 * );
	 * driver.findElement(By.id("systemUser_password")).sendKeys("1234*Giri");
	 * driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(
	 * "1234*Giri"); driver.findElement(By.id("btnSave")).submit(); }
	 */

	@Test
	@Parameters({ "empName", "userName", "passWord", "confPWD" })
	public void addEmp(String empName, String userName, String passWord, String confPWD) throws IOException {

		PageFactory.initElements(driver, AddUserObjects.class);

		testcase = LoginTest.extentReport.createTest("Verify Add User");

		AddUserObjects.AdminBtn.click();

		testcase.log(Status.INFO, "Admin Button Clicked");

		AddUserObjects.AddBtn.click();

		testcase.log(Status.INFO, "Add Button Clicked");

		Select s = new Select(AddUserObjects.UserRole);
		s.selectByIndex(0);

		testcase.log(Status.INFO, "User Role Admin Selected");

		AddUserObjects.EmployeeName.sendKeys(empName);

		testcase.log(Status.INFO, "Employee Name Entered");

		AddUserObjects.UserName.sendKeys(userName);

		testcase.log(Status.INFO, "Employee Username entered ");

		Select s1 = new Select(AddUserObjects.Status);
		s1.selectByIndex(0);

		testcase.log(Status.INFO, "Employee Status Updated");

		AddUserObjects.Password.sendKeys(passWord);

		testcase.log(Status.INFO, "Employee Password Entered");

		AddUserObjects.ConfPassword.sendKeys(confPWD);

		testcase.log(Status.INFO, "Employee Conformation password Entered");

		AddUserObjects.SaveBtn.click();

		testcase.log(Status.INFO, "Save Button Clicked");

		testcase.log(Status.PASS, "New User Added Successfully");


	}

}
