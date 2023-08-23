package utility;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class Util extends TestBase {
	
	static String pWin;
	
	public static void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void mouseAction(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
	}
	
	public static void explicitWait(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));		
	}
	
	public static void selectMethod(WebElement element, String value) {
		Select se = new Select(element);
		se.selectByVisibleText(value);
	}
	
	
	public static void switchToChildWindow() {
		Util.pWin = driver.getWindowHandle();
		
		Set<String> cWin = driver.getWindowHandles();
		  for(String win : cWin) 
		  {
			  if(! Util.pWin.equals(cWin))
			  {
				  driver.switchTo().window(win);
			  }
		  }
		  
	}
		  
		
	public static void switchToParentWindow() {
			driver.switchTo().window(Util.pWin);
		}
		
}
	


