package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class DashboardPage extends TestBase{
	
	@FindBy(xpath="/html/body/div/div/div[3]/h1")
	public WebElement Heading;
	
	@FindBy(xpath="/html/body/div/div/div[3]/div[1]/h4")
	public WebElement TestSetUp;
	
	//Module heading is being searched
	@FindBy(xpath="/html/body/div/div/div[3]/div[1]/div[1]/a/div/div[1]/h4")             
	public WebElement ClickTestSetup;
	
	//@FindBy(xpath="//img[contains(@class,'profile_pic')]")
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Edit Profile'])[1]/preceding::img[1]")
	public WebElement dashboardProfileLogo;
	
	//Initializing the Page Objects:
			public DashboardPage()
			{
				PageFactory.initElements(driver, this);
			}
			
			//Actions:
			public String validateDashboardPageTitle()
			{
				return driver.getTitle();
			}
			
			public boolean validateDashboardProfile()
			{
				return dashboardProfileLogo.isDisplayed();
			}
			
			public ModulePage moduleClick()
			{
				ClickTestSetup.click();
				return new ModulePage();
			}

}
