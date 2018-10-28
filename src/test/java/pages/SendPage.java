package pages;

import objects.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Collection;
import java.util.List;

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

