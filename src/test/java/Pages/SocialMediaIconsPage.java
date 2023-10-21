package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SocialMediaIconsPage extends BaseTest {

        public SocialMediaIconsPage(){
            PageFactory.initElements(driver, this);
        }

        @FindBy(css = "body > footer > ul > li.social_twitter")
        public WebElement tweeter;

        @FindBy(css = "body > footer > ul > li.social_facebook")
        public WebElement facebook;

        @FindBy(css = "body > footer > ul > li.social_linkedin")
        public WebElement linkedIn;


    }
