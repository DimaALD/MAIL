package tests;

import exception.LogInException;
import exception.MailIsNotInDraftFolderException;
import exception.MailIsNotInSendFolderException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.Step;

public class TestSendMessage {
    private Step step;
    @BeforeClass
    public void init()
    {
        step = new Step();
        step.initDriver();
    }

    @Test
    public void testLogIn() throws LogInException
    {
        Assert.assertTrue(step.getLogin());
    }

    @Test
    public void testMailIsInDraftFolder() throws MailIsNotInDraftFolderException , LogInException {
        step.getLogin();
        Assert.assertTrue(step.isMailInDraftFolder());
    }


    @Test
    public void testMailIsNotInDraft() throws MailIsNotInDraftFolderException , LogInException{
        step.getLogin();
        step.isMailInDraftFolder();
        Assert.assertFalse(step.isMailNotInDraftFolder());
    }

    @Test
    public void testMailInSendFolder() throws MailIsNotInDraftFolderException , MailIsNotInSendFolderException ,LogInException{
        step.getLogin();
        step.isMailInDraftFolder();
        step.isMailNotInDraftFolder();
        Assert.assertTrue(step.isMailInSendFolder());
    }

    @AfterClass
    public void close()
    {
        step.logOff();
        step.closeConnection();
    }





}
