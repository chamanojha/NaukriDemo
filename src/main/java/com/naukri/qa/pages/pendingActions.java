package com.naukri.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.qa.base.TestBase;
import com.naukri.qa.utils.pageUtils;

public class PendingActions extends TestBase {

	public PendingActions(){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@class,'ervices nI-gNb-dropdown--displaced')]//a")
	List<WebElement> selectTabs;

	@FindBy(xpath = "//span[text()='Upload Photo']")
	WebElement uploadPhoto;

	@FindBy(xpath = "(//span[@class='empty'])[1]")
	WebElement uploadGetText;

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


	@FindBy(xpath = "//a[text()='About us']")
	WebElement about_button;



	public String verifYPendingActionsTitle() {
		return driver.getTitle();
	}
	public boolean  pendingActionsText() {
		return uploadPhoto.isDisplayed();

	}
	public void geUploadText() {
		String uploadText = uploadGetText.getText();
		System.out.println(uploadText);
	}
	public void selectIcon() throws Exception {
		Thread.sleep(2000);
		Actions action =new Actions(driver);
		Thread.sleep(2000);
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

	public void clickSearchbutton() {
		enterSearchButton.click();

	}
	public void enterfields(String companiesName ,String experience , String location) throws Exception {
		clickSearchbutton();
		enterField.sendKeys(companiesName);
		SelectExperienceField1.click();
		Thread.sleep(2000);
		for(int i=0 ; i<SelectExperienceField.size(); i++) {
			if(SelectExperienceField.get(i).getText().contains(experience)){
				SelectExperienceField.get(i).click();
				break;
			}
		}


		Thread.sleep(2000);
		enterlocation.sendKeys(location);
		Thread.sleep(2000);

		searchIcon.click();

	}
	public String toGetWindowTitle(String text) {
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String > hList = new ArrayList<String>(windowHandles);
		if(switchToRightWindow(text, hList)){
			System.out.println(driver.getCurrentUrl()+ "  -  " + driver.getTitle());
		}
		return parentWindow;
	}
	public  boolean switchToRightWindow(String windowTitle, List<String> hList) {
		for (String e : hList) {
			String title = driver.switchTo().window(e).getTitle();
			if(title.contains(windowTitle)) {
				System.out.println("found the right window");
				return true;
			}
		}
		return false;
	}
	public String closeWindow(String parentWindowId ) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> hList = new ArrayList<String>(windowHandles);
		for (String e : hList) {
			if(!e.equals(parentWindowId)){
				driver.switchTo().window(e).close();

			}
		}
		return  driver.getTitle();
	}
	public InfoEdgePage clickOnAboutButton() {
		about_button.click();
		return new InfoEdgePage();
	}

	public void switchToParentWindowId(String parentWindow) {
		driver.switchTo().window(parentWindow);
	}
}

