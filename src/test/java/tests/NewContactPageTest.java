package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.NewContactPage;
import utility.ReadExcelData;

public class NewContactPageTest extends TestBase {

	NewContactPage contactPage;
	
	@BeforeMethod
	public void initialization() {
		init();
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.login();
		contactPage = homePage.clickOnContacts();
	}
	

	@DataProvider(name ="contact")              // data driven
	public String [][] useData() { 
		return ReadExcelData.getExcelData();    // From utility package 
	}
  
	
	@Test(dataProvider ="contact")
	public void validateNewContactPageTest(String fName, String lName, String department, String city, String coun) {
		contactPage.newContactPage(fName,lName,department,city,coun);
	}
	
  
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
	
	
}
