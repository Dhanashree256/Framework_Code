package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;


public class LoginPageTest extends TestBase{
	
   LoginPage loginPage;
	
	@BeforeMethod
	public void initialization() {
		init();
		loginPage = new LoginPage();

	}
	
	@Test
	public void validateLoginPageTest() {
        loginPage.login();
        String userId = driver.findElement(By.xpath("//*[contains(text(),'Home')]")).getText();
        Assert.assertEquals(userId, "HOME");       
	}
	
	
	@Test
	public void validateForgotPasswordLink() {
		loginPage.forgotPasswordLink();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
