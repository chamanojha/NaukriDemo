package com.naukri.qa.page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.naukri.qa.base.TestBase;
import com.naukri.qa.pages.AboutPage;
import com.naukri.qa.pages.HomePage;
import com.naukri.qa.pages.LoginPage;
import com.naukri.qa.pages.PendingActions;
import com.naukri.qa.utils.pageUtils;

import junit.framework.Assert;

public class AboutPageTest extends TestBase {
	
	LoginPage login;
	pageUtils utils;
	HomePage homepage;
	PendingActions pendinActions;
	AboutPage aboutpage;
	AboutPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() throws Exception {
		login = new LoginPage();
		homepage = new HomePage();
		pendinActions = new PendingActions();
		aboutpage = new AboutPage();
		aboutpage =	pendinActions.clickOnAboutButton();
		Thread.sleep(5000);
	}
	
	
	@Test
	public void verifyInfoPagetitle() throws Exception {
		verifyInfoPageTiltle1();
	}
	@Test(priority = 1)
	public void verifyInfoPageTiltle1() throws Exception {
		try {
			Thread.sleep(2000);
			aboutpage.toGetWindowTitle();
			String infoEdgeTitle =  aboutpage.verifyInfoEdgeTitle();
			Assert.assertEquals(infoEdgeTitle, "Info Edge (India) Limited");
			Thread.sleep(2000);
			
		} catch (Exception e) {
			throw new Exception("unable to verify Info page");
		}
	}
	@Test(priority =  2)
	public void verifyInfoEdgeLogo() throws Exception {
		try {
			Assert.assertTrue(aboutpage.verifyInfoEdgePageLogo());
			System.out.println("Info Edge Logo page is passed");
		} catch (Exception e) {
			throw new Exception(" uable to verify Info Edge Logo page ");
		}
	}
	@Test(priority = 3)
	public void clickOnTab() throws Exception {
		aboutpage.clickOninvestorRelationsTab();
		Thread.sleep(4000);
		aboutpage.toFindSuggestion("Newspaper Publication");
		Thread.sleep(3000);
	}
	
	
}
