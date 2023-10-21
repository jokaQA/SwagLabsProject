package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ItemPageTest extends BaseTest {
@BeforeMethod
    public void pageSetup(){
    driver.navigate().to("https://www.saucedemo.com/v1/index.html");
    String username="standard_user";
    String password="secret_sauce";
    loginPage.usernameField.sendKeys(username);
    loginPage.passwordField.sendKeys(password);
    loginPage.loginButton.click();
}
@Test
    public void addAndRemoveItemsFromInventoryPage(){
    //udjes na svaki item sa inventory page-a, add to cart, pa remove.
    driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
    int x = 1;
    for (int i = 0; i < inventoryPage.listOfItems.size(); i++) {
        inventoryPage.listOfItems.get(i).findElement(By.className("inventory_item_img")).click();
        //Thread.sleep(2000);
        itemPage.clickOnAddToCart();
        Assert.assertEquals(String.valueOf(itemPage.shoppingCartButton.getText()), String.valueOf(x));
        Assert.assertTrue(itemPage.removeFromCart.isDisplayed());

        itemPage.clickOnRemoveFromCart();
        Assert.assertTrue(itemPage.addToCartButton.isDisplayed());
        Assert.assertEquals(String.valueOf(itemPage.shoppingCartButton.getText()), "");

        itemPage.clickOnBackButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }

}

}
