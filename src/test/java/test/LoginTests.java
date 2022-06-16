package test;

import base.Constants;
import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WelcomePage;
import pages.LoginPage;

import static base.Constants.*;

public class LoginTests extends TestBase {
    private LoginPage loginPage;
    private WelcomePage welcomePage;

    @BeforeMethod
    public void initializePage()  {
        loginPage = new LoginPage(super.getDriver());
        welcomePage = new WelcomePage(super.getDriver());
    }

    @Test(description ="User cannot login when entering a wrong email address")
    public void TC001_user_cannot_login_when_entering_a_wrong_email_address() {
        loginPage.openWebsite(Constants.LOGIN_URL);
        loginPage.verifyLoginScreenIsDisplayed()
                 .loginWithEmailAndPassword(NON_EXISTING_EMAIL,PASSWORD)
                 .verify_err_msg_is_displayed_when_inputted_invalid_email()
                 .loginWithEmailAndPassword(INVALID_EMAIL,PASSWORD)
                 .verify_err_msg_is_displayed_when_inputted_invalid_email()
                 .loginWithEmailAndPassword(INVALID_EMAIL,INVALID_PASSWORD)
                 .verify_err_msg_is_displayed_when_inputted_invalid_email();
    }

    @Test(description ="User cannot login when entering a wrong email address")
    public void TC002_user_cannot_login_when_entering_a_wrong_password() {
        loginPage.openWebsite(Constants.LOGIN_URL);
        loginPage.verifyLoginScreenIsDisplayed()
                .loginWithEmailAndPassword(EMAIL_ADDRESS,INVALID_PASSWORD)
                .verify_err_msg_is_displayed_when_inputted_incorrect_password();
    }

    @Test(description ="User can login successfully")
    public void TC003_user_can_login_successfully_when_entering_valid_email_and_password() {
        loginPage.openWebsite(Constants.LOGIN_URL);
        loginPage.verifyLoginScreenIsDisplayed()
                 .loginWithEmailAndPassword(EMAIL_ADDRESS,PASSWORD);
        welcomePage.verifyWelcomeScreenIsDisplayed();
    }
}
