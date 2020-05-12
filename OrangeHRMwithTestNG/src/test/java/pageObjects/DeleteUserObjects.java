package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteUserObjects {
	
	@FindBy(name="chkSelectAll")
	public static WebElement ChooseUser;
	
	@FindBy(id="btnDelete")
	public static WebElement DelBtn;
	
	@FindBy(id="dialogDeleteBtn")
	public static WebElement dialogDelBtn;

}
