package com.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ModulePage;

import junit.framework.Assert;

public class DashboardPageTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ModulePage modulePage;
	Logger log = Logger.getLogger(DashboardPageTest.class);
	
	public DashboardPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		log.info("Entering into application");
		loginPage= new LoginPage();
		dashboardPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		dashboardPage= new DashboardPage();
	}
	
	@Test(priority=1)
	public void dashboardPageTitletest()
	{
		String title = dashboardPage.validateDashboardPageTitle();
				
		if (title.equalsIgnoreCase("Dashboard | AnyAut")) 
		{
			System.out.println("Title found");
		}else
			System.out.println("Title not found");
	}
	
	@Test(priority=2)
	public void dashboardLogoProfileTest()
	{
		boolean flag = dashboardPage.validateDashboardProfile();
		
		System.out.println("DashboardPageProfile found   "+ flag);
		
		Assert.assertTrue(flag);
		
		
	}
	@Test(priority=3)
	public void dashboardModuleClick()
	{
	    	modulePage = dashboardPage.moduleClick();
	    	
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
  
}
