package cheesy.utilities.pagefactory.elements;

import cheesy.utilities.pagefactory.elementfactory.ElementImplementation;
import org.openqa.selenium.WebElement;

public class ParagraphImplementation extends ElementImplementation implements Paragraph {
    public ParagraphImplementation(WebElement element) {
        super(element);
    }
}
