package selenium.uj.project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DefaultPage {

    @FindBy(id = "username")
    private WebElement loginElement;

    @FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/input[2]")
    private WebElement loginButton;

    @FindBy(id = "password")
    private WebElement passElement;


    public LoginPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public LoginPage fillLoginForm(String username, String password) {
        fillElement(loginElement,username);
        clickElement(loginButton);
        fillElement(passElement, password);


        return this;
    }

    public MyViewPage submitLoginForm() {
        passElement.sendKeys(Keys.ENTER);
        return new MyViewPage(driver, logger);
    }

}