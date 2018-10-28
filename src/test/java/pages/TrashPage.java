package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TrashPage extends AbstractPage{
    public TrashPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public void openPage() {
        driver.navigate().to("");
    }
}
