package tests;

import exception.LogInException;
import exception.MailIsNotInFolderException;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.Step;

public class TestMoveMailToTrash {
    private Step step;

    @BeforeMethod
    public void init() {
        step = new Step();
        step.initDriver();
    }

    @Test
    public void testLogIn() throws LogInException {
        Assert.assertTrue(step.getLogin());
    }

    @Test
    public void testMailIsInDraftFolder() throws MailIsNotInFolderException, LogInException {
        step.getLogin();
        Assert.assertTrue(step.isMailInDraftFolder());
    }

    @Test
    public void testMoveMailToTrash() throws LogInException, MailIsNotInFolderException {
        step.getLogin();
        step.isMailInDraftFolder();
        Assert.assertTrue(step.isMailInTrashFolder());
    }

    @AfterMethod
    public void close() {
        step.logOff();
        step.closeConnection();
    }
}
