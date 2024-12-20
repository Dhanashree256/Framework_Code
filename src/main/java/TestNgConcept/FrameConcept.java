package TestNgConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameConcept {
	
 private static final String Ignore = null;
static	WebDriver driver;
	
 @BeforeMethod
	public void init()
	{
		
		System.setProperty("WebDriver.chrome.Driver", "C:\\\\Users\\\\shyam\\\\eclipse-workspace\\\\Framework_Code\\\\chromedriver.exe");
		
		driver =new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Frames.html");
		
		
		driver.findElement(By.xpath("(//p[@class=\"fc-button-label\"])[1]")).click();
		
	}
	
	@Test(enabled=false)
	public void TextinsideFrame()
	{
		
		driver.switchTo().frame("SingleFrame");
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("text");
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[text()=\"Practice Site\"]")).click();
		
		System.out.println("test passed");

	}

	@Test
	
	public void NestedFrame()

	{
		//WebElement parentframe=driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[2]/div[2]/iframe"));
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		
		//WebElement Frame= driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[2]/div[2]/iframe"));
		
		driver.switchTo().frame(1);
		
		driver.switchTo().frame(2);
		
		driver.findElement(By.xpath("/html/body/section/div/div/iframe")).sendKeys("Texxt");
		
		String FrameText =driver.findElement(By.xpath("/html/body/section/div/div/iframe")).getText();
		
		System.out.println(FrameText);
		
		
	}
}
