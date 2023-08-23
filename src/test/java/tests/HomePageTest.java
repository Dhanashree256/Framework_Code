package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void initialization() {
		init();
		loginPage = new LoginPage(); 
	    homePage = loginPage.login();
	}
	
//	@Ignore
	@Test
	public void validateLogoutLinkTest() {
		boolean log = homePage.checkLogout();	
		Assert.assertTrue(log);
	}
	
//	@Ignore
	@Test
	public void validateUserTextTest() {
	    boolean uTxt = homePage.checkUserText();	
		Assert.assertTrue(uTxt);
	}
	
//	@Ignore
	@Test
	public void validateComapanies_Link_Redirection_Test() {
		homePage.clickOnCompanies();
		String industry = driver.findElement(By.xpath("//strong[text()='Industry']")).getText();
		Assert.assertEquals(industry, "Industry");
	}
	
//	@Ignore
	@Test
	public void validateContactLinkTest() {
		homePage.clickOnContacts();
		String contactInformation = driver.findElement(By.xpath("//legend[text()='Contact Information']")).getText();
		Assert.assertEquals(contactInformation, "Contact Information");
	}
	
	
	@Test
	public void validateDealsLinksTest() {
		homePage.clickOnDeals();
		String dealNo = driver.findElement(By.xpath("//strong[text()='Deal No.']")).getText();
		Assert.assertEquals(dealNo, "Deal No.");
	}
	
	
	@Test
	public void validateTasksLinksTest() {
		homePage.clickOnTasks();
		String taskNoString = driver.findElement(By.xpath("//strong[text()='Task No.']")).getText();
		Assert.assertEquals(taskNoString, "Task No.");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	

}
