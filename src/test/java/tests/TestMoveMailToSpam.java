package tests;

import exception.LogInException;
import exception.MailsLocationException;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.Step;

public class TestMoveMailToSpam {
    private Step step;

    @BeforeMethod
    public void init() {
        step = new Step();
        step.initDriver();
    }

    @Test
    public void testIsLoggedIn() throws LogInException {
        Assert.assertTrue(step.isLoggedIn());
    }

    @Test
    public void testMailIsInDraftFolder() throws MailsLocationException {
        Assert.assertTrue(step.isMailInDraft());
    }

    @Test
    public void testMailIsInSpam() throws MailsLocationException {
        Assert.assertTrue(step.isMailInSpam());
    }

    @AfterMethod
    public void close() {
        step.logOff();
        step.closeConnection();
    }
}
