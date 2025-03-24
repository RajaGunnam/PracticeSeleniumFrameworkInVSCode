package testCases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.Map;

public class LoginFunctionality extends BaseTest {

    @Test
    public void test_ValidLogin() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);

        // Get credentials from the UI
        //Map<String, String> credentials = lp.getCredentials();
        //String uN = credentials.get("username");
        //String pWD = credentials.get("password");

        // Perform login
        lp.validLoginTest("Admin", "admin123");

    }
}
