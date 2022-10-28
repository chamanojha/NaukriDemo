package com.naukri.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.qa.base.TestBase;

public class LoginPage extends TestBase{

	public LoginPage() {
		PageFactory.initElements(driver, this);
 	}
	
	
	
	@FindBy(xpath = "//input[@id='usernameField']")
	WebElement userName ;
	
	
	
	@FindBy(xpath = "//input[@id='passwordField']")
	WebElement password ;
	
	

	@FindBy(xpath= "//button[text()='Login']")
	WebElement button ;
	
	@FindBy(xpath = "(//img[@alt='Naukri Logo'])[1]")
	WebElement naukriLogo;
	
	public String validateLoginPagetitle() {
		return driver.getTitle();
		
	}
	public boolean validateNaukriImg() {
		return naukriLogo.isDisplayed();
	}
	
//	public void clickOnLoginButton() {
//		button.click();
//	}
	public HomePage submitForm(String un , String pwd) {
		userName.sendKeys(un);
		password.sendKeys(pwd);
		button.click();
		return new HomePage();
	}
	
}
