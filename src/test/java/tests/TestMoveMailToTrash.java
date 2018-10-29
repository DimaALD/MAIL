package tests;

import exception.LogInException;
import exception.MailsLocationException;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.Step;
import sun.misc.ASCIICaseInsensitiveComparator;

public class TestMoveMailToTrash {
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
    public void testMailIsInTrash() throws MailsLocationException {
        Assert.assertTrue(step.isMailInTrash());
    }

    @AfterMethod
    public void close() {
        step.logOff();
        step.closeConnection();
    }
}
