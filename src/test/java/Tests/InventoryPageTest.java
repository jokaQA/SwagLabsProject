package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.openqa.selenium.Keys.ENTER;

public class InventoryPageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        String usernameStandardUser = "standard_user";
        String password = "secret_sauce";
        loginPage.inputUsername(usernameStandardUser);
        loginPage.inputPassword(password);
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void verifySortingItemsByName(){
        inventoryPage.clickOnSorterMenu();
        inventoryPage.sorterMenu.sendKeys("Name (A to Z)");
        inventoryPage.sorterMenu.sendKeys(ENTER);
        Assert.assertTrue(inventoryPage.itemsSortedAlphabetically(inventoryPage.listOfItems));

        inventoryPage.clickOnSorterMenu();
        inventoryPage.sorterMenu.sendKeys("Name (Z to A)");
        inventoryPage.sorterMenu.sendKeys(ENTER);
        Assert.assertFalse(inventoryPage.itemsSortedAlphabetically(inventoryPage.listOfItems));
    }

    @Test
    public void verifySortingItemsByPrice(){
        inventoryPage.clickOnSorterMenu();
        inventoryPage.sorterMenu.sendKeys("Price (low to high)");
        inventoryPage.sorterMenu.sendKeys(ENTER);
        Assert.assertTrue(inventoryPage.itemsSortedByPrice(inventoryPage.itemPrices));

        inventoryPage.clickOnSorterMenu();
        inventoryPage.sorterMenu.sendKeys("Price (high to low)");
        inventoryPage.sorterMenu.sendKeys(ENTER);
        Assert.assertFalse(inventoryPage.itemsSortedByPrice(inventoryPage.itemPrices));
    }

    @Test
    public void verifyUserCanAddRemoveAllItemsToCart(){
        //System.out.println(inventoryPage.cartIcon.getText());
        Assert.assertTrue(inventoryPage.checkIfCartIsEmpty());
        inventoryPage.addAllItemsToCart(inventoryPage.listOfItems);
        Assert.assertEquals(String.valueOf(inventoryPage.listOfItems.size()), inventoryPage.cartIcon.getText());
        Assert.assertTrue(inventoryPage.removeFromCartDisplayed());

        inventoryPage.removeAllItemsFromCart(inventoryPage.listOfItems);
        Assert.assertTrue(inventoryPage.checkIfCartIsEmpty());
        Assert.assertTrue(inventoryPage.addToCartDisplayed());
    }

    @Test
    public void verifyUserCanAddAllItemsToCart(){
        Assert.assertTrue(inventoryPage.checkIfCartIsEmpty());
        inventoryPage.addAllItemsToCart(inventoryPage.listOfItems);
        Assert.assertEquals(String.valueOf(inventoryPage.listOfItems.size()), inventoryPage.cartIcon.getText());
        Assert.assertTrue(inventoryPage.removeFromCartDisplayed());
    }

    @Test
    public void verifyUserCanRemoveAllItemsFromCart(){
        if(inventoryPage.checkIfCartIsEmpty())
            System.out.println("Cart is empty, nothing to remove");
        else
            inventoryPage.removeAllItemsFromCart(inventoryPage.listOfItems);
        Assert.assertTrue(inventoryPage.checkIfCartIsEmpty());
        Assert.assertTrue(inventoryPage.addToCartDisplayed());
    }

    @Test
    public void verifyAllItemsAreProperlyDisplayed(){
        Assert.assertTrue(inventoryPage.allItemsHavePictures(inventoryPage.listOfItems));
        Assert.assertTrue(inventoryPage.allItemsHaveNames(inventoryPage.listOfItems));
        Assert.assertTrue(inventoryPage.allItemsHaveDescription(inventoryPage.listOfItems));
        Assert.assertTrue(inventoryPage.allItemsHaveAddtocartButton(inventoryPage.listOfItems));
        Assert.assertTrue(inventoryPage.allItemsHavePrice(inventoryPage.listOfItems));
    }

}
