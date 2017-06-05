package cheesy.utilities.pagefactory.elements;

import cheesy.model.Cheese;
import cheesy.model.Column;
import cheesy.model.Taste;
import cheesy.utilities.pagefactory.elementfactory.ElementImplementation;
import cheesy.utilities.tools.WebDriverResource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by billiams on 6/5/17.
 */
public class TableImplementation extends ElementImplementation implements Table {

    private By locator;

    public TableImplementation(WebElement element, By locator) {
        super(element);
        this.locator = locator;
    }

    public TableImplementation(WebElement element) {
        super(element);
    }

    @Override
    public WebElement getWrappedElement(){
        return WebDriverResource.getInstance().driver.findElement(locator);
    }

    @Override
    public List<Cheese> getCheeses() {
        List<Cheese> cheeses = new ArrayList<>();
        List<Column> headers = getHeaders();
        for(WebElement row : getWrappedElement().findElements(By.cssSelector("tbody>tr"))){
            Cheese c = new Cheese();
            List<WebElement> tds = row.findElements(By.tagName("td"));
            for(int i = 0; i < headers.size(); i ++){
                c.setValueFor(headers.get(i), tds.get(i));
            }
            cheeses.add(c);
        }
        return cheeses;
    }

    @Override
    public Cheese getCheeseBy(String name, Taste taste) {
        for(Cheese c : getCheeses()){
            if(c.getName().equals(name) && c.getTaste() == taste){
                return c;
            }
        }
        return null;
    }

    private List<Column> getHeaders(){
        List<Column> headers = new LinkedList<>();
        for(WebElement htd : getWrappedElement().findElements(By.cssSelector("thead>tr>th"))){
            for(Column c : Column.values()){
                if(c.text.toLowerCase().equals(htd.getText().toLowerCase())){
                    headers.add(c);
                    break;
                }
            }
        }

        return headers;
    }
}
