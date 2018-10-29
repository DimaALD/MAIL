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
    public static WebDriver driver;

    private Driver() {
    }

    public enum createDriver {

        CHROME {
            @Override
            public WebDriver getWebdriver() {
                System.setProperty("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=en-us");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                return driver;
            }
        }, REMOTE {
            @Override
            public WebDriver getWebdriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                try {
                    return new RemoteWebDriver(new URL("http://10.6.102.102:4444/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return driver;
            }
        };

        public abstract WebDriver getWebdriver();
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--lang=en-us");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver;
        }
        return driver;
    }

    public static WebDriver getDriver(createDriver type) {
        if (null == driver) {
           driver = type.getWebdriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           return driver;
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}
