package utils;

import objects.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.NoSuchElementException;

public class LetterFinder {
    private static final String ALL_MAIL_REFERENCES_ON_PAGE = "//div[@id = 'b-letters']//a[@data-name='link']";
    private static final String MAILS_SUBJECT_WITH_TEXT = "//div[@class = 'b-datalist__item__subj']";
    private static final String MAILS_ADRESSEE = "//div[@class = 'b-datalist__item__addr']";

    public boolean isMailInFolder(WebDriver driver , String subjectAndText , String addressee) {
        driver.navigate().refresh();
        List<WebElement> list = driver.findElements(By.xpath(ALL_MAIL_REFERENCES_ON_PAGE));
        for (WebElement element : list) {
            if (element.findElement(By.xpath(MAILS_SUBJECT_WITH_TEXT)).getText().trim().equals(subjectAndText)
                    && element.findElement(By.xpath(MAILS_ADRESSEE)).getText().trim().equals(addressee)) {
                return true;
            }
        }
        return false;
    }

    public WebElement getMailFromFolder(WebDriver driver)
    {
        driver.navigate().refresh();
        List<WebElement> list = driver.findElements(By.xpath("//div[@id = 'b-letters']//a[@data-name='link']"));
        for (WebElement element : list) {
            if (element.findElement(By.xpath("//div[@class = 'b-datalist__item__subj']")).getText().trim().equals(Mail.getSubject() + Mail.getText())
                    && element.findElement(By.xpath("//div[@class = 'b-datalist__item__addr']")).getText().trim().equals(Mail.getTo())) {
                return element;
            }
        }
        throw new NoSuchElementException();
    }
}





