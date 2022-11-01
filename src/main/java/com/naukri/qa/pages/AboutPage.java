package com.naukri.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naukri.qa.base.TestBase;

public class AboutPage extends TestBase {
	public AboutPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//img[@src='/img/logo.gif'])[1]")
	WebElement infoEdgeLogo;	

	@FindBy(xpath = "//a[text()='INVESTOR RELATIONS']")
	WebElement investorRelationsTab;


	@FindBy(xpath = "//div[@class=\"leftside\"]//li/a")
	List<WebElement> suggestionTab;
	
	


	public String verifyInfoEdgeTitle() {
		return driver.getTitle();
	}

	public boolean verifyInfoEdgePageLogo() {
		return infoEdgeLogo.isDisplayed();
	}
	
	public void toGetWindowTitle() {
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String>it =   windowHandles.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
		}
	}
	public void clickOninvestorRelationsTab() {
		Actions action = new Actions(driver);
		action.moveToElement(investorRelationsTab).build().perform();

	}
	public void toFindSuggestion(String text) {
		System.out.println(suggestionTab.size());
		for(int i=0; i<suggestionTab.size(); i++) {
			System.out.println(suggestionTab.get(i).getText());
			if(suggestionTab.get(i).getText().contains(text)) {
				suggestionTab.get(i).click();
				break;
			}
		}
	}

}
