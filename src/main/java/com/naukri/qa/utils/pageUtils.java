package com.naukri.qa.utils;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.naukri.qa.base.TestBase;

public class pageUtils extends TestBase {

	public static void scrollDownPage() {
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");			
	
	}
	public static void selectMethod(List<WebElement> xpath, String value) {
		Select select = new Select((WebElement) xpath);
		select.selectByValue(value);
	}
	public static void backToPreviousPage() {
		driver.navigate().back();
	}
}
	

