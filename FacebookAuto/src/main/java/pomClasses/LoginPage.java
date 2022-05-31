package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath="//input[@name='email']")
	private WebElement userName;
	
	@FindBy (xpath="//input[@name='pass']")
	private WebElement password;
	
	@FindBy (xpath="//button[text()='Log In']")
	private WebElement login;
	
	@FindBy (xpath="//a[text()='Create New Account']")
	private WebElement createNewAccount;
	
	@FindBy (xpath="//a[text()='Forgotten password?']")
	private WebElement forgottenPassword;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication()
	{
		userName.sendKeys("kalyaneesmelkunde@gmail.com");
		password.sendKeys("Bshankar@143");
		//login.click();
	}
	public void clickOnCreateNewAccount()
	{
		createNewAccount.click();
	}
	public void clickForgottenPassword()
	{
		forgottenPassword.click();
	}

}
