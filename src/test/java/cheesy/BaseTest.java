package cheesy;

import cheesy.pages.LoginPage;
import cheesy.utilities.pagefactory.PageStore;
import cheesy.utilities.tools.WebDriverResource;
import cheesy.utilities.tools.drivers.Browser;
import cheesy.utilities.tools.drivers.Drivers;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class BaseTest {

    protected WebDriverResource wdr = WebDriverResource.getInstance();
    protected LoginPage loginPage;

    @BeforeMethod()
    public void setup() throws Exception {

        Browser browser = Browser.CHROME;
        String url = "http://ec2-52-40-204-156.us-west-2.compute.amazonaws.com/demo/";

        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.MAC);
        WebDriver driver = new RemoteWebDriver(new URL("http://172.20.0.134:4444/wd/hub"), cap);


        wdr.setDriver(driver);
        wdr.setWait(20);

        wdr.driver.get(url);

        loginPage = (LoginPage) PageStore.getPage(LoginPage.class);
    }

    @AfterMethod
    public void cleanup(){
        wdr.driver.quit();
    }

}
