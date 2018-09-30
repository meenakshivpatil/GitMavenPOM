package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ModulePage extends TestBase{

	@FindBy(xpath=".//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[1]/ul/li[2]/a")
	public WebElement modulesMenu;

	@FindBy(xpath=".//*[@id='module_name']")
	public WebElement modulename;	

	@FindBy(xpath=".//*[@id='module_id']")
	public WebElement moduleid;	

	@FindBy(xpath=".//*[@id='module_description']")
	public WebElement moduledescription;	

	@FindBy(xpath=".//*[@id='add-module']")
	public WebElement addModule;	

	@FindBy(xpath=".//*[@id='add_module_form']/div[4]/div[2]/a")
	public WebElement goToTestCase;	
	
	// Initializing the Page Objects:
	public ModulePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateModulePageTitle()
	{
		return driver.getTitle();
	}
	
	public void createModule(String fModuleName, String fModuleID, String fModuleDesc )
	{
		modulename.sendKeys(fModuleName);
		moduleid.sendKeys(fModuleID);
		moduledescription.sendKeys(fModuleDesc);
		addModule.click();
		
	}
}
