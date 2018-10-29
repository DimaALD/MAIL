package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SendPage extends AbstractPage {
    public SendPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    private static final String SENT_PAGE_URL = "https://e.mail.ru/messages/sent/";

    @Override
    public void openPage() {
        driver.navigate().to(SENT_PAGE_URL);
    }
}

