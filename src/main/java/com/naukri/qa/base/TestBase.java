package com.naukri.qa.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.naukri.qa.utils.PropertiesUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase  {

	public static WebDriver driver;
	public static Properties prop;
	
	public  TestBase(){
		prop = PropertiesUtils.readProperties();	
	}

	
	
	@BeforeSuite
	public  void intializeDriver() {
		String browser = prop.getProperty("browser");
		if(browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("pageLoadTime")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
	

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
	

