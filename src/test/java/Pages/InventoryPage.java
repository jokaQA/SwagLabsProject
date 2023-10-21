package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class InventoryPage extends BaseTest {
    public InventoryPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "product_sort_container")
    public WebElement sorterMenu;

    @FindBy(className = "inventory_item")
    public List<WebElement> listOfItems;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> itemPrices;

    @FindBy(id ="shopping_cart_container")
    public WebElement cartIcon;
    //--------------------------------


    public void clickOnSorterMenu(){
        sorterMenu.click();
    }

    public boolean allItemsDisplayed(){
        boolean b= true;
        for (WebElement item:listOfItems) {
            if(item.isDisplayed())
                continue;
            else
                b = false;
        }
        return b;
    }

    public boolean itemsSortedAlphabetically(List<WebElement> listOfItems){
        for (int i = 0; i < listOfItems.size()-1; i++) {
            if((listOfItems.get(i).getText().compareTo(listOfItems.get(i+1).getText()) > 0))
                return false;
        }
        return true;
    }

    public boolean itemsSortedByPrice(List<WebElement> itemPrices){
        for (int i = 0; i < itemPrices.size()-1; i++) {
            String item = itemPrices.get(i).getText().substring(1);
            String itemNext = itemPrices.get(i+1).getText().substring(1);
            if( Double.parseDouble(item)  > Double.parseDouble(itemNext) ) {
                return false;
            }
        }
        return true;
    }

    public void addAllItemsToCart(List<WebElement> listOfItems){
        for (WebElement item:listOfItems) {
            item.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).click();
        }
    }

    public boolean addToCartDisplayed(){
        boolean b = true;
        for (WebElement item:listOfItems) {
            if(item.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).isDisplayed())
                continue;
            else
                b = false;
        }
        return b;
    }

    public void removeAllItemsFromCart(List<WebElement> listOfItems){
        for (WebElement item:listOfItems) {
            item.findElement(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory")).click();
        }
    }

    public boolean removeFromCartDisplayed(){
        boolean b = true;
        for (WebElement item:listOfItems) {
            if(item.findElement(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory")).isDisplayed())
                continue;
            else
                b = false;
        }
        return b;

    }

    public boolean checkIfCartIsEmpty(){
        if(cartIcon.getText().isEmpty())
            return true;
        else
            return false;
    }

    public boolean allItemsHavePictures(List<WebElement> listOfItems){
        boolean b = true;
        for (WebElement item:listOfItems) {
            if(item.findElement(By.className("inventory_item_img")).isDisplayed())
                continue;
            else
                b = false;
        }
        return b;
    }

    public boolean allItemsHaveNames(List<WebElement> listOfItems){
        boolean b = true;
        for (WebElement item:listOfItems) {
            if(item.findElement(By.className("inventory_item_name")).isDisplayed())
                continue;
            else
                b = false;
        }
        return b;
    }

    public boolean allItemsHaveDescription(List<WebElement> listOfItems){
        boolean b = true;
        for (WebElement item:listOfItems) {
            if(item.findElement(By.className("inventory_item_desc")).isDisplayed())
                continue;
            else
                b = false;
        }
        return b;
    }

    public boolean allItemsHaveAddtocartButton(List<WebElement> listOfItems){
        boolean b = true;
        for (WebElement item:listOfItems) {
            if(item.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).isDisplayed())
                continue;
            else
                b = false;
        }
        return b;
    }

    public boolean allItemsHavePrice(List<WebElement> listOfItems){
        boolean b = true;
        for (WebElement item:listOfItems) {
            if(item.findElement(By.className("inventory_item_price")).isDisplayed())
                continue;
            else
                b = false;
        }
        return b;
    }


}

