package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.MyDriver;


public class IntroPage {
	
	
	protected static final int EXPLICIT_WAIT_TIME = 15000;

    @FindBy(xpath = ".//*[@id='query']")
    private WebElement search;
    
    @FindBy(xpath = ".//*[@id='formSearch']/button")
    private WebElement button;
    

    public void go(MyDriver myDriver) {

    	myDriver.getDriver().get("http://www.mercadolibre.com.uy/");

    }
    
    public WebElement waitElement(WebElement element, WebDriver myDriver) {
        
    	return new WebDriverWait(myDriver, EXPLICIT_WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
    
    }
    

   public void search(String arg, WebDriver myDriver){
	   
	   search.sendKeys(arg);
	   
	   //WebElement e = waitElement(this.button,myDriver);
	   //e.click();
	   button.click();
	   
	    
	   
   }
   
   
   
   
   

}