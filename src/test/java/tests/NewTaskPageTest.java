package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.NewTaskPage;

public class NewTaskPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage ;
	NewTaskPage taskPage ;
	
	@BeforeMethod
	public void initialization() {
		init();
		homePage = new HomePage();
		loginPage = new LoginPage();
		taskPage = new NewTaskPage();
		loginPage.login();
		homePage.clickOnTasks();
		
	}

	
	@Test
	public void validateNewTaskTest() {
		taskPage.newTask();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
