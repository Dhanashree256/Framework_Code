package TestNgConcept;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AlertsConcept{
	
	static WebDriver driver;
	
	static Alert alt;
	
	@BeforeMethod
	
	public static void init()
	{
	System.setProperty("WebDriver.chrome.Driver", "C:\\\\Users\\\\shyam\\\\eclipse-workspace\\\\Framework_Code\\\\chromedriver.exe");
	//WebDriverManager.chromedriver().setup();
	driver =new ChromeDriver();
	
	driver.get("https://demo.automationtesting.in/Alerts.html");
	driver.findElement(By.xpath("(//p[@class=\"fc-button-label\"])[1]")).click();
	
	}
	
	
	
	@Test
	public void AlertWithOk()
	{
	driver.findElement(By.xpath("//a[text()=\"Alert with OK \"]")).click();
	driver.findElement(By.xpath("//button[@onclick=\"alertbox()\"]")).click();
		
		
		alt=driver.switchTo().alert();
		
		String Text= alt.getText();
		
		System.out.println("Text" +Text);

		alt.accept();

	}	
	
	@Test
	
	public void AlertWithOkAndCancel()
	{
		
	driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel ')]")).click();	
		
	driver.findElement(By.xpath("(//button[contains(text(),'click the button')])[2]")).click();
	
		alt=driver.switchTo().alert();
		
		alt.dismiss();
		
		String Text=driver.findElement(By.xpath("//p[contains(text(),'You Pressed Cancel')]")).getText();
		
		System.out.println(Text);
	}
	@Test
	
	public void AlertwithTextboxField() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox ')]")).click();
		driver.findElement(By.xpath("//button[@onclick=\"promptbox()\"]")).click();
		
		
		alt=driver.switchTo().alert();
		
		Thread.sleep(5000);
		
		alt.sendKeys("dhanu");
		
		alt.accept();
		
		String EnteredText=driver.findElement(By.xpath("//p[@id=\"demo1\"]")).getText();
		
		System.out.println("EnteredText  "  +EnteredText);
		
				
	}	
}
