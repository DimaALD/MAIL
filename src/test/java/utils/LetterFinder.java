package utils;

import objects.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LetterFinder {
    public boolean isMailInDraft(WebDriver driver) {
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
}



