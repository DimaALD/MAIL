package pages;

import objects.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waiter;

public class LoginPage extends AbstractPage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public static final String LOGIN_PAGE_URL = "https://mail.ru/";

    @FindBy(xpath = "//input[@id = 'mailbox:login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id = 'mailbox:password']")
    private WebElement passwordField;

    @FindBy(xpath = "//label[@id ='mailbox:submit' ]/input[@class = 'o-control']")
    private WebElement enterButton;

    @FindBy(id = "PH_user-email")
    private WebElement userName;

    public LoginPage logIn() {
        Waiter.waitForElementClickable(driver,loginField);
        loginField.sendKeys(User.getLogin());
        Waiter.waitForElementClickable(driver,passwordField);
        passwordField.sendKeys(User.getPassword());
        enterButton.click();
        return this;
    }

    public boolean isLoggedIn() {
        Waiter.waitForElementVisible(driver,userName);
        return userName.getText().equals(User.getLogin()+"@mail.ru");
    }

    @Override
    public void openPage() {
        driver.navigate().to(LOGIN_PAGE_URL);
    }
}
