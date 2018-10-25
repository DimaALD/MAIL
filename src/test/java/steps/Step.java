package steps;

import driver.Driver;
import exception.LogInException;
import exception.MailIsNotInDraftFolderException;
import exception.MailIsNotInSendFolderException;
import objects.Mail;
import objects.User;
import org.openqa.selenium.WebDriver;
import pages.CreateMalePage;
import pages.DraftPage;
import pages.LoginPage;
import pages.SendPage;

public class Step {
    private WebDriver driver;
    private LoginPage loginPage;
    private CreateMalePage createMalePage;
    private DraftPage draftPage;
    private SendPage sendPage;

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

    public boolean isMailInDraftFolder() throws MailIsNotInDraftFolderException {
        createMalePage = new CreateMalePage(driver);
        createMalePage.createNewMail().saveMailInDraft().clickOnDraftButton();
        draftPage = new DraftPage(driver);
        if (!draftPage.isMailInDraft())
        {
            throw new MailIsNotInDraftFolderException("Mail is not found in draft foldet");
        }
        return true;

    }

    public boolean isMailNotInDraftFolder() throws MailIsNotInDraftFolderException {
        draftPage = new DraftPage(driver);
        draftPage.openMail();
        createMalePage = new CreateMalePage(driver);
        createMalePage.sendMail();
        if (draftPage.isMailInDraft())
        {
            throw new MailIsNotInDraftFolderException("Mail is still in draft");
        }
        return false;
    }

    public boolean isMailInSendFolder() throws MailIsNotInSendFolderException {
        draftPage = new DraftPage(driver);
        draftPage.clickOnSendReference();
        sendPage = new SendPage(driver);
        if(!sendPage.isMailInSendFolder())
        {
            throw new MailIsNotInSendFolderException("Mail is not in send folder");
        }
        return true;
    }

}
