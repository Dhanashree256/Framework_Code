package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.Util;

public class NewCompanyPage extends TestBase {
	
// page factory
	public NewCompanyPage() {
		PageFactory.initElements(driver, this);
	}
	
	
// web elements
	@FindBy(id = "company_name")
	WebElement companyName;
	
	@FindBy(css = "[name='industry']")
	WebElement industry;
	
	@FindBy(name = "annual_revenue")
	WebElement aRevenue;
	
	@FindBy(name = "status")
	WebElement status;
	
	@FindBy(xpath = "//*[@name='category']")
	WebElement category;
	
	@FindBy(css = "[name='priority']")
	WebElement priority;
	
	@FindBy(name = "source")
	WebElement source;
	
	@FindBy(id = "vat_number")
	WebElement vtNumber;
	
	@FindBy(name = "phone")
	WebElement phoneNo;
	
	@FindBy(css = "#fax")
	WebElement fax;
	
	@FindBy(id = "website")
	WebElement website;
	
	@FindBy(css = "[id = email]")
	WebElement email;

	
	@FindBy(css = "[value='Lookup']")
	WebElement parentCompanyLookup;
	
	@FindBy(id = "search")
	WebElement lookupSearchBox;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement lookupSumbitBtn;
	
	@FindBy(xpath = "//a[text()='Infosys']")
	WebElement lookupSelectValue;
	

	
// actions
	public void newCompany(String CN, String ind, String rev) {
		companyName.sendKeys(CN);
		industry.sendKeys(ind);
		aRevenue.sendKeys(rev);
		
		Util.selectMethod(status, "Active");
		Util.selectMethod(category, "Client");
		Util.selectMethod(priority, "High");
		Util.selectMethod(source, "Email");
		
		vtNumber.sendKeys("327888822");
		phoneNo.sendKeys("+91-9988776655");
		fax.sendKeys("342jgjgg");
		website.sendKeys("https://abcd.com");
		email.sendKeys("abcd1@gmail.com");
		
		parentCompanyLookup.click();
		Util.switchToChildWindow();
		lookupSearchBox.sendKeys("i");
		lookupSumbitBtn.click();
		lookupSelectValue.click();
		Util.switchToParentWindow();
	}
	
	
	
	
	
	
	
}
