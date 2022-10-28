package com.naukri.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.qa.base.TestBase;

public class HomePage extends TestBase{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//img[@alt='Naukri Logo'])[1]")
	WebElement naukriLogo;	
	
	@FindBy(xpath = "//div[text()='Companies']")
	WebElement companies;
	
	@FindBy(xpath = "//div[text()='Top companies']")
	WebElement topCompanies;
	
	@FindBy(xpath = "//div[@class='nI-gNb-notif-center']")
	WebElement notifiactionIcon;
	
	@FindBy(xpath ="//div[text()= 'Upload Resume']")
	WebElement uploadResume;
	
	
	
	
	@FindBy(xpath = "//input[@name='qp']")
	WebElement searchField;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement search_Button;
	
	@FindBy(xpath = "//input[@name='ql']")
	WebElement location_field;
	
	public String verifyHomePageTitile() {
		
		return driver.getTitle();
	}
	public boolean verifyLogo() {
		return naukriLogo.isDisplayed();
	}
	public void clickOnCompanies() throws Exception {
		Thread.sleep(3000);
		Actions action =new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(companies).build().perform();
		Thread.sleep(3000);
		topCompanies.click();
	}
	
	public pendingActions clickNotificationIcon() throws Exception {
		Thread.sleep(3000);
		Actions action =new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(notifiactionIcon).build().perform();
		Thread.sleep(4000);
		uploadResume.click();
		return new pendingActions();
	}
	
	
	public void enterInSearchField(String text,String text1) throws Exception {
		Thread.sleep(3000);
		searchField.sendKeys(text);
		Thread.sleep(4000);
		location_field.sendKeys(text1);
		Thread.sleep(3000);
		search_Button.click();
		Thread.sleep(3000);
	}
	
	
	
	
}
