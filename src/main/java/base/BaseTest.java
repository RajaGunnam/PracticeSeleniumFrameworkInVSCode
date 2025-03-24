package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;
    protected String baseUrl; // ✅ Store URL here
    @BeforeSuite
    public void setupLogger() {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }
    @BeforeMethod
    @Parameters({"url"})
    public void setUp(@Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) { // ✅ Provide default value
        this.baseUrl = url;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

//    @BeforeMethod
//    public void openBaseUrl() {
//        driver.get(baseUrl); // ✅ Use the stored URL
//    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
