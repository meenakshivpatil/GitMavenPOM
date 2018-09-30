package com.qa.base;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.log4j.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

//import com.qa.testcases.DashboardPageTest;
//import com.qa.testcases.LoginPageTest;
import com.qa.util.TestUtil;


public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	
		
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\"
					+ "qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		 if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Eclipse\\EclipseMyWorkspace\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
			
		}
		 else if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\EclipseMyWorkspace\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("IE"))
		{
			// IEDriverServer.exe for 32 and 64 bit works slow 
			System.setProperty("webdriver.IE.driver", "C:\\Eclipse\\EclipseMyWorkspace\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		//For IE to run Go to Tools menu – Internet Options
		/* Select Security Tab
		 In Select a zone to view or change security settings choose Internet and select the check box of Enable protected mode (requires restarting Internet Explorer).
		 Similarly, select the check box of Enable protected mode (requires restarting Internet Explorer) for other three such as Local Intranet,
		Trusted sites, and Restricted sites.  Browser zoom level set to 100%.*/
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 
		
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 
		 driver.get(prop.getProperty("url"));
		
	}
	
	
}
