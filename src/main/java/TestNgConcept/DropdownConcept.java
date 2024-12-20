package TestNgConcept;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//we can use select method if WebElements are lies under select tag 

public class DropdownConcept {

	static WebDriver driver;
	
	@BeforeMethod
	public static void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shyam\\eclipse-workspace\\Framework_Code\\chromedriver.exe");	
		
		driver =new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.get("https://www.google.com");
	}
		
	@Test	
		public void selectsatticdropdown()
		{
		WebElement SkillsSelect=driver.findElement(By.xpath("//select[contains(@class,'form-control')][1]"));
		
		Select se =new Select(SkillsSelect);
		
		//se.selectByIndex(0);
		
		se.selectByVisibleText("Java");
		
		//se.selectByValue("API's");
		
	}
	@Test
		public void dynamicDropdown() throws InterruptedException
	{
		driver.findElement(By.xpath("//textarea[@title=\"Search\"]")).sendKeys("Java");
		
		Thread.sleep(5000);
	
		List<WebElement> googleSearch =driver.findElements(By.xpath("//div[@class=\"ClJ9Yb\"]"));
		
		System.out.println(googleSearch.size());
		
		for(WebElement element :googleSearch)
		{
			String ElementValue=element.getText();
			
			System.out.println("Element value is" +ElementValue);
			
			if(ElementValue.equalsIgnoreCase("java 21"))
				
			{
				element.click();
				break;
				
			}
			
		}
		
	}

	public static void dropDownWithListElement()
		{
		
			driver.findElement(By.xpath("//div[@id=\"msdd\"]")).click();
			
			List <WebElement> languages=driver.findElements(By.xpath("//li[@class=\"ng-scope\"]"));
			
			System.out.println("total present elements" +languages.size());
			
			for(int i=0 ;i <=languages.size();i++)
			{
				String language=(languages.get(i).getText());
				System.out.println(language);
			
				if (language.equalsIgnoreCase("Hindi") || (language.equalsIgnoreCase("English")))
						
				{
					languages.get(i).click();
					
				}
							
				
			}
			
		}
}
