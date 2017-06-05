package cheesy.utilities.pagefactory.elementfactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

@ImplementedBy(ElementImplementation.class)
public interface Element extends WebElement, WrapsElement, Locatable {}
