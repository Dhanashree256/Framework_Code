package TestNgConcept;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotations {

	//every annotations contains method with it ,void main method does not need TestNg take care of execution
	//for each test case before method and after method will get executed every time
	//we can write multiple test cases test case execution depends on alphabetical order priority method can use to decide sequence
	//you can set priority to -1 and 0 as well -1 will execute before 0 and continue
	//invocation count can be use to run one of the test case multiple times syntax @Tes(priority 1, invocationcount =5 )
	//to execute only one testcase within multiple use enable=true or false method in test parameter
	//all notes https://www.pavantestingtools.com/p/selenium.html
	@BeforeSuite
	public void beforesuit()
	{
		System.out.println("Method will execute Before suite for reporting");
		
	}
	@BeforeClass
	
	public void BeforeclassMethod()
	{
		System.out.println("Method will execute before class to add test data ");
		
	}
	
	@BeforeMethod
	public void initialization()
	{
		System.out.println("Url launched ");
	}
	
	@Test
	public void LoginTest()
	{
		System.out.println("send Id send Password click on submit");
	}
	
	@Test
	public void validatehomepage()
	{
		System.out.println("verified home page logo");
		
	}
	
	@AfterMethod
	public void teardown()
	{
		System.out.println("close the web browser");
	}
	
	@AfterClass
	
	public void AfterclassMethod()
	{
		
		System.out.println("AfterClass Method will vanish test data");
		
	}
	@AfterSuite
	public void Aftersuit()
	{
		System.out.println("Method will execute after suite for reporting");
		
	}
	
}
