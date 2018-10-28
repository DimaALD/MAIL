package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriverCreator creator ;
    public static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            creator = new ChromeDriverCreator();
            try {
                driver =  creator.createWebDriver();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void closeDriver()
    {
        driver.quit();
        driver = null;
    }

}
