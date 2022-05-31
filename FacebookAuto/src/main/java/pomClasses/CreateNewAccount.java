package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAccount {

	@FindBy (xpath="//input[@name='firstname']")
	private WebElement FirstName;
	
	@FindBy (xpath="//input[@name='lastname']")
	private WebElement Surname;
	
	@FindBy (xpath="//input[@aria-label='Mobile number or email address']")
	private WebElement MobileEmail;
	
	@FindBy (xpath="//input[@aria-label='Re-enter email address']")
	private WebElement ReEnterMobileEmail;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement NewPassword;
	
	@FindBy (xpath="//select[@id='day']")
	private WebElement DOBDate;
	
	@FindBy (xpath="//select[@id='month']")
	private WebElement DOBMon;
	
	@FindBy (xpath="//select[@id='year']")
	private WebElement DOBYear;
	
	@FindBy (xpath="//input[@value='2']")
	private WebElement GenMale;
	
	@FindBy (xpath="//input[@value='1']")
	private WebElement GenFemale;
	
	@FindBy (xpath="//input[@value='-1']")
	private WebElement GenCustom;
	
	@FindBy (xpath="(//button[text()='Sign Up'])[1]")
	private WebElement SignUp;
	
	public CreateNewAccount(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterSignUpInfo() throws InterruptedException
	{
		FirstName.sendKeys("Ganesh");
		Surname.sendKeys("Melkunde");
		MobileEmail.sendKeys("gmelkunde74@gmail.com");
		ReEnterMobileEmail.sendKeys("gmelkunde74@gmail.com");
		NewPassword.sendKeys("Ganesh@2003");
		Select s=new Select(DOBDate);
		s.selectByValue("9");
		Thread.sleep(2000);
		Select s1=new Select(DOBMon);
		s1.selectByIndex(9);
		//Thread.sleep(2000);
		Select s2=new Select(DOBYear);
		s2.selectByValue("2003");
		GenMale.click();
		
	}
	public void signUpClick()
	{
		SignUp.click();
	}
	}
