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

    public static final String SENT_PAGE_URL = "https://e.mail.ru/messages/sent/";

    public boolean isMailInSendFolder() {
        driver.navigate().refresh();
        List<WebElement> list = driver.findElements(By.xpath("//div[@id = 'b-letters']//a[@data-name='link']"));
        for (WebElement element : list) {
            if (element.findElement(By.xpath("//div[@class = 'b-datalist__item__subj']")).getText().equals(Mail.getSubject() + Mail.getText())
                    && element.findElement(By.xpath("//div[@class = 'b-datalist__item__addr']")).getText().trim().equals(Mail.getTo())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void openPage() {
        driver.navigate().to(SENT_PAGE_URL);
    }
}

