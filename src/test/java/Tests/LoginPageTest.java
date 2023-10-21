package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
    }
    @Test
    public void verifyThatStandardUserCanLogIn(){
        String usernameStandardUser = "standard_user";
        String password = "secret_sauce";
        loginPage.inputUsername(usernameStandardUser);
        loginPage.inputPassword(password);
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }
    @Test
    public void verifyThatProblemUserCanLogIn(){
        String usernameProblemUser = "problem_user";
        String password = "secret_sauce";
        loginPage.inputUsername(usernameProblemUser);
        loginPage.inputPassword(password);
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }
    @Test
    public void verifyThatLockedOutUserCannotLogIn(){
        String usernameLockedOutUser = "locked_out_user";
        String password = "secret_sauce";
        loginPage.inputUsername(usernameLockedOutUser);
        loginPage.inputPassword(password);
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }
    @Test
    public void verifyThatPerformanceGlitchUserCanLogIn(){
        String usernamePerformanceGlitchUser = "performance_glitch_user";
        String password = "secret_sauce";
        loginPage.inputUsername(usernamePerformanceGlitchUser);
        loginPage.inputPassword(password);
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");



    }
    @Test
    public void verifyIfUserCannotLogInWhenCredentialFieldsAreLeftBlank(){
        loginPage.loginButton.click();
        String validErrorMessage =  "Username and password are required";
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
        Assert.assertTrue(loginPage.loginErrorMessage.getText().equals(validErrorMessage));
    }
    @Test
    public void verifyThatStandardUserCanLogInWithNoPassword(){
        String usernameStandardUser = "standard_user";
        loginPage.inputUsername(usernameStandardUser);
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }
    @Test
    public void verifyThatProblemUserCanLogInWithNoPassword(){
        String usernameProblemUser = "problem_user";
        loginPage.inputUsername(usernameProblemUser);
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }
    @Test
    public void verifyThatPerformanceGlitchUserCanLogInWithNoPassword(){
        String usernamePerformanceGlitchUser = "performance_glitch_user";
        loginPage.inputUsername(usernamePerformanceGlitchUser);
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }


}
