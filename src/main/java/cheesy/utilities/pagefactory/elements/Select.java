package cheesy.utilities.pagefactory.elements;

import java.util.List;

import cheesy.utilities.pagefactory.elementfactory.Element;
import cheesy.utilities.pagefactory.elementfactory.ImplementedBy;
import org.openqa.selenium.WebElement;

@ImplementedBy(SelectImplementation.class)
public interface Select extends Element {
	void deselectAll();
	void deselectByIndex(int index);
	void deselectByValue(String value);
	void deselectByVisibleText(String text);
	List<WebElement> getAllSelectedOptions();
	WebElement getFirstSelectedOption();
	List<WebElement> getOptions();
	boolean isMultiple();
	void selectByIndex(int index);
	void selectByValue(String value);
	void selectByVisibleText(String text);
}
