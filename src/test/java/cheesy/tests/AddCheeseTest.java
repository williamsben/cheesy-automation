package cheesy.tests;

import cheesy.BaseTest;
import cheesy.model.Taste;
import cheesy.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCheeseTest extends BaseTest {

    @Test
    public void addCheeseTest(){

        String cheeseName = "Swiss";
        Taste cheeseTaste = Taste.DELICIOUS;

        HomePage homePage = loginPage.login("user1", "1234");

        homePage.addCheese(cheeseName, cheeseTaste);

        Assert.assertTrue(homePage.confirmCheeseAdded(cheeseName, cheeseTaste), "Cheese not added!");

    }
}
