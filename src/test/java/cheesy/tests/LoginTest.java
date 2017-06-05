package cheesy.tests;

import cheesy.BaseTest;
import cheesy.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by billiams on 6/5/17.
 */
public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){

        HomePage homePage = loginPage.login("user1", "1234");

        Assert.assertEquals(homePage.getUserInformation(), "Welcome, user1");

    }

}
