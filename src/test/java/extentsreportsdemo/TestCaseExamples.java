package extentsreportsdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(extentsreportsdemo.ExtentListenerClass.class)       // to executes only a single particular class 
public class TestCaseExamples {
	
/*  # To executes multiple classes use this code in testng.xml file :
	 
	<suite name="Suite">
	<listeners>
	   <listener class-name="extentsreportsdemo.ExtentListenerClass"></listener>  
	                            // --Listener class name-- 
	</listeners>

*/


	WebDriver driver;


	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "D://Java Software//chromedriver_win32//chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("Speedway2023");
		driver.findElement(By.name("password")).sendKeys("Speedway@2023");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.switchTo().frame("mainpanel");

	}

	@Ignore
	@Test(priority =1)
	public void validateCalenderTest() { // Successful method
		driver.findElement(By.xpath("//a[text()='Calendar']")).click();
	}

	@Test(priority =2)
	public void validateCompaniesTest() { // Failure method
		driver.findElement(By.xpath("//a[text()='Compani']")).click();  //write Xpath is //a[text()='Companies']
	}

	@Test(priority = 3)
	public void validateContactTest() {// Skipped Method
		//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		throw new SkipException("skipping Method due to some reasons");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
