package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utilities.ConfigReader;

public class BaseTest {

    protected WebDriver driver;
    //protected String baseUrl; // ✅ Store URL here
    @BeforeSuite
    public void setupLogger() {
        PropertyConfigurator.configure("C:\\Users\\RAJA\\IdeaProjects\\SelAutFramework\\src\\test\\resources\\log4j.properties");
    }
    @BeforeMethod
    //@Parameters({"url"})
    public void setUp(){ //if you want to use parameters then pass String url argument to this method
        //this.baseUrl = url;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.get(ConfigReader.getProperty("url"));
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
