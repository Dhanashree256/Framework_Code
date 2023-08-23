package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.Util;

public class NewContactPage extends TestBase {

// page factory
	
	public NewContactPage() {
		PageFactory.initElements(driver,  this);
	}
	
	
	
// Web Elements
	
	@FindBy(name = "title")
	WebElement titleTBx;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(name = "middle_initial")
	WebElement middleIni;
	
	@FindBy(xpath = "//input[@id='surname']")
	WebElement lastName;
	
// static drop-down 		
	@FindBy(name = "suffix")
	WebElement suffixTBx;

// text box	
	@FindBy(css = "[name='nickname']")
	WebElement nickName;
	
// lookup 1	
	@FindBy(xpath = "(//input[@value='Lookup'])[1]")
	WebElement companyLookup;
		
	@FindBy(id = "search")
	WebElement comSearchBox;
		
	@FindBy(css = "[value='Search']")
	WebElement comSubmitBtn;
		
	@FindBy(xpath = "//a[text()='Infosys']")
	WebElement comSelectValue;
		
// Text box	
	@FindBy(css = "#company_position")
	WebElement position;
	
	@FindBy(name = "department")
	WebElement departmentName;
	
// lookup 2	
	@FindBy(xpath = "(//input[@value='Lookup'])[2]")
	WebElement supervisorLookup;
		
	@FindBy(css = "#search")
	WebElement superSearchBox;
		
	@FindBy(css = "[type='submit']")
	WebElement superSubmitBtn;
		
	@FindBy(xpath = "(//a[text()='Sushant Gohil'])[1]")
	WebElement superSelectValue;
	
	
	@FindBy(name ="city")
	WebElement cityPlace;
	
	@FindBy(name ="country")
	WebElement country; 

// static drop-down 	
	@FindBy(css = "[name='category']")
	WebElement categoryTBx;
	
	@FindBy(xpath = "//select[@name='status']")
	WebElement statusTBx;

// text box
	@FindBy(css = "[id='phone']")
	WebElement phoneNo;
	
	@FindBy(id = "mobile")
	WebElement mob;
	
	@FindBy(name = "home_phone")
	WebElement hmPhone;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	
	@FindBy(id = "im_id")
	WebElement mesId;
	
	@FindBy(xpath ="//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	
	
// actions
	
	public void newContactPage(String fName, String lName, String department, String city, String coun) {
		Util.selectMethod(titleTBx, "Mr.");
		
		firstName.sendKeys(fName);
		middleIni.sendKeys("D.");
		lastName.sendKeys(lName);
		
		Util.selectMethod(suffixTBx, "III");
		
		nickName.sendKeys("Viju");
		
	// lookup 1	
		companyLookup.click();
		Util.switchToChildWindow();
		comSearchBox.sendKeys("inf");
		comSubmitBtn.click();
     	comSelectValue.click();
		Util.switchToParentWindow();		
	    Util.switchToFrame();	
	
	    position.sendKeys("Software Engineear");
		departmentName.sendKeys(department); 
	    
    // lookup 2
		supervisorLookup.click();
		Util.switchToChildWindow();
		superSearchBox.sendKeys("su");
		superSubmitBtn.click();
		superSelectValue.click();
		Util.switchToParentWindow();	 
	    Util.switchToFrame();	
	    
	    cityPlace.sendKeys(city);
	    country.sendKeys(coun);
		
	    Util.selectMethod(categoryTBx, "Lead");
	    
		Util.selectMethod(statusTBx, "New");
	    
		phoneNo.sendKeys("0192-776677");
		mob.sendKeys("9889876753");
		hmPhone.sendKeys("0781-33222");
		email.sendKeys("vij1@gmail.com");
		mesId.sendKeys("ST-124");
		
		saveBtn.click();
	}
	
	
	
	
	
}
