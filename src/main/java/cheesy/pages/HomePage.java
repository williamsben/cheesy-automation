package cheesy.pages;

import cheesy.model.Taste;
import cheesy.utilities.pagefactory.BasePage;
import cheesy.utilities.pagefactory.PageStore;
import cheesy.utilities.pagefactory.elements.Select;
import cheesy.utilities.pagefactory.elements.Table;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;

/**
 * Created by billiams on 6/5/17.
 */
public class HomePage extends BasePage {

    @FindBy(id="add-button")
    private WebElement addButton;

    @FindBy(id="name")
    private WebElement nameField;

    @FindBy(id="taste")
    private Select tasteSelect;

    @FindBy(css="form#logout-form input")
    private WebElement logoutButton;

    @FindBy(css="div.header-wrapper p")
    private WebElement userText;

    @FindBy(id="cheese-table")
    private Table cheeseTable;

    @Override
    public ExpectedCondition<?> ready(){
        return ExpectedConditions.visibilityOfAllElements(Collections.singletonList(addButton));
    }

    public void addCheese(String name, Taste taste){
        nameField.sendKeys(name);
        tasteSelect.selectByVisibleText(taste.text);
        addButton.click();
        waitUntilAjaxReady();
    }

    public LoginPage logout(){
        logoutButton.click();
        return (LoginPage) PageStore.getPage(LoginPage.class);
    }

    public Boolean confirmCheeseAdded(String name, Taste taste){
        return cheeseTable.getCheeseBy(name, taste) != null;
    }

    public String getUserInformation(){
        return userText.getText();
    }
}
