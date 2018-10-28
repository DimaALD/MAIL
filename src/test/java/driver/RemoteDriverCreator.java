package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverCreator implements WebDriverCreator {
    public WebDriver createWebDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            return new RemoteWebDriver(new URL("http://192.168.0.108:5555/wd/hub"), capabilities);
    }
}
