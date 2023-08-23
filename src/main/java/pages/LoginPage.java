package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.Util;

public class LoginPage extends TestBase {
	
	// Page Factory in constructor :
	
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		
	// Web Elements repository :

	  // for Login	
		@FindBy(name = "username")
		WebElement usernameTxtBx;
		
		@FindBy(name = "password")
		WebElement passwordTxtBx;
		
		@FindBy(xpath = "//*[@value='Login']")
		WebElement loginBtn;
		
	  // for Forgot Password Link 
		 @FindBy(linkText = "Forgot Password?")
		 WebElement forgotPass;
		 
		
	// Actions :	
		
		public HomePage login() {
			System.out.println("Current Page URL is : " + driver.getCurrentUrl());     // to print current page URL. 
			usernameTxtBx.sendKeys("Speedway2023");
			passwordTxtBx.sendKeys("Speedway@2023");
	//		Util.explicitWait(loginBtn, 10);          // Explicit Wait From Util class
			loginBtn.click();
			
			return new HomePage();
		}
		
		
		public void forgotPasswordLink() {
			forgotPass.click();
		}


}
