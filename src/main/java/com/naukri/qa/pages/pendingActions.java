package com.naukri.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.qa.base.TestBase;
import com.naukri.qa.utils.pageUtils;

public class pendingActions extends TestBase {
	
	public pendingActions(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[contains(@class,'ervices nI-gNb-dropdown--displaced')]//a")
	List<WebElement> selectTabs;

	@FindBy(xpath = "//span[text()='Upload Photo']")
	WebElement uploadPhoto;
	
	@FindBy(xpath= "//div[text()='Services']")
	WebElement serviceTab;
	
	@FindBy(xpath = "//div[@class='nI-gNb-wrap']")
	WebElement footerText;
	
	@FindBy(xpath =  "//span[text()='Search jobs here']")
	WebElement enterSearchButton;

	@FindBy(xpath =  "//input[@placeholder='Enter keyword / designation / companies']")
	WebElement enterField;
	
	
	@FindBy(xpath =  "//input[@name='experienceDD']")
	WebElement SelectExperienceField1;
	
	@FindBy(xpath =  "//ul[@class='dropdown ']//li")
	List<WebElement> SelectExperienceField;
	
	@FindBy(xpath =  "//input[@placeholder='Enter location']")
	WebElement enterlocation;
	
	@FindBy(xpath =  "//span[text()='Search']")
	WebElement searchIcon;


	public String verifYPendingActionsTitle() {
		return driver.getTitle();
	}
	public boolean  pendingActionsText() {
		return uploadPhoto.isDisplayed();
	}
	public void selectIcon() throws Exception {
		Thread.sleep(3000);
		Actions action =new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(serviceTab).build().perform();
		List<WebElement> tabs = selectTabs;
		System.out.println(tabs.size());
		for(int i =0; i<tabs.size(); i++) {
//			Thread.sleep(2000);
			String str = tabs.get(i).getText();
			System.out.println(str);
		}
	}
	public void getFooterText() throws Exception {
		pageUtils.scrollDownPage();
		String text =  footerText.getText();
		System.out.println(text);
		Thread.sleep(4000);
		
	}
	
	public void enterSearchIcon() {
		enterSearchButton.click();
		
	}
	public void enterfields(String companiesName ,String experience , String location) throws Exception {
		enterSearchIcon();
		enterField.sendKeys(companiesName);
		SelectExperienceField1.click();
		Thread.sleep(4000);
		for(int i=0 ; i<SelectExperienceField.size(); i++) {
			if(SelectExperienceField.get(i).getText().contains(experience)){
				SelectExperienceField.get(i).click();
				break;
			}
		}
		
		
		Thread.sleep(3000);
		enterlocation.sendKeys(location);
		Thread.sleep(4000);

		searchIcon.click();
		
	}
	
	
}

