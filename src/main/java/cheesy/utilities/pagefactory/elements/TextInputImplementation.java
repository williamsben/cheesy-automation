package cheesy.utilities.pagefactory.elements;

import cheesy.utilities.pagefactory.elementfactory.ElementImplementation;
import org.openqa.selenium.WebElement;

public class TextInputImplementation extends ElementImplementation implements TextInput {
    public TextInputImplementation(WebElement element) {
        super(element);
    }
}
