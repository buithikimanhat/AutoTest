package go.test.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath = "//input[@id='login']")
	public static WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='Password']")
	public static WebElement txtPass;
	 
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement btnLogin;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement btnLogin1;
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement btnLogin2;
	 
	
}
