package cheesy;

import cheesy.pages.LoginPage;
import cheesy.utilities.pagefactory.PageStore;
import cheesy.utilities.tools.WebDriverResource;
import cheesy.utilities.tools.drivers.Browser;
import cheesy.utilities.tools.drivers.Drivers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by billiams on 6/5/17.
 */
public class BaseTest {

    protected WebDriverResource wdr = WebDriverResource.getInstance();
    protected LoginPage loginPage;

    @BeforeMethod()
    public void setup() throws Exception {

        Browser browser = Browser.CHROME;
        String url = "http://localhost:7070/demo/";

        wdr.setDriver(Drivers.getDriver(browser));
        wdr.setWait(20);

        wdr.driver.get(url);

        loginPage = (LoginPage) PageStore.getPage(LoginPage.class);
    }

    @AfterMethod
    public void cleanup(){
        wdr.driver.quit();
    }

}
