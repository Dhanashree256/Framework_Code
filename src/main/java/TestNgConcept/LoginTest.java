package TestNgConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LoginTest {
	
	//private static final String dependent = null;
	//private static final String dependsonMethods = null;
	WebDriver driver;
	
	@BeforeMethod
	public void initialization()
	{
System.setProperty("webdriver.chrome.driver", "C:\\Users\\shyam\\eclipse-workspace\\Framework_Code\\chromedriver.exe");
		 driver =new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
	}
	@Ignore
	@Test(priority =1,enabled=true,groups= {"Sanity Test ,Regression Test"})
	
	public void loginTest()
	{
	driver.findElement(By.cssSelector("input[placeholder=\"Username\"]")).sendKeys("Speedway");
	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/input[2]")).sendKeys("Speedway123");
	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/input")).click();
		
	}
	
	@Test(priority =3,enabled =true,groups="sanity Test")
	public void validLogoTest()
	{
			 boolean result =driver.findElement(By.cssSelector("take logo element path")).isDisplayed();
			 System.out.println(result);
	}
	
	@Test(priority =2 ,invocationCount=3,enabled =true)
	public void dummyMethod()
	{
		
		System.out.println("This is dummy Method");
	}
	
	//@Test(dependsOnMethods="loginTest")
	//public void createContact()
	//{
		//System.out.println("this test is dependent on login test case");
		
	//}

	
	@AfterMethod
	public void teardown()
	{
		driver.close();
		
	}
}
