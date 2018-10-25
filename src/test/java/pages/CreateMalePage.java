package pages;

import objects.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waiter;

public class CreateMalePage extends AbstractPage {
    public CreateMalePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public static final String CREATE_NEW_MAIL_URL = "https://e.mail.ru/compose/?1539705264227";

    @FindBy(css = "span[class = 'time']")
    WebElement messageIsSavedInDraft;

    @FindBy(xpath = "//textarea[@class = 'js-input compose__labels__input']")
    private WebElement toField;

    @FindBy(xpath = "//input[@class = 'b-input']")
    private WebElement subjectField;

    @FindBy(tagName = "iframe")
    private WebElement iframeForTextField;

    @FindBy(xpath = "//body[@id = 'tinymce']")
    private WebElement bodyForTextField;

    @FindBy(xpath = "//div[@data-name = 'saveDraft']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@data-name = 'send']")
    private WebElement sendButton;

    @FindBy(xpath = "//span[@class = 'b-toolbar__btn__text b-toolbar__btn__text_pad'][text() = 'Написать письмо']")
    private WebElement createNewMailButton;

    public CreateMalePage createNewMail() {
        Waiter.waitForElementClickable(driver , createNewMailButton);

        createNewMailButton.click();
        Waiter.waitForElementClickable(driver,toField);

        toField.sendKeys(Mail.getTo());
        Waiter.waitForElementClickable(driver,subjectField);

        subjectField.sendKeys(Mail.getSubject());
        Waiter.waitForElementVisible(driver , iframeForTextField);

        driver.switchTo().frame(iframeForTextField);
        Waiter.waitForElementClickable(driver,bodyForTextField);

        bodyForTextField.clear();
        bodyForTextField.sendKeys(Mail.getText());
        driver.switchTo().defaultContent();
        return this;
    }

    public CreateMalePage saveMailInDraft() {
        Waiter.waitForElementClickable(driver,saveButton);
        //waitForElementClickable(saveButton);
        saveButton.click();
        Waiter.waitForElementClickable(driver,messageIsSavedInDraft);
       // waitForElementVisible(messageIsSavedInDraft);
        return this;
    }

    public CreateMalePage sendMail()
    {
        Waiter.waitForElementClickable(driver,By.xpath("//div[@data-name = 'send']"));
        sendButton.click();
        Waiter.waitForElementVisible(driver,By.xpath("//div[@class = 'message-sent__title']"));
        clickOnDraftButton();
        return this;
    }

    @Override
    public void openPage() {
        driver.navigate().to(CREATE_NEW_MAIL_URL);
    }
}
