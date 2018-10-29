package tests;

import exception.LogInException;
import exception.MailsLocationException;
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
    public void testIsLoggedIn() throws LogInException  {
       Assert.assertTrue(step.isLoggedIn());
    }

    @Test
    public void testMailIsInDraftFolder() throws  MailsLocationException {
        Assert.assertTrue(step.isMailInDraft());
    }

    @Test(expectedExceptions = MailsLocationException.class)
    public void testMailIsNotInDraft() throws MailsLocationException {
       step.isMailNotInDraft();
    }

    @Test
    public void testMailInSendFolder() throws MailsLocationException {
       Assert.assertTrue(step.isMailInSend());
    }








}
