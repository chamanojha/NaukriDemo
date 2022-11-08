package com.naukri.qa.page.test;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.naukri.qa.base.TestBase;
import com.naukri.qa.pages.HomePage;
import com.naukri.qa.pages.InfoEdgePage;
import com.naukri.qa.pages.LoginPage;
import com.naukri.qa.pages.PendingActions;
import com.naukri.qa.utils.pageUtils;

import junit.framework.Assert;

public class InfoEdgeTest  extends TestBase {
	
	LoginPage login;
	pageUtils utils;
	HomePage homepage;
	PendingActions pendinActions;
	InfoEdgePage infoEdgePage;
	InfoEdgeTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() throws Exception {
		login = new LoginPage();
		homepage = new HomePage();
		pendinActions = new PendingActions();
		infoEdgePage = new InfoEdgePage();
		infoEdgePage =	pendinActions.clickOnAboutButton();
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
			pendinActions.toGetWindowTitle("Info Edge (India) Limited");
			
			String infoEdgeTitle =  infoEdgePage.verifyInfoEdgeTitle();
			Assert.assertEquals(infoEdgeTitle, "Info Edge (India) Limited");
			Thread.sleep(2000);
//			Assert.assertTrue(aboutpage.verifyInfoEdgePageLogo());
			
		} catch (Exception e) {
			throw new Exception("unable to verify Info page");
		}
	}
	@Test(priority =  2)
	public void verifyInfoEdgeLogo() throws Exception {
		try {
			Assert.assertTrue(infoEdgePage.verifyInfoEdgePageLogo());
			System.out.println("Info Edge Logo page is passed");
		} catch (Exception e) {
			throw new Exception(" uable to verify Info Edge Logo page ");
		}
	}
	@Test(priority = 3)
	public void clickOnTab() throws Exception {
		try {
			infoEdgePage.clickOninvestorRelationsTab();
			Thread.sleep(4000);
			infoEdgePage.toFindSuggestion("Audit Committee");
			Thread.sleep(3000);
			driver.navigate().back();
			
//			System.out.println(driver.getCurrentUrl()+ "    -    " +driver.getTitle());
			Thread.sleep(4000);

		} catch (Exception e) {
			throw new Exception("unable to click on button");
		}
		
	} @Test(priority = 4)
	public void switchToParentWindow() throws Exception {
		try {
			Thread.sleep(5000);
			System.out.println(driver.getCurrentUrl() + "    -  " + driver.getTitle());
			Thread.sleep(4000);
			pendinActions.switchToParentWindowId(pendinActions.toGetWindowTitle("Pending Actions | Mynaukri"));
			Thread.sleep(4000);

		} catch (Exception e) {
			throw new Exception("unable to switch to parent window");
		}
	}
	
}
