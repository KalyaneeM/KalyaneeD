package Uitility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Util {
	
	public static File captureScreenshot(WebDriver driver,int a) throws IOException
	{
		TakesScreenshot srcshot=((TakesScreenshot)driver);
		File src=srcshot.getScreenshotAs(OutputType.FILE);
		File dest=new File("test-output"+File.separator+"ScreenShots"+File.separator+"test"+a+".jpeg");
		FileHandler.copy(src, dest);
		return dest; 
	}
	
	public static String getDataFromExcelSheet(int a,int b) throws EncryptedDocumentException, IOException
	{
		String data;
		
		FileInputStream file=new FileInputStream("src"+File.separator+"main"+File.separator+"resources"+File.separator+"TestData"+File.separator+"TestFile1.xlsx");
		Cell value=WorkbookFactory.create(file).getSheet("Sheet1").getRow(a).getCell(b);
		try
		{
			data=value.getStringCellValue();
		}
		catch(Exception e)
		{
			double num=value.getNumericCellValue();
			data=Double.toString(num);
		}
		return data;
		
	}
}
