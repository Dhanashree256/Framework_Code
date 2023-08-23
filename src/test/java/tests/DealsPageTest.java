package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DealsPage;
import pages.LoginPage;
import utility.Util;

public class DealsPageTest extends TestBase {
	
	LoginPage loginPage ;
	DealsPage dealsPage ;
	
	@BeforeMethod
	public void initialization() {
		init();
		loginPage = new LoginPage();
		dealsPage = new DealsPage();
		
		loginPage.login();
		Util.switchToFrame();
	}

	
	@Test
	public void validateDealsLink() {
		dealsPage.clickOnNewDealsLinks();
		dealsPage.sendData();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
