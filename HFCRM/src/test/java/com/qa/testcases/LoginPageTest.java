package com.qa.testcases;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.*;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.DashboardPage;
import com.qa.pages.HomePage;
import com.qa.base.TestBase;
import com.qa.pages.LoginPage;


import junit.framework.Assert;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		log.info("Entering into application");
		loginPage= new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitletest()
	{
		String title = loginPage.validateLoginPageTitle();
				
		if (title.equalsIgnoreCase("Login | AnyAut")) 
		{
			System.out.println("Title found");
		}else
			System.out.println("Title not found");
	}
	
	@Test(priority=2)
	public void anyautLogoImageTest()
	{
		boolean flag = loginPage.validateAnyautImage();
		
		System.out.println("Flag is   "+ flag);
		
		Assert.assertTrue(flag);
		
		
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		dashboardPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
