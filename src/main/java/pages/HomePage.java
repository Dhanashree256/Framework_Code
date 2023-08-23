package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.Util;

public class HomePage extends TestBase {
	
// Page Factory
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
// web Element repository
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutLink;
	
	@FindBy(xpath = "//td[contains(text(),'User:')]")
	WebElement userTxt;
	
	@FindBy(xpath = "//a[(text()='Companies')]")
	WebElement companiesLink;
	@FindBy(xpath = "//*[(text()='New Company')]")
	WebElement newCompanyLink;
	
	@FindBy(xpath = "//*[text()='Contacts']")
	WebElement contacts;
	@FindBy(xpath = "//*[text()='New Contact']")
	WebElement newContact;
	

	@FindBy(xpath = "//a[text()='Deals']")
	WebElement deals;
	@FindBy(xpath = "//a[text()='New Deal']")
	WebElement newDeal;
	
	@FindBy(xpath = "//a[@title='Tasks']")
	WebElement tasks;
	@FindBy(css = "[title='New Task']")
	WebElement newTask;
	
	
	
	
// Action	
	public boolean checkLogout() {
	   Util.switchToFrame();
	   return logoutLink.isDisplayed();
	}
	
	public boolean checkUserText() {
	    Util.switchToFrame();
		return  userTxt.isDisplayed();
	}
	
	public NewCompanyPage clickOnCompanies() {
		Util.switchToFrame();	
		Util.mouseAction(companiesLink);
		newCompanyLink.click(); 
		return new NewCompanyPage();
	}
	
	public NewContactPage clickOnContacts() {
		Util.switchToFrame();
		Util.mouseAction(contacts);
		newContact.click();
		return new NewContactPage();
	}
	
	public void clickOnDeals() {
		Util.switchToFrame();
		Util.mouseAction(deals);
		newDeal.click();
	}
	
	public void clickOnTasks() { 
		Util.switchToFrame();
		Util.mouseAction(tasks);
		newTask.click();
	}
	
}
