package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.NewCompanyPage;

public class NewCompanyPageTest extends TestBase {
	
	NewCompanyPage companyPage;
	
	@BeforeMethod
	public void initialization() {
		init();
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.login();
	    companyPage = homePage.clickOnCompanies();
	}
	
	
	
	@Test
	public void validateNewCompanyTest() {
		companyPage.newCompany("Indica", "MIDC Pune", "20,000,000"); 
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
