package selenium.uj.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.uj.project.pages.MyViewPage;
import selenium.uj.project.pages.TokensPage;

public class TokenTest extends DefaultTest {

    String token = "test-token-" + Math.random();

    @Test
    public void createToken() {
        Assert.assertTrue(
                new MyViewPage(driver, logger)
                        .openTokenPage()
                        .createToken(token)
                        .isTokenCreated(token));
    }

    @Test
    public void deleteToken() {
        Assert.assertTrue(
                new TokensPage(driver, logger)
                        .deleteToken(token)
                        .navigateToTokensTab()
                        .isTokenDelete(token));

    }

}
