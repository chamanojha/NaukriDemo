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

public class PendingActionsTest extends TestBase {
	LoginPage login;
	pageUtils utils;
	HomePage homepage;
	PendingActions pendinActions;
	InfoEdgePage infoEdgePage ;
	

	PendingActionsTest(){
		super();
	}
	@BeforeClass
	public void setup() throws Exception {
		
		login = new LoginPage();
		homepage = new HomePage();
		pendinActions = new PendingActions();
		infoEdgePage = new InfoEdgePage();
		
		homepage.clickNotificationIcon();
		Thread.sleep(5000);
		
	}
	@Test(priority =  1)
	public void verifYPendingLogoTest() throws Exception {
		try {
			String pendingactions = pendinActions.verifYPendingActionsTitle();
			Assert.assertEquals(pendingactions, "Pending Actions | Mynaukri");
			System.out.println("pending actions is passed !");
		} catch (Exception e) {
			throw new Exception("unable to verifyPedingLogo");
		}
	}
	@Test(priority = 2)
	public void  verifyPenfingActionsTextTest() throws Exception {
		try {
			Assert.assertTrue(pendinActions.pendingActionsText());
			pendinActions.geUploadText();
		} catch (Exception e) {
			throw new Exception("unable to verify Penfing Actions Text Test");
		}
	}
	
	@Test(priority = 3)
	public void selectAllTabs() throws Exception {
		try {
			pendinActions.selectIcon();
			Thread.sleep(4000);
		} catch (Exception e) {
			throw new Exception("unable to select All Tabs");
		}
	}
	@Test(priority =  4)
	public void footerText() throws Exception {
		try {
			pendinActions.getFooterText();
			
		} catch (Exception e) {
			throw new Exception("unable to footer text");
		}
	}
	
	@Test(priority = 5)
	public void enterfields() throws Exception {
		try {
			pendinActions.enterfields("iris software", "2 years", "Banglore");
			Thread.sleep(3000);
			pageUtils.backToPreviousPage();
			Thread.sleep(3000);
			
			

		} catch (Exception e) {
			throw new Exception("unable to enter fields");
		}
	}
	
	
	
	
	
}
