package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;


public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    //public ExcelReader excelReader;
    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public ItemPage itemPage;
    public SocialMediaIconsPage socialMediaIconsPage;
    public CartPage cartPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        //excelReader = new ExcelReader("C:\\Users\\Administrator\\IdeaProjects\\SwagLabsProject\\src\\test\\java\\Base\\datotekaProjekat.xlsx");


        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        itemPage = new ItemPage();
        socialMediaIconsPage = new SocialMediaIconsPage();
        cartPage = new CartPage();

    }

    @AfterClass
    public void tearDown(){
    //    driver.quit();
    }
}
