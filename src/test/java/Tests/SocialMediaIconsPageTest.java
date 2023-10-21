package Tests;

import Base.BaseTest;
import Pages.SocialMediaIconsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SocialMediaIconsPageTest extends BaseTest {


    SocialMediaIconsPage socialMediaIconsPage = new SocialMediaIconsPage();
    @BeforeMethod
    public void loginSetup(){
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.loginButton.click();
    }

    @Test
    public void tweeterIcon(){
        WebElement tweeter = driver.findElement(By.cssSelector("body > footer > ul > li.social_twitter"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tweeter);
        Assert.assertTrue(socialMediaIconsPage.tweeter.isDisplayed());
        socialMediaIconsPage.tweeter.click();
    }

    @Test
    public void facebookIcon(){

        Assert.assertTrue(socialMediaIconsPage.facebook.isDisplayed());
        socialMediaIconsPage.facebook.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/saucelabs/");

    }

    @Test
    public void linkedInIcon(){

        Assert.assertTrue(socialMediaIconsPage.linkedIn.isDisplayed());
        socialMediaIconsPage.linkedIn.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/company/sauce-labs/");

    }
}
