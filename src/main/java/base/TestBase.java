package base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;  
	public static Properties prop;
		
	
	public void init() {
			
		prop = new Properties();
			
     	try {
			FileInputStream file = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Moven_Project\\Config,properties");
			
			prop.load(file);
			
			}
			
     	catch(Exception e) {
				e.printStackTrace();
			}
			
			
    	if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "D:\\Java Software\\chromedriver_win32 (1)\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
				}
				

		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "D:\\Java Software\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		    WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
				}
				
				
		else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
		//	System.setProperty("webdriver.edge.driver", "D:\\Java Software\\edgedriver_win64\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
				}
		
        	driver.get("https://classic.freecrm.com/index.html");
        	
             driver.manage().deleteAllCookies();
       //      driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
             driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
             
 
}
}
