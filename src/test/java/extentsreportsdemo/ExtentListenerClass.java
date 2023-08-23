package extentsreportsdemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentListenerClass implements ITestListener {
	
 // Extent Report created with TestNG Listener ---------------
	
	ExtentSparkReporter htmlReporter ;	
	ExtentReports reports ;	
	ExtentTest test ;
	
	 
	public void configureReport() {
		htmlReporter = new ExtentSparkReporter(".//extends-reports/ExtendsReports.html");  // path of extends reports
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter); 
		
		// add system information/environments info to reports
		reports.setSystemInfo("User Name", "Shubham V. Dhomane");
		
		// configuration to change look and feel of reporter
		htmlReporter.config().setDocumentTitle("Extent Listener Report");
	}
	
	

	// When execution start it will executes
	public void onStart(ITestContext result) {
		configureReport();
		System.out.println("On Start is invoke.....");
	}

	// When execution finished it will executes
	public void onFinish(ITestContext result) {
		System.out.println("On Finish is invoke.....");
		reports.flush();    // IMP *******************************
	}

	// When test case start it will executes 
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start... " +result.getName());
	}

	// When test case Successfully run it will executes
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Success... " +result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is : " + result.getName() ,ExtentColor.GREEN));
	}

	// When test case failed it will executes
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure... " +result.getName());
		WebDriver driver = new ChromeDriver();
	
		// to capture screenshot of failed Test
		if(ITestResult.FAILURE == result.getStatus())     //IMP *****************
		{
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
			FileUtils.copyFile(screenshot, new File(".//ScreenshotImages/screenImg.png"));
			System.out.println("we get an Screenshot of faild test case....");
		    } 
    	
    	catch (IOException e) 
    	   {
			
			e.printStackTrace();
		    }
		}
		
    // for Extent report
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is : " + result.getName() ,ExtentColor.RED));

	} 

	// When test case skipped it will executes
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped... " +result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test case is : " + result.getName() ,ExtentColor.YELLOW));
	}

	
	 
}
