package steps;

import driver.Driver;
import exception.LogInException;
import exception.MailsLocationException;
import objects.Mail;
import objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.*;

public class Step {
    private WebDriver driver;
    private LoginPage loginPage;
    private CreateMalePage createMalePage;
    private DraftPage draftPage;
    private SendPage sendPage;
    private SpamPage spamPage;
    private TrashPage trashPage;

    public void initDriver() {
        driver = Driver.getDriver(Driver.createDriver.CHROME);
        User.getInstance();
        Mail.getInstance();
    }

    public void closeConnection() {
        Driver.closeDriver();
    }

    private void logInMailru(){
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.logIn();
    }


    private void createMail(){
        createMalePage = new CreateMalePage(driver);
        createMalePage.createNewMail().saveMailInDraft().clickOnDraftButton();
    }

    private void sendMail(){
        draftPage = new DraftPage(driver);
        draftPage.getMailFromFolder().click();
        createMalePage.sendMail();
    }

    public boolean isLoggedIn() throws LogInException {
        loginPage = new LoginPage(driver);
        logInMailru();
        if (!loginPage.isLoggedIn()) {
            throw new LogInException("Log in Mail.ru is failed");
        }
        return true;
    }

    public boolean isMailInDraft() throws MailsLocationException {
        logInMailru();
        createMail();
        draftPage = new DraftPage(driver);
        if (!draftPage.isMailInFolder(Mail.getSubject() + Mail.getText(), Mail.getTo())) {
            throw new MailsLocationException("Mail is not found in draft folder");
        }
        return true;
    }

    public boolean isMailNotInDraft() throws MailsLocationException {
        logInMailru();
        createMail();
        sendMail();
        draftPage = new DraftPage(driver);
        if (!draftPage.isMailInFolder(Mail.getSubject() + Mail.getText(), Mail.getTo())) {
            throw new MailsLocationException("Mail is not disappeared from draft");
        }
        return true;
    }

    public boolean isMailInSend() throws MailsLocationException {
        try {
            isMailNotInDraft();
        }catch (MailsLocationException exc) { }
        draftPage = new DraftPage(driver);
        draftPage.clickOnSendReference();
        sendPage = new SendPage(driver);
        if (!sendPage.isMailInFolder(Mail.getSubject() + Mail.getText(), Mail.getTo())) {
            throw new MailsLocationException("Mail is not in send folder");
        }
        return true;
    }
    public boolean isMailInTrash() throws MailsLocationException {
        logInMailru();
        createMail();
        draftPage = new DraftPage(driver);
        draftPage.moveMailToTrash();
        trashPage = new TrashPage(driver);
        if (!trashPage.isMailInFolder(Mail.getSubject()+Mail.getText(),"Dzmitry Aldoshin")) {
            throw new MailsLocationException("Mail is not in trash folder");
        }
        return true;
    }

    public boolean isMailInSpam() throws MailsLocationException {
        logInMailru();
        createMail();
        draftPage = new DraftPage(driver);
        draftPage.moveMailToSpam();
        spamPage = new SpamPage(driver);
        if(!spamPage.isMailInFolder(Mail.getSubject() + Mail.getText(),"Dzmitry Aldoshin"))
        {
            throw new MailsLocationException("Mail is not in spam folder");
        }
        return true;
    }
    public void logOff() {
        driver.findElement(By.id("PH_logoutLink")).click();
    }

}
