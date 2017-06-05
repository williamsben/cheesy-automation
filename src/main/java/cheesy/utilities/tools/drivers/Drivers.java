package cheesy.utilities.tools.drivers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by billiams on 6/5/17.
 */
public class Drivers {

    public static WebDriver getDriver(Browser browser){ return getDriver(browser, null);}

    public static WebDriver getDriver(Browser browser, DesiredCapabilities caps){
        switch(browser){
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                if(caps == null) caps = new DesiredCapabilities();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("no-sandbox");
                caps.setCapability(ChromeOptions.CAPABILITY, options);
                return new ChromeDriver(caps);
            case INTERNET_EXPLORER:
                InternetExplorerDriverManager.getInstance().setup();
                return new InternetExplorerDriver(caps);
            case FIREFOX:
            default:
                return new FirefoxDriver(caps);
        }
    }
}
