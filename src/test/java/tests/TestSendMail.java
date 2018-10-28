package tests;

import exception.LogInException;
import exception.MailIsNotInFolderException;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.Step;

public class TestSendMail {
    private Step step;
    @BeforeMethod
    public void init()
    {
        step = new Step();
        step.initDriver();
    }

    @AfterMethod
    public void close()
    {
        step.logOff();
        step.closeConnection();
    }

    @Test
    public void testLogIn() throws LogInException
    {
        Assert.assertTrue(step.getLogin());
    }

    @Test
    public void testMailIsInDraftFolder() throws MailIsNotInFolderException, LogInException {
        step.getLogin();
        Assert.assertTrue(step.isMailInDraftFolder());
    }

    // FIXME: 28.10.2018 Doesn't work with all tests
    @Test
    public void testMailIsNotInDraft() throws MailIsNotInFolderException, LogInException{
        step.getLogin();
        step.isMailInDraftFolder();
        Assert.assertFalse(step.isMailNotInDraftFolder());
    }

    @Test
    public void testMailInSendFolder() throws MailIsNotInFolderException,LogInException{
        step.getLogin();
        step.isMailInDraftFolder();
        step.isMailNotInDraftFolder();
        Assert.assertTrue(step.isMailInSendFolder());
    }







}
