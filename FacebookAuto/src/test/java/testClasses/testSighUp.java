package testClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Browsers.Base;
import Uitility.Util;
import pomClasses.CreateNewAccount;
import pomClasses.LoginPage;

public class testSighUp {
	
	WebDriver driver;
	CreateNewAccount newAccount;
	int i=1;
	@Parameters("browserName")
	@BeforeTest
	public void launchBrowser(String browser)
	{
		if(browser.equals("Chrome"))
		{
			driver=Base.openChromeBrowser();
			driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C550525804791%7Ce%7Cfacebook%7C&placement=&creative=550525804791&keyword=facebook&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696220912%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-1001394929%26loc_physical_ms%3D9303694%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjwp7eUBhBeEiwAZbHwkXzoppMYmJKmY8sk1dSNX7ScKa6LozPiorEW2Uwn13EICBqGtmoTnBoCQ8cQAvD_BwE");

		}
		if(browser.equals("Edge"))
		{
			driver=Base.openEdgeBrowser();
			driver.get("https://www.facebook.com/r.php");
		}
		if(browser.equals("Firefox"))
		{
			driver=Base.openFirefoxBrowser();
			driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C589460569900%7Ce%7Cfacebook%20login%7C&placement=&creative=589460569900&keyword=facebook%20login&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696221912%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-1409285535%26loc_physical_ms%3D9303694%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=EAIaIQobChMIhdTDkoH79wIVAtdMAh3SuAvzEAAYASAAEgI_6PD_BwE");
			
		}
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	
	@BeforeClass
	public void beforeClass()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhimashankar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		//driver= new ChromeDriver();
	}
	@BeforeMethod
	public void beforeMehod()
	{
		//driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C550525804791%7Ce%7Cfacebook%7C&placement=&creative=550525804791&keyword=facebook&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696220912%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-1001394929%26loc_physical_ms%3D9303694%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjwp7eUBhBeEiwAZbHwkXzoppMYmJKmY8sk1dSNX7ScKa6LozPiorEW2Uwn13EICBqGtmoTnBoCQ8cQAvD_BwE");
		newAccount=new CreateNewAccount(driver);
	}
	@Test
	public void testSignUpPage() throws InterruptedException, IOException
	{	
		
		newAccount.enterSignUpInfo();
		newAccount.signUpClick();
		
		String url=driver.getCurrentUrl();
		
		//Assert.assertEquals(url, "https://www.facebook.com/confirmemail.php?next=https%3A%2F%2Fwww.facebook.com%2F&__req=7");
		
	}
	@AfterMethod
	public void afterMethod(ITestResult res) throws IOException
	{i++;
		//System.out.println("afterMether signUp");
	if(ITestResult.FAILURE==res.getStatus())
		
		Util.captureScreenshot(driver,i);
	}
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
	

}
