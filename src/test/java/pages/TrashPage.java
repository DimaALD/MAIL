package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TrashPage extends AbstractPage {
    public TrashPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public static final String SPAM_PAGE_URL = "https://e.mail.ru/messages/spam/";

    @Override
    public void openPage() {
        driver.navigate().to(SPAM_PAGE_URL);
    }
}
