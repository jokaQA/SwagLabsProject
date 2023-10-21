package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseTest{
    public CartPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[.='CHECKOUT']")
    public WebElement checkoutButton;

    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(id = "postal-code")
    public WebElement zipCodeField;

    @FindBy(xpath = "//input[@value='CONTINUE']")
    public WebElement continueButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@class='subheader']")
    public WebElement checkoutOverview;

    @FindBy(xpath = "//a[.='FINISH']")
    public WebElement finishButton;


    @FindBy(xpath = "//a[.='Continue Shopping']")
    public WebElement continueToShoppingButton;

    @FindBy(xpath = "//div[.='Products']")
    public WebElement productPageText;

}
