package test;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import core.MyDriver;
import pages.IntroPage;

public class MercadoLibreSearchTest {

	

    private MyDriver myDriver = new MyDriver();

    @BeforeSuite
    private void tearUp(ITestContext context) {

	myDriver.tearUp(context);
    }

    @AfterSuite
    private void tearDown() {

	myDriver.tearDown();
    }

    @Test
    @Parameters({ "search" })
    public void testSearch(String search) throws InterruptedException {

	IntroPage intro = PageFactory.initElements(myDriver.getDriver(), IntroPage.class);
	intro.go(myDriver);
	intro.search(search,myDriver.getDriver());
	
	 Assert.assertTrue(true);
	

    }
	
	
	
}