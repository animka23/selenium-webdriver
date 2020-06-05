package selenium.uj.project.pages;

import jdk.nashorn.internal.parser.Token;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TokensPage extends DefaultPage {

    @FindBy(xpath = "//*[@id=\"navbar-container\"]/div[2]")
    private WebElement userMenu;

    @FindBy(id = "token_name")
    private WebElement tokenElement;

    @FindBy(xpath = "//*[@id=\"account-create-api-token-form\"]/div/div[2]/div[2]/button")
    private WebElement createToken;

    @FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div/a")
    private WebElement tokenClik;

    public TokensPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public TokensPage createToken(String token) {
        fillElement(tokenElement, token);
        clickElement(createToken);
        clickElement(tokenClik);
        return new TokensPage(driver, logger);

    }

    public By getTokenInputLocator(String token){
        return By.xpath("//input[@value='" + token + "']");
    }
    public WebElement getTokenInput(String token) {
        return driver.findElement(getTokenInputLocator(token));
    }

    public boolean isTokenCreated(String token) {
        // Nie używamy isDisplayed ponieważ element nie jest widoczony na stronie, lecz bezposrednio w kodzie html
        return getTokenInput(token) != null;
    }


    public TokensPage deleteToken(String token) {
        WebElement submit = driver.findElement(By.xpath("//input[@value='" + token + "']/parent::fieldset/input[@type='submit']"));
        clickElement(submit);
        return new TokensPage(driver, logger);
    }

    public TokensPage navigateToTokensTab(){
        return new MyViewPage(driver,logger).openMenu().openTokenPage();
    }
    public boolean isTokenDelete(String token) {
        return isElementPresent(getTokenInputLocator(token)) == false;
    }
}
