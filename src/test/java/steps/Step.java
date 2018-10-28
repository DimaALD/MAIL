package steps;

import driver.Driver;
import exception.LogInException;
import exception.MailIsNotInFolderException;
import objects.Mail;
import objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.net.MalformedURLException;

public class Step {
    private WebDriver driver;
    private LoginPage loginPage;
    private CreateMalePage createMalePage;
    private DraftPage draftPage;
    private SendPage sendPage;
    private SpamPage spamPage;
    private TrashPage trashPage;

    public void initDriver() {
        driver = Driver.getDriver();
        User.getInstance();
        Mail.getInstance();
    }

    public void closeConnection() {
        Driver.closeDriver();
    }

    public boolean getLogin() throws LogInException {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.logIn();
        if (!loginPage.isLoggedIn())
        {
            throw new LogInException("Invalid authorization");
        }
        return true;
    }

    public boolean isMailInDraftFolder() throws MailIsNotInFolderException {
        createMalePage = new CreateMalePage(driver);
        createMalePage.createNewMail().saveMailInDraft().clickOnDraftButton();
        draftPage = new DraftPage(driver);
        if (!draftPage.isMailInFolder(Mail.getSubject() + Mail.getText(),Mail.getTo()))
        {
            throw new MailIsNotInFolderException("Mail is not found in draft folder");
        }
        return true;

    }

    public boolean isMailNotInDraftFolder() throws MailIsNotInFolderException {
        draftPage = new DraftPage(driver);
        draftPage.getMailFromFolder().click();
        createMalePage = new CreateMalePage(driver);
        createMalePage.sendMail();
        if (draftPage.isMailInFolder(Mail.getSubject() + Mail.getText(),Mail.getTo()))
        {
            throw new MailIsNotInFolderException("Mail is still in draft");
        }
        return false;
    }

    public boolean isMailInSendFolder() throws MailIsNotInFolderException {
        draftPage = new DraftPage(driver);
        draftPage.clickOnSendReference();
        sendPage = new SendPage(driver);
        if(!sendPage.isMailInFolder(Mail.getSubject() + Mail.getText(),Mail.getTo()))
        {
            throw new MailIsNotInFolderException("Mail is not in send folder");
        }
        return true;
    }

    public boolean isMailInSpamFolder() throws MailIsNotInFolderException {
        draftPage = new DraftPage(driver);
        draftPage.moveMailToSpam();
        spamPage = new SpamPage(driver);
        if(!spamPage.isMailInFolder(Mail.getSubject() + Mail.getText(),"Dzmitry Aldoshin"))
        {
            throw new MailIsNotInFolderException("Mail is not in spam folder");
        }
        return true;
    }

    public boolean isMailInTrashFolder() throws MailIsNotInFolderException {
        draftPage = new DraftPage(driver);
        draftPage.moveMailToTrash();
        trashPage = new TrashPage(driver);
        if (!trashPage.isMailInFolder(Mail.getSubject()+Mail.getText(),"Dzmitry Aldoshin")) {
            throw new MailIsNotInFolderException("Mail is not in trash folder");
        }
        return true;
    }

    public void logOff() {
        driver.findElement(By.id("PH_logoutLink")).click();
    }

}
