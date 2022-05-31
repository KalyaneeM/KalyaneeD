import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import Uitility.Util;

public class test {
	public static void main(String arg[]) throws EncryptedDocumentException, IOException
	{
		
		String Data=Util.getDataFromExcelSheet(0, 0);
		System.out.println(Data);
	}
}
