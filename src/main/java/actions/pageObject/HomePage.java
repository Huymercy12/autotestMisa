package actions.pageObject;

import actions.commons.AbstractPage;
import actions.commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUI.HomePageUI;

public class HomePage extends AbstractPage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebUrl() {
        openUrl(driver, GlobalConstants.url);
    }

    public void clickToElementor() {
        waitToElementVisible(driver, HomePageUI.ELEMENTOR);
        clickToElement(driver, HomePageUI.ELEMENTOR);
    }

    public void clickTemplateKits() {
        waitToElementVisible(driver, HomePageUI.TEMPLATE_KITS);
        clickToElement(driver, HomePageUI.TEMPLATE_KITS);
    }

    public void clickGridView() {
        waitToElementVisible(driver, HomePageUI.GRID_VIEW);
        clickToElement(driver, HomePageUI.GRID_VIEW);
    }

    public void addGood(String good){
        waitToElementVisible(driver,HomePageUI.ADD_TO_CART_BUTTON,good );
        clickToElement(driver,HomePageUI.ADD_TO_CART_BUTTON,good);
    }
    public void keepBrowsing(){
        waitToElementVisible(driver,HomePageUI.KEEP_BROWSING);
        clickToElement(driver,HomePageUI.KEEP_BROWSING);
    }
    public void checkOut(){
        waitToElementVisible(driver,HomePageUI.CHECK_OUT);
        clickToElement(driver,HomePageUI.CHECK_OUT);
    }
}
