package pages;

import base.PageObjectBase;
import com.epam.reportportal.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static base.Constants.*;

public class LoginPage extends PageObjectBase {
    public LoginPage(WebDriver Idriver) {
        super(Idriver);
    }

    @FindBy(id = "txtLogin")
    private WebElement pageTitle;

    @FindBy(id = "txtEmail")
    private WebElement txtEmail;

    @FindBy(id = "lblEmailErr")
    private WebElement lblEmailErr;

    @FindBy(id = "txtPassword")
    private WebElement txtPassword;

    @FindBy(id = "lblPasswordErr")
    private WebElement lblPasswordErr;

    @FindBy(id = "btnLogin")
    private WebElement btnLogin;

    @Step("Verify Login screen")
    public LoginPage verifyLoginScreenIsDisplayed() {
        isDisplayed(pageTitle,30);
        Assert.assertEquals(pageTitle.getText(),LOGIN_PAGE_TITLE);
        isDisplayed(txtEmail,30);
        isDisplayed(txtPassword,30);
        isDisplayed(btnLogin,30);
        return this;
    }

    @Step("Enter email and password to login")
    public LoginPage loginWithEmailAndPassword(String email, String password){
        sendKeys(txtEmail, email);
        sendKeys(txtPassword, password);
        click(btnLogin);
        return this;
    }

    @Step("Verify error message when inputted invalid email")
    public LoginPage verify_err_msg_is_displayed_when_inputted_invalid_email() {
        isDisplayed(lblEmailErr,30);
        Assert.assertEquals(lblEmailErr.getText(),EMAIl_ERROR);
        return this;
    }

    @Step("Verify error message when inputted incorrect password")
    public LoginPage verify_err_msg_is_displayed_when_inputted_incorrect_password() {
        isDisplayed(lblPasswordErr,30);
        Assert.assertEquals(lblPasswordErr.getText(),PASSWORD_ERROR);
        return this;
    }
}
