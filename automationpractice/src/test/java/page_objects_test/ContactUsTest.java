package page_objects_test;

import browserdriver.BrowserDriver;
import dataprovider.DBDataProvider;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.ContactUsPage;
import page_objects.HomePage;

import java.io.IOException;
import java.sql.SQLException;

public class ContactUsTest extends BrowserDriver {
    HomePage homePage = null;
    ContactUsPage contactUsPage = null;

    @BeforeMethod
    public void initializeElements(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
    }

    @DataProvider
    public Object[][] dataProvider() throws IOException, SQLException {
       Object[][] data = DBDataProvider.dataSupplier();
       return data;
    }

    @Test(dataProvider = "dataProvider")
    public void sendAMessageTest(String email, String message) throws InterruptedException {
        homePage.clickContactUs();
        contactUsPage.writeEmailValue(email);
        contactUsPage.sendText(message);
        contactUsPage.clickSubmitButton();
        String actualErrorMessage = contactUsPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "There is 1 error");
        System.out.println("Test Passed......");

    }
}
