package testcase;


import actions.commons.AbstractTest;
import actions.pageObject.CreateAccountPage;
import actions.pageObject.HomePage;
import actions.pageObject.CheckOutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageUI.CheckOutPageUI;
import pageUI.CreateAccountPageUI;

public class TC_WebDemo extends AbstractTest {
    WebDriver driver;
    HomePage homePageObject;
    CheckOutPage checkOutPage;
    CreateAccountPage createAccountPage;
    String fisrtGood = "Trena - Sport & Fitness Trainer Services Elementor Template Kit";
    String secondGood = "Luwe - Restaurant Elementor Template Kit";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        homePageObject = new HomePage(driver);
        checkOutPage = new CheckOutPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        homePageObject.openWebUrl();

    }

    @DataProvider(name = "testdata")
    public Object[][] getTestData() {
        return new Object[][]{
                {"Vincent", "VSM", "vincent@gmail.com", "vincent218", "Vincent@218"},
                {"Leo", "VSM", "leo@gmail.com", "leo123", "Leo@5421"},
                {"Huy", "VSM", "huy12@gmail.com", "huy123", "Huy@123"}
        };
    }

    @Test
    public void TC_01_Test() {
        System.out.println("Homepage - Step 01: Access Elementor");
        homePageObject.clickToElementor();
        System.out.println("Homepage - Step 02: Click Template Kits");
        homePageObject.clickTemplateKits();
        System.out.println("Homepage - Step 03: Click Grid View");
        homePageObject.clickGridView();
        System.out.println("Homepage - Step 04: Add First Good to Cart");
        homePageObject.addGood("1");
        homePageObject.keepBrowsing();
        System.out.println("Homepage - Step 05: Add Second Good to Cart");
        homePageObject.addGood("2");
        System.out.println("Homepage - Step 06: Checck out");
        homePageObject.checkOut();
    }

    @Test
    public void TC_02_Test() {
        System.out.println("CheckOutPage - Step 01: Verify Goods By Name");
        checkOutPage.verifyTextElement(CheckOutPageUI.GOOD_TEXT_BY_NAME, "Trena", fisrtGood);
        checkOutPage.verifyTextElement(CheckOutPageUI.GOOD_TEXT_BY_NAME, "Luwe", secondGood);
        System.out.println("CheckOutPage - Step 02: Verify Goods By Money");
        checkOutPage.verifyTextMoney(CheckOutPageUI.GOOD_TEXT_BY_MONEY, "29", "$29");
        checkOutPage.verifyTextMoney(CheckOutPageUI.GOOD_TEXT_BY_MONEY, "19", "$19");
        System.out.println("CheckOutPage - Step 03: Verify Cart Total");
        checkOutPage.verifyCartTotal(CheckOutPageUI.CART_TOTAL, "48");
        System.out.println("CheckOutPage - Step 04: Click To Secure Checkout");
        checkOutPage.clickToCheckOut();
    }

    @Test(dataProvider = "testdata")
    public void TC_03_Test(String firstName, String lastName, String email, String username, String password) {
        System.out.println("CreateAccountPage - Step 01: Input First Name");
        createAccountPage.inputTextBox(CreateAccountPageUI.INPUT_TEXTBOX, firstName, "firstName");
        System.out.println("CreateAccountPage - Step 02: Input Last Name");
        createAccountPage.inputTextBox(CreateAccountPageUI.INPUT_TEXTBOX, lastName, "lastName");
        System.out.println("CreateAccountPage - Step 03: Input Email");
        createAccountPage.inputTextBox(CreateAccountPageUI.INPUT_TEXTBOX, email, "email");
        System.out.println("CreateAccountPage - Step 04: Input Username");
        createAccountPage.inputTextBox(CreateAccountPageUI.INPUT_TEXTBOX, username, "username");
        System.out.println("CreateAccountPage - Step 04: Input Password");
        createAccountPage.inputTextBox(CreateAccountPageUI.INPUT_TEXTBOX,password, "password");
        System.out.println("CreateAccountPage - Step 05: Click Capcha");
        createAccountPage.clickToCapcha();
        System.out.println("CreateAccountPage - Step 06: Click Send Tips");
        createAccountPage.clickToTips();
    }

    @AfterClass
    public void afterClass() {
        WebDriverManager.chromedriver().quit();
    }
}