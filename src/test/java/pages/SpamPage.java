package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpamPage extends AbstractPage {
    public SpamPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    private static final String SPAM_PAGE_URL = "https://e.mail.ru/messages/spam/";

    @Override
    public void openPage() {
        driver.navigate().to(SPAM_PAGE_URL);
    }
}
