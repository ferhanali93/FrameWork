package pageobjectstests;

import browserdriver.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;

import java.awt.print.PageFormat;

public class HomePageTest extends BrowserDriver {
    HomePage homePage = null;

    @BeforeMethod
    public void initializeElements(){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }
    @Test
    public void searchTest(){
        homePage.search();
    }

//    @Test(invocationCount = 0)
//    public void womenDressDetailsTest(){
//        homePage.womenDressDetails();
//    }

}

