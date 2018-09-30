package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.HomePage;
import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath = "//span[@class='soh']")
	WebElement eyeIcon;
	
	@FindBy(xpath="//*[@id=\"singlebutton\"]")
	public WebElement loginBtn;
	
	@FindBy(xpath="//*[@id='mainNav']/div/div[1]/a/img")  
	WebElement anyautLogo;
	
	@FindBy(xpath="/html/head/title")
	public WebElement title;
	
		

		//Initializing the Page Objects:
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		}
		//Actions:
		public String validateLoginPageTitle()
		{
			return driver.getTitle();
		}
		
		public boolean validateAnyautImage()
		{
			return anyautLogo.isDisplayed();
		}
		
		// after login page home page comes so return type is HomePage
		public DashboardPage login(String un, String pwd)
		{
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			return new  DashboardPage();
		}

}
