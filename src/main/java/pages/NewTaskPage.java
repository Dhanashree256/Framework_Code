package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.Util;

public class NewTaskPage extends TestBase{

//  Page factory
	public NewTaskPage() {
		PageFactory.initElements(driver, this);
	}


// Web Elements

	@FindBy(id = "title")
	WebElement titleTxt;

	@FindBy(name = "task_type")
	WebElement typeDrop;

	@FindBy(name = "priority")
	WebElement prorityDrop;

  // Key Contact Lookup
//	@FindBy(name = "contact_lookup")
//	WebElement keyContact ;

	@FindBy(xpath = "(//input[@value='Lookup'])[3]")
	WebElement conLookupBtn;

	@FindBy(id = "search")
	WebElement conLookupSearchTextBox;    // send key 'su'

	@FindBy(css = "[value = 'Search']")
	WebElement conLookupSearchBtn;

	@FindBy(xpath = "(//a[text()='sunisha Gujarathi'])[1]")
	WebElement conLookupSearchValue;

  // Key Company Lookup
//	@FindBy(name = "contact_lookup")
//	WebElement keyCompany ;

	@FindBy(xpath = "(//input[@value='Lookup'])[4]")
	WebElement compLookupBtn;

	@FindBy(id = "search")
	WebElement compLookupSearchTextBox;    // send key 'inf'

	@FindBy(xpath = "//*[@value ='Search']")
	WebElement compLookupSearchBtn;
	
    @FindBy(xpath = "//*[text()='Infosys']")
	WebElement compLookupSearchValue;

	
	
// Actions
	
	public void newTask() {
		titleTxt.sendKeys("Sumoriy");
		Util.selectMethod(typeDrop, "Meeting");
		Util.selectMethod(prorityDrop, "High");
		
		conLookupBtn.click();
		Util.switchToChildWindow();
		conLookupSearchTextBox.sendKeys("su");
		conLookupSearchBtn.click();
		conLookupSearchValue.click();
		Util.switchToParentWindow();
		
		Util.switchToFrame();
		
		compLookupBtn.click();
		Util.switchToChildWindow();
		compLookupSearchTextBox.sendKeys("info");
		compLookupSearchTextBox.sendKeys(Keys.ENTER);
		//compLookupSearchValue.click();
		Util.switchToParentWindow();
		
		Util.switchToFrame();
		
	}
	
	
	
	
	
	

}
