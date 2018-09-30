package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public void switchToFrame(){
		driver.switchTo().frame("ChatWidgetButton-iframe");
	}
	
	public static String TESTDATA_SHEET_PATH = "C:\\Eclipse\\EclipseMyWorkspace\\HFCRM\\src\\main\\java\\com\\qa\\testdata\\DataAnyaut.xlsx";
	
	static Workbook wb;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			wb = WorkbookFactory.create(file);
		} catch (InvalidArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Sheet name => "+ sheetName);
		sheet = wb.getSheet(sheetName);
		
		int rowcnt = sheet.getLastRowNum();
		int colcnt =  sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
					
		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String screenLocation = "C:\\Eclipse\\EclipseMyWorkspace\\exception.png" ;	
			//System.out.println(ScreenLocation);
			FileUtils.copyFile(screenShot, new File(screenLocation));			
			
		    } catch (IOException e)
		    {
		    	e.printStackTrace();	
		    }
	}
	
	
	
	
	
	
	
	
	
}
