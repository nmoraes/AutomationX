package core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

public class MyDriver {

    private WebDriver driver;
    
    private static String sauceUser = "nicomoraes";
    private static String sauceKey = "1aa978cf-7d92-4b7e-a1a6-ab5611a7d7fc";

    public WebDriver getDriver() {

    	return driver;
    }

    
    private enum browsers {
    	FIREFOX, SOUCELABS, CHROME
        };
    
    public void tearUp(ITestContext context) {
	
    	String browser = context.getCurrentXmlTest().getParameter("selenium.browser");
    	switch (browsers.valueOf(browser)) {

    	case FIREFOX:
    	    driver = new FirefoxDriver();
    	    break;
    	    
    	    
    	case CHROME:
    	    System.setProperty("webdriver.chrome.driver","/Users/nimoraes/Desktop/chromedriver");
    	    driver = new ChromeDriver();
    	    break;
    	    

    	case SOUCELABS:

    		DesiredCapabilities caps = DesiredCapabilities.firefox();
    	    caps.setCapability("version", "17");
    	    caps.setCapability("platform", "Windows 7");
    	    caps.setCapability("idle-timeout", "180");

    	    
    	    try {
    	    	
    			driver = new RemoteWebDriver(new URL("http://" + sauceUser + ":" + sauceKey + "@ondemand.saucelabs.com:80/wd/hub"),caps);
        	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    			
    			
    		} catch (MalformedURLException e) {
    			
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	    	
    		break;

    	default:
    	    break;

    	}	
    	
    }
	
	
    
    public void tearDown() {
    	driver.close();
    	driver.quit();

    }
    
    //user 		nicomoraes 
    //key		1aa978cf-7d92-4b7e-a1a6-ab5611a7d7fc


}