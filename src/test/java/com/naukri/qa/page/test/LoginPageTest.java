package com.naukri.qa.page.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.naukri.qa.base.TestBase;
import com.naukri.qa.pages.HomePage;
import com.naukri.qa.pages.LoginPage;
import com.naukri.qa.utils.pageUtils;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{

	LoginPage login;
	pageUtils  utits;
	HomePage homepage;
	
	public LoginPageTest(){
		super();
	}

	@BeforeClass
	public void setUp() throws Exception {
	
		login = new LoginPage();
		utits = new pageUtils();
		homepage = new HomePage();
//		homepage = login.submitForm(prop.getProperty("userName"), prop.getProperty("password"));



	}
	@Test(priority = 1)
	public void verifyNaukriLogoTest() throws Exception {
		try {
			boolean NaukriImg = login.validateNaukriImg();
			Assert.assertTrue(NaukriImg);
		} catch (Exception e) {
			throw new Exception("unable to verify naukri logo test ");
		}

	}
	@Test(priority = 2)

	public void verifyLoginPageTitleTest() throws Exception {
		try {
			String title = login.validateLoginPagetitle();
			assertEquals(title, "Jobseeker's Login: Search the Best Jobs available in India & Abroad - Naukri.com");
		} catch (Exception e) {
			throw new Exception("unable to verify login page title test");
		}
	}

	@Test(priority = 3)
	public void verifyLoginPageTest() throws Exception {
		try {
			homepage = login.submitForm(prop.getProperty("userName"), prop.getProperty("password"));
			
			Thread.sleep(6000);
		} catch (Exception e) {
			throw new Exception("unable to  verify Login page");
		}

	}
	


	



}
