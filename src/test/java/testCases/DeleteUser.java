package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.AddUserObjects;
import pageObjects.DeleteUserObjects;
import testCases.LoginTest;

public class DeleteUser extends LoginTest{

	@Test
	public void deleteUser()  {
		
		//LoginTest.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		testcase= LoginTest.extentReport.createTest("Verify Delete User");

		PageFactory.initElements(driver, AddUserObjects.class);
		
		AddUserObjects.AdminBtn.click();
		
		testcase.log(Status.INFO,"Admin Button Clicked");
		
		PageFactory.initElements(driver, DeleteUserObjects.class);
		
		
		DeleteUserObjects.ChooseUser.click();
		
		testcase.log(Status.INFO,"User will be Selected");
		
		DeleteUserObjects.DelBtn.click();
		
		testcase.log(Status.INFO,"Delete Button Clicked");
		
		DeleteUserObjects.dialogDelBtn.click();
		
		testcase.log(Status.PASS,"User Deleted Successfully");
		
		
	}
}