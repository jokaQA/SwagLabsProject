package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest{
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="user-name")
    public WebElement usernameField;

    @FindBy(id="password")
    public WebElement passwordField;

    @FindBy(id="login-button")
    public WebElement loginButton;

    @FindBy(css = "#login_button_container>div>form>h3")
    public WebElement loginErrorMessage;

    public void inputUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void inputPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }


}
