package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import testCases.LoginTest;

public class AddUserObjects {
	
	@FindBy(id="menu_admin_viewAdminModule")
	public static WebElement AdminBtn;
	
	@FindBy(id="btnAdd")
	public static WebElement AddBtn;

	@FindBy(id="systemUser_userType")
	public static WebElement UserRole;
	
	@FindBy(id="systemUser_employeeName_empName")
	public static WebElement EmployeeName;
	
	@FindBy(id="systemUser_userName")
	public static WebElement UserName;
	
	@FindBy(id="systemUser_status")
	public static WebElement Status;
	
	@FindBy(id="systemUser_password")
	public static WebElement Password;
	
	@FindBy(id="systemUser_confirmPassword")
	public static WebElement ConfPassword;
	
	@FindBy(id="btnSave")
	public static WebElement SaveBtn;
	
	
}
