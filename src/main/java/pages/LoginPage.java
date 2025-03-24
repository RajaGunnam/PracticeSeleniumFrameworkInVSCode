package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.LoggerForAut;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import utilities.ConfigReader;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "username")
    private WebElement username_field;

    @FindBy(name = "password")
    private WebElement password_field;

    @FindBy(css = "button[type='submit']")
    private WebElement login_button;

//    // Username and Password fields on the page
//    @FindBy(xpath = "//p[contains(text(),'Username')]")
//    private WebElement username_value;
//
//    @FindBy(xpath = "//p[contains(text(),'Password')]")
//    private WebElement password_value;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        LoggerForAut.info("LoginPage initialized");
    }

//    public Map<String, String> getCredentials() {
//        LoggerForAut.info("Fetching username and password values from the page...");
//
//       String uN = wait.until(ExpectedConditions.visibilityOf(username_value)).getText().trim();
//        String pWD = wait.until(ExpectedConditions.visibilityOf(password_value)).getText().trim();
//
//        LoggerForAut.info("Extracted Username: " + uN);
//        LoggerForAut.info("Extracted Password: " + pWD);
//
//        Map<String, String> credentials = new HashMap<>();
//        credentials.put("username", uN);
//        credentials.put("password", pWD);
//
//        LoggerForAut.info("Returning extracted credentials.");
//        return credentials;
//    }

    public void validLoginTest(String username, String password) throws InterruptedException{

        driver.get(ConfigReader.getProperty("url"));
        LoggerForAut.info("Starting login process...");

        wait.until(ExpectedConditions.visibilityOf(username_field)).sendKeys(username);
        LoggerForAut.info("Entered username: " + username);

        wait.until(ExpectedConditions.visibilityOf(password_field)).sendKeys(password);
        LoggerForAut.info("Entered password: ********");

        wait.until(ExpectedConditions.elementToBeClickable(login_button)).click();
        Thread.sleep(5000);
        LoggerForAut.info("Clicked login button");

        LoggerForAut.info("Login process completed.");
        //System.out.println("Print Configuration file value : "+ConfigReader.getProperty("browser"));
    }


}
