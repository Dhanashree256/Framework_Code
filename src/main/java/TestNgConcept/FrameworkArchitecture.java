package TestNgConcept;

public class FrameworkArchitecture {
	
	/*
	 * Maven Framework Architecture 
	 * divide your web pages in page object model pattern where we need to create page classes for every web page and diff test classes
	 * to perform test cases and test base class to define common functionality.
	 * 
	 * TestBase - define common functionality ,create WebDriver object and initialization method ,browser selection,
	 * 			implicit wait
	 * Pages - extend Base class,create constructor to assign objects , define pageFactory.init method to assign driver object,
	 * 			with the help of annotation find element locators and define actions.
	 * 			e.g loginpage ,homepage ,createContactpage
	 * Tests- extend base class,to access elements from pages create page class object with the help of objects call the methods
	 * 			and put on validations if any
	 * 			e.g loginpageTest ,homepageTest ,createContactpageTest
	 * config.propertiesfile 
	 * 			set environment variables and access them through files .
	 * testng.xml
	 * 			if you convert project to testng.xml for run you can set parallel execution, cross browser testing,can set parameters
	 * 			group execution ,test suit execution ,or required classes execution 
	 * TestOutput
	 * 			once you run the test test-output folder gets create with this help we can get html report and we can run only failed 
	 * 			test cases ,ExtendsReport
	 * pom.xml
	 * 			can define dependencies 
	 * 
	 * Utilities 
	 * 			use to define common actions /methods
	 * 			e.g mousehover ,switchtowindow,switchtoframe,screenshots
	 * TestData
	 * 			MSexcel data driven testing
	 */

}
