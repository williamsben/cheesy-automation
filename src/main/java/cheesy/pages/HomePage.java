package cheesy.pages;

import cheesy.model.Taste;
import cheesy.utilities.pagefactory.BasePage;
import cheesy.utilities.pagefactory.PageStore;
import cheesy.utilities.pagefactory.elements.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Collections;

public class HomePage extends BasePage {

    @FindBy(css="div.header-wrapper p")
    private Paragraph userInfoParagraph;

    @FindBy(css="form#logout-form input")
    private Button logoutButton;

    @FindBy(id="name")
    private TextInput nameField;

    @FindBy(id="taste")
    private Select tasteSelect;

    @FindBy(id="add-button")
    private Button addButton;

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
        return userInfoParagraph.getText();
    }
}
