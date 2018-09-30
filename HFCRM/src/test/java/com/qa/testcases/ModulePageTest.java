package com.qa.testcases;


import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ModulePage;
import com.qa.util.TestUtil;

public class ModulePageTest extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	ModulePage modulePage;
	TestUtil testUtil;
	String sheetName = "Module";
	
	Logger log = Logger.getLogger(ModulePageTest.class);
	
	public ModulePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		log.warn("Hey this is warning");
			
		loginPage = new LoginPage();
		dashboardPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		modulePage = new ModulePage();
		testUtil = new TestUtil();
		modulePage= dashboardPage.moduleClick();
	}
	
	@Test(priority=1)
	public void ModulePageTitletest()
	{
		String title = modulePage.validateModulePageTitle();
				
		if (title.equalsIgnoreCase("Add Module | AnyAUT")) 
		{
			System.out.println("Module Page Title found");
		}else
			System.out.println("Module Page Title not found");
	}
	
	@DataProvider
	public Object[][] getAnyautData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getAnyautData")
	public void validateCreateNewModule(String fModuleName, String fModuleID, String fModuleDesc)
	{
		//dashboardPage.moduleClick();
		modulePage.createModule(fModuleName, fModuleID, fModuleDesc);
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
