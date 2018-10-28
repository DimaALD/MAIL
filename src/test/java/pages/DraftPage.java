package pages;

import objects.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftPage extends AbstractPage {
    public DraftPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public static final String DRAFT_PAGE_URL = "https://e.mail.ru/messages/drafts/";

    @FindBy(xpath = "//div[@class = 'b-toolbar__item']//span[text() = 'Переместить']")
    private WebElement relocateButton;

    @FindBy(xpath = "//div[@data-id = '950']")
    private WebElement spamFolder;

    @FindBy(xpath = "//div[@data-id = '500002']")
    private WebElement deleteFolder;

    public DraftPage moveMailToSpam()
    {
        getMailFromFolder().findElement(By.xpath("//div[@class = 'js-item-checkbox b-datalist__item__cbx']")).click();
        new Actions(driver).dragAndDrop(getMailFromFolder() , spamFolder).build().perform();
        clickOnSpamReference();
        return this;
    }

    public DraftPage moveMailToTrash()
    {
        getMailFromFolder().findElement(By.xpath("//div[@class = 'js-item-checkbox b-datalist__item__cbx']")).click();
        new Actions(driver).dragAndDrop(getMailFromFolder() , deleteFolder).build().perform();
        clickOnTrashReference();
        return this;
    }

    @Override
    public void openPage() {
        driver.navigate().to(DRAFT_PAGE_URL);
    }
}
