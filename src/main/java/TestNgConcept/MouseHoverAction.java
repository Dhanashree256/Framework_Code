package TestNgConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class MouseHoverAction {

	static WebDriver driver;
	
	public static void main(String args[])
	{
		
		System.setProperty("WebDriver.chrome.Driver", "C:\\\\Users\\\\shyam\\\\eclipse-workspace\\\\Framework_Code\\\\chromedriver.exe");
		
		driver =new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		
		driver.findElement(By.xpath("(//p[@class=\"fc-button-label\"])[1]")).click();
		
		WebElement switchto =driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul/li[4]/a"));
		
		Actions act =new Actions(driver);
		
		act.moveToElement(switchto).build().perform();
		
		driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul/li[4]/ul/li[1]/a")).click();
		
		/*
		 * for drag and drop mouse houver action 
		 * first enter in frame ,store draggable element in webelement and store droppeble element 
		 * create actions object and use method act.clickandHold(sourceElement).release(destinationElement).build().perform();
		 *or act.draganddrop(sourceelement,destinationelement).build().perform();
		 **/
	}
	
}
