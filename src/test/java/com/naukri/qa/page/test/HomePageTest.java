package com.naukri.qa.page.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.naukri.qa.base.TestBase;
import com.naukri.qa.pages.HomePage;
import com.naukri.qa.pages.LoginPage;
import com.naukri.qa.utils.pageUtils;

import junit.framework.Assert;

public class HomePageTest extends TestBase {
	LoginPage login;
	HomePage homePage;
	pageUtils utils;
	HomePageTest(){
		super();
	}


	@BeforeClass
	public void setUp() {
		
		login = new LoginPage();
		utils = new pageUtils();
		homePage = new HomePage();

	}
	@Test(priority = 1)
	public void verifyHomePageTitle() throws Exception {
		verifyHomePageTitle1();

	}


	public void verifyHomePageTitle1() throws Exception {
		try {
			String HomePageTitile = homePage.verifyHomePageTitile();
			Assert.assertEquals(HomePageTitile, "Home | Mynaukri");
			System.out.println("home title is matched");
		} catch (Exception e) {
			throw new Exception("unable to verify home page title");
		}
	}
	@Test(priority = 2)
	public void verifyHomePageLogo() throws Exception {
		try {
			Assert.assertTrue(homePage.verifyLogo());

		} catch (Exception e) {
			throw new Exception("unable to verify home page logo");
		}
	}
	@Test(priority = 3)
	public  void enterInSerachFeild() throws Exception{
		try {
			homePage.enterInSearchField("global logic", "noida");
			
		} catch (Exception e) {
			throw new Exception ("unable to enter in search field");
		}
	}

	

}
