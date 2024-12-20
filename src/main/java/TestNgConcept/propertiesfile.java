package TestNgConcept;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//while accessing data through properties file first we need to read the file with fileinputstream object and after that need to load
//it in properties file object 
//assigning values in files is good way as suppose in future some modifications happen in values we can just update file.
//cross browser testing also possible with .properties file
public class propertiesfile {

	WebDriver driver;
	Properties prop;
	@BeforeMethod
	public void init() throws IOException
	{
		prop =new Properties(); //created object to access values from properties file
		FileInputStream file=new FileInputStream("C:\\Users\\shyam\\eclipse-workspace\\Framework_Code\\Config,properties");
		//with the help of FileInputStream object we can read file and add throws exception to handle situation if file don't find
		prop.load(file);
		//now load file in load function
		String browser=prop.getProperty("filebrowser");
		if(browser.contains("chrome"))
		{
		System.setProperty("WebDriver.chrome.driver", "\"C:\\Users\\shyam\\eclipse-workspace\\Framework_Code\\chromedriver.exe");
		driver =new ChromeDriver();
		
		}
		else if(browser.contains("Firefox"))
		{
		System.setProperty("WebDriver.gecko.driver", "\"C:\\Users\\shyam\\eclipse-workspace\\Framework_Code\\gecko.exe");
		driver =new FirefoxDriver();	
		}	
		driver.get(prop.getProperty("url")); 
		
	}
	@Test
	public void loginTest()
	{
	driver.findElement(By.cssSelector("input[placeholder=\"Username\"]")).sendKeys(prop.getProperty("username"));
	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/input[2]")).sendKeys(prop.getProperty("password"));
	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/input")).click();
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
		
	}
	
	
	
	
}
