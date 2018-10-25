package pages;

import objects.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collection;
import java.util.List;

public class DraftPage extends AbstractPage {
    public DraftPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public static final String DRAFT_PAGE_URL = "https://e.mail.ru/messages/drafts/";

    @FindBy(xpath = "//div[@class = 'b-toolbar__item']//span[text() = 'Переместить']")
    private WebElement relocateButton;

    @FindBy(xpath = "//a[@data-id = '950']")
    private WebElement relocateToSpamButton;

    @FindBy(xpath = "//div[@data-name = 'remove']")
    private WebElement deleteButton;

    @FindBy(xpath = "//div[@class = 'js-item-checkbox b-datalist__item__cbx']")
    private WebElement checkBoxForMail;

    public boolean isMailInDraft() {
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

    public void openMail() {
        driver.navigate().refresh();
        List<WebElement> list = driver.findElements(By.xpath("//div[@id = 'b-letters']//a[@data-name='link']"));
        for (WebElement element : list) {
            if (element.findElement(By.xpath("//div[@class = 'b-datalist__item__subj']")).getText().trim().equals(Mail.getSubject() + Mail.getText())
                    && element.findElement(By.xpath("//div[@class = 'b-datalist__item__addr']")).getText().trim().equals(Mail.getTo())) {
                element.click();
            }
        }


    }

    @Override
    public void openPage() {
        driver.navigate().to(DRAFT_PAGE_URL);
    }
}
