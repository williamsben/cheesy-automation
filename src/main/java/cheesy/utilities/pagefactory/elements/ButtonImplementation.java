package cheesy.utilities.pagefactory.elements;

import cheesy.utilities.pagefactory.elementfactory.ElementImplementation;
import org.openqa.selenium.WebElement;

public class ButtonImplementation extends ElementImplementation implements Button {
    public ButtonImplementation(WebElement element) {
        super(element);
    }
}
