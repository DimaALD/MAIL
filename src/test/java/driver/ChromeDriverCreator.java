package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator implements WebDriverCreator{
    public WebDriver createWebDriver() {
        System.setProperty("webdriver.chrome.driver",".\\chromedriver\\chromedriver.exe");
        return new ChromeDriver();
    }
}
