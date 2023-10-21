package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    @BeforeMethod
    public void loginSetup(){
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.loginButton.click();

    }

    @Test
    public void createValidOrderWithEmptyCart(){
        String firstName = "Jovana";
        String lastName = "Pantovic";
        String zipcode = "11000";

        itemPage.shoppingCartButton.click();
        cartPage.checkoutButton.click();
        cartPage.firstNameField.sendKeys(firstName);
        cartPage.lastNameField.sendKeys(lastName);
        cartPage.zipCodeField.sendKeys(zipcode); // nije htelo kao int



        Assert.assertEquals((cartPage.firstNameField.getAttribute("value")), firstName, "Name has been changed!");



        cartPage.continueButton.click();

        Assert.assertTrue(cartPage.checkoutOverview.isDisplayed());

        cartPage.finishButton.click();

        Assert.assertTrue(cartPage.checkoutOverview.isDisplayed(),"Error message is not displayed");



    }

    @Test
    public void withoutFirstName(){
        String lastName = "Pantovic";
        String zipcode = "11000";

        itemPage.addToCartButton.click();
        itemPage.shoppingCartButton.click();
        cartPage.checkoutButton.click();

        cartPage.lastNameField.sendKeys(lastName);
        cartPage.zipCodeField.sendKeys(zipcode);
        cartPage.continueButton.click();

        Assert.assertTrue(cartPage.errorMessage.isDisplayed(),"Error message is not displayed");

    }

    @Test
    public void withNumbersInFirstname(){
        String firstName = "11231313";
        String lastName = "Pantovic";
        String zipcode = "11000";

        itemPage.addToCartButton.click();
        itemPage.shoppingCartButton.click();
        cartPage.checkoutButton.click();

        cartPage.firstNameField.sendKeys(firstName);
        cartPage.lastNameField.sendKeys(lastName);
        cartPage.zipCodeField.sendKeys(zipcode);

        cartPage.continueButton.click();

        Assert.assertTrue(cartPage.checkoutOverview.isDisplayed(),"Error message is not displayed");

    }
    @Test
    public void withSymbolsInFirstname(){
        String firstName = "!!!/";
        String lastName = "Pantovic";
        String zipcode = "11000";

        itemPage.addToCartButton.click();
        itemPage.shoppingCartButton.click();
        cartPage.checkoutButton.click();

        cartPage.firstNameField.sendKeys(firstName);
        cartPage.lastNameField.sendKeys(lastName);
        cartPage.zipCodeField.sendKeys(zipcode);

        cartPage.continueButton.click();

        Assert.assertTrue(cartPage.checkoutOverview.isDisplayed(),"Error message is not displayed");

    }


    @Test
    public void withoutLastName(){

        String firstName = "Jovana";
        String zipcode = "11000";

        itemPage.addToCartButton.click();
        itemPage.shoppingCartButton.click();
        cartPage.checkoutButton.click();

        cartPage.lastNameField.sendKeys(firstName);
        cartPage.zipCodeField.sendKeys(zipcode);
        cartPage.continueButton.click();

        Assert.assertTrue(cartPage.checkoutOverview.isDisplayed(),"Error message is not displayed");

    }

    @Test
    public void withNumbersInLastName(){
        String firstName = "Jovana";
        String lastName = "487484";
        String zipcode = "11000";

        itemPage.addToCartButton.click();
        itemPage.shoppingCartButton.click();
        cartPage.checkoutButton.click();

        cartPage.firstNameField.sendKeys(firstName);
        cartPage.lastNameField.sendKeys(lastName);
        cartPage.zipCodeField.sendKeys(zipcode);

        cartPage.continueButton.click();

        Assert.assertTrue(cartPage.checkoutOverview.isDisplayed(),"Error message is not displayed");

    }
    @Test
    public void withSymbolsInLastname(){
        String firstName = "Jovana";
        String lastName = "//!!";
        String zipcode = "11000";

        itemPage.addToCartButton.click();
        itemPage.shoppingCartButton.click();
        cartPage.checkoutButton.click();

        cartPage.firstNameField.sendKeys(firstName);
        cartPage.lastNameField.sendKeys(lastName);
        cartPage.zipCodeField.sendKeys(zipcode);

        cartPage.continueButton.click();

        Assert.assertTrue(cartPage.checkoutOverview.isDisplayed(),"Error message is not displayed");
    }

    @Test
    public void withoutZipCode(){

        String firstName = "Jovana";
        String lastName = "Pantovic";

        itemPage.addToCartButton.click();
        itemPage.shoppingCartButton.click();
        cartPage.checkoutButton.click();

        cartPage.firstNameField.sendKeys(firstName);
        cartPage.lastNameField.sendKeys(lastName);

        cartPage.continueButton.click();

        Assert.assertTrue(cartPage.errorMessage.isDisplayed(),"Error message is not displayed");

    }


    @Test
    public void continueShopButton(){

        itemPage.shoppingCartButton.click();

        cartPage.continueToShoppingButton.click();

        Assert.assertTrue(cartPage.productPageText.isDisplayed());


    }



}
