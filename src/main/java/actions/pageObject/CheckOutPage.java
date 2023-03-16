package actions.pageObject;

import actions.commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUI.CheckOutPageUI;


public class CheckOutPage extends AbstractPage {
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getElementTextGoodByName(String element, String name) {
        waitToElementVisible(driver, element, name);
        return getElementText(driver, element, name);
    }

    public String getElementTextGoodByMoney(String element, String money) {
        waitToElementVisible(driver, element, money);
        return getElementText(driver, element, money);
    }
    public String getElementTextGoodsByCartTotal(String element) {
        waitToElementVisible(driver,element);
        return getElementText(driver,element);
    }

    public void verifyTextElement(String element,String name, String text) {
        Assert.assertEquals(getElementTextGoodByName(element,name ), text);
    }
    public void verifyTextMoney(String element,String name, String text) {
        Assert.assertEquals(getElementTextGoodByMoney(element,name ), text);
    }
    public void verifyCartTotal(String element, String text) {
        Assert.assertEquals(getElementTextGoodsByCartTotal(element), text);
    }
    public void clickToCheckOut() {
        waitToElementVisible(driver, CheckOutPageUI.CHECKOUT_BUTTON);
        clickToElement(driver, CheckOutPageUI.CHECKOUT_BUTTON);
    }



}
