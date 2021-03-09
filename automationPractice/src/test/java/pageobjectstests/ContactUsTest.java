package pageobjectstests;

import browserdriver.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ContactUsPage;
import pageobjects.HomePage;


public class ContactUsTest extends BrowserDriver {
    HomePage homePage = null;
    ContactUsPage contactUsPage = null;

    @BeforeMethod
    public void initializeElements(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
    }

    @Test
    public void sendAMessageTest()  {
        homePage.clickContactUs();
        contactUsPage.writeEmailValue("junk@kunk.com");
        contactUsPage.sendText("Provide me some junk information!!!");
        contactUsPage.clickSubmitButton();
        String actualErrorMessage = contactUsPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "There is 1 error");
        System.out.println("Test Passed......");

    }
}
