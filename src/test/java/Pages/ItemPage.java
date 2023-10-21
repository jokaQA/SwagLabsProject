package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ItemPage extends BaseTest {
    public ItemPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css=".inventory_details_back_button")
    public WebElement backButton;

    @FindBy(css = ".btn_primary.btn_inventory")
    public WebElement addToCartButton;

    @FindBy(css = ".btn_secondary.btn_inventory")
    public WebElement removeFromCart;

    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCartButton;

    public void clickOnAddToCart(){
        addToCartButton.click();
    }
    public void clickOnRemoveFromCart(){
        removeFromCart.click();
    }
    public void clickOnBackButton(){
        backButton.click();
    }

}
