package selenium.uj.project.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyViewPage extends DefaultPage {

    @FindBy( xpath = "//*[@id=\"navbar-container\"]/div[2]")
    private WebElement userMenu;
    @FindBy( xpath = "//*[@id=\"navbar-container\"]/div[2]/ul/li/ul/li[4]/a")
    private WebElement logoutButton;
    @FindBy(xpath = "//*[@id=\"navbar-container\"]/div[2]/ul/li/ul/li[1]/a")
    private WebElement mojeKonto;
    @FindBy (xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/ul/li[5]/a")
    private WebElement apiTab;

    public MyViewPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }
    public MyViewPage openMenu(){
        clickElement(userMenu);
      return new MyViewPage(driver, logger);

    }
    public boolean isDisplayLogoutButton(){

        return logoutButton.isDisplayed();
    }
    public TokensPage openTokenPage(){
         clickElement(mojeKonto);
         clickElement(apiTab);
        return new TokensPage(driver, logger);
}

}
