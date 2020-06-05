package selenium.uj.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.uj.project.pages.LoginPage;
import selenium.uj.project.utils.BaseProperties;

public class LoginTest extends DefaultTest {

    @Test
    public void login() {
        Assert.assertTrue(
                new LoginPage(driver, logger)
                        .fillLoginForm(BaseProperties.BASE_ADMIN_NAME,BaseProperties.BASE_ADMIN_PASSWORD)
                        .submitLoginForm()
                        .openMenu()
                        .isDisplayLogoutButton());

    }

}