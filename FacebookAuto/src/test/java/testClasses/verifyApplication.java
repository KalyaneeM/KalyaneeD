package testClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Uitility.Util;
import pomClasses.LoginPage;

public class verifyApplication {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhimashankar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//1st test case
		
		driver.get("https://www.facebook.com/");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApplication();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		if(url.equals("https://www.facebook.com/") && title.equals("Log in to Facebook"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
		//2nd test case
		
		driver.get("https://www.facebook.com/");
		
		LoginPage loginPage1=new LoginPage(driver);
		loginPage1.clickForgottenPassword();
		
		String url1=driver.getCurrentUrl();
		String title1=driver.getTitle();
		
		if(url1.equals("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0") && title1.equals("Forgotten Password | Can't Log In | Facebook"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}

}
