package pages;

import base.PageObjectBase;
import com.epam.reportportal.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static base.Constants.*;

public class WelcomePage extends PageObjectBase {
    public WelcomePage(WebDriver Idriver) {
        super(Idriver);
    }

    @FindBy(id = "txtWelcome")
    private WebElement pageTitle;

    @FindBy(id = "lblLoggedinSuccessfull")
    private WebElement lblLoggedinSuccessful;

    @FindBy(id = "btnMyProfile")
    private WebElement btnMyProfile;

    @Step("Verify Welcome screen")
    public WelcomePage verifyWelcomeScreenIsDisplayed() {
        isDisplayed(pageTitle,30);
        Assert.assertEquals(pageTitle.getText(),WElCOME_PAGE_TITLE);
        isDisplayed(lblLoggedinSuccessful,30);
        Assert.assertEquals(lblLoggedinSuccessful.getText(),LOGGED_IN_SUCCESSFULLY_MSG);
        isDisplayed(btnMyProfile,30);
        return this;
    }
}
