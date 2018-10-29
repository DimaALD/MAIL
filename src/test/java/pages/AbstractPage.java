package pages;

import objects.Mail;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LetterFinder;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected LetterFinder letterFinder;
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void openPage();

    public void highLightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '3px solid green'", element);
    }

    public void unHighLightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '0px'", element);
    }

    public AbstractPage clickOnDraftButton() {
        while (true) {
            try {
                driver.findElement(By.xpath("//span[@class = 'b-nav__item__text'][text() = 'Черновики']")).click();
                break;
            } catch (StaleElementReferenceException e) {
            }
        }
        return this;
    }

    public AbstractPage clickOnSendReference() {
        while (true) {
            try {
              driver.findElement(By.xpath("//span[@class = 'b-nav__item__text'][text() = 'Отправленные']")).click();
                break;
            } catch (StaleElementReferenceException exc) {
            }
        }

        return this;
    }

    public AbstractPage clickOnSpamReference() {
        while (true) {
            try {
                driver.findElement(By.xpath("//span[@class = 'b-nav__item__text'][text() = 'Спам']")).click();
                break;
            } catch (StaleElementReferenceException exc) {
            }
        }

        return this;
    }

    public AbstractPage clickOnTrashReference() {
        while (true) {
            try {
                driver.findElement(By.xpath("//span[@class = 'b-nav__item__text'][text() = 'Корзина']")).click();
                break;
            } catch (StaleElementReferenceException exc) {
            }
        }

        return this;
    }

    public boolean isMailInFolder(String subjectAndText , String addressee)
    {
        letterFinder = new LetterFinder();
        return letterFinder.isMailInFolder(driver,subjectAndText,addressee);
    }

    public WebElement getMailFromFolder()
    {
        letterFinder = new LetterFinder();
        return letterFinder.getMailFromFolder(driver);
    }


}
