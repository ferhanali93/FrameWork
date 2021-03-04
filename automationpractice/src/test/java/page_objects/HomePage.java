package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import reporting.TestLogger;

import java.util.List;

public class HomePage {

    WebDriver driver = null;

    @FindBy(how = How.CLASS_NAME, using = "search_query")
    WebElement searchBox;

    @FindBy(how = How.LINK_TEXT, using = "Contact us")
            // contactus has how many address --> 2
    List<WebElement> contactus;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Contact")
    WebElement contactus1;

    public void clickContactUs(){

        contactus1.click();
        TestLogger.log("Clicked Contact Us Button");

       //return getPageTitle();

    }

    public String getPageTitle(){
        String pageTitle = driver.getTitle();
        TestLogger.log("Page Title: " + pageTitle);
        return pageTitle;
    }

    public void search(){
        searchBox.sendKeys("T-Shirt");
    }



}
