package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Uitility.Util;
import pomClasses.LoginPage;

public class test {
	
	WebDriver driver;
	LoginPage loginPage;
	int i;
	
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhimashankar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	
	@BeforeMethod
	public void beforeMehod()
	{
		driver.get("https://www.facebook.com/");
		loginPage=new LoginPage(driver);
	}
	
	@Test
	public void verifyLogin()
	{
		loginPage.loginToApplication();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(url,"https://www.facebook.com/" );
		soft.assertEquals(title,"Log in to Facebook");
		/*
		 * if(url.equals("https://www.facebook.com/") &&
		 * title.equals("Log in to Facebook")) { System.out.println("Pass"); } else {
		 * System.out.println("Fail"); }
		 */
		soft.assertAll();
	}
	@Test
	public void verifyForgottenPasswordTab()
	{
		loginPage.clickForgottenPassword();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(url,"https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0" );
		soft.assertEquals(title,"Forgotten Password | Can't Log In | Facebook");
		soft.assertAll();
		/*
		 * if(url.equals(
		 * "https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0")
		 * && title.equals("Forgotten Password | Can't Log In | Facebook")) {
		 * System.out.println("Pass"); } else { System.out.println("Fail"); }
		 */
	}
	
	@AfterMethod
	public void afterMethod(ITestResult res) throws IOException
	{i++;
		if(ITestResult.FAILURE==res.getStatus())
		{
			Util.captureScreenshot(driver,i);
		}
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
	}


}
