package cheesy.pages;

import cheesy.utilities.pagefactory.BasePage;
import cheesy.utilities.pagefactory.PageStore;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;

/**
 * Created by billiams on 6/5/17.
 */
public class LoginPage extends BasePage {

    @FindBy(name="username")
    private WebElement usernameField;

    @FindBy(name="password")
    private WebElement passwordField;

    @FindBy(name="submit")
    private WebElement submitButton;

    @Override
    public ExpectedCondition<?> ready(){
        return ExpectedConditions.visibilityOfAllElements(Collections.singletonList(submitButton));
    }

    public HomePage login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
        return (HomePage) PageStore.getPage(HomePage.class);
    }

}
