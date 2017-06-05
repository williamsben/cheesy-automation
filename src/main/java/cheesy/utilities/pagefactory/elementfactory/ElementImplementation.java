package cheesy.utilities.pagefactory.elementfactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

public class ElementImplementation implements Element {

	private WebElement element;

    public ElementImplementation(WebElement element) {
        this.element = element;
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

	@Override
	public void clear() {
		element.clear();
	}

	@Override
	public WebElement findElement(By arg0) {
		return element.findElement(arg0);
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		return element.findElements(arg0);
	}

	@Override
	public String getAttribute(String arg0) {
		return element.getAttribute(arg0);
	}

	@Override
	public String getCssValue(String arg0) {
		return element.getCssValue(arg0);
	}

	@Override
	public Point getLocation() {
		return element.getLocation();
	}

	@Override
	public Rectangle getRect() {
		return element.getRect();
	}

	@Override
	public Dimension getSize() {
		return element.getSize();
	}

	@Override
	public String getTagName() {
		return element.getTagName();
	}

	@Override
	public String getText() {
		return element.getText();
	}

	@Override
	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	@Override
	public boolean isEnabled() {
		return element.isEnabled();
	}

	@Override
	public boolean isSelected() {
		return element.isSelected();
	}

	@Override
	public void submit() {
		element.submit();
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		return element.getScreenshotAs(arg0);
	}

	@Override
	public WebElement getWrappedElement() {
		return element;
	}

	protected void setWrappedElement(WebElement element) {
		this.element = element;
	}

	@Override
	public Coordinates getCoordinates() {
		return ((Locatable) element).getCoordinates();
	}

}
