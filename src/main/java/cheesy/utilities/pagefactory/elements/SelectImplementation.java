package cheesy.utilities.pagefactory.elements;

import org.openqa.selenium.WebElement;
import java.util.List;

import cheesy.utilities.pagefactory.elementfactory.ElementImplementation;

public class SelectImplementation extends ElementImplementation implements Select {

  private org.openqa.selenium.support.ui.Select select;

	public SelectImplementation(WebElement element) {
		super(element);
        select = new org.openqa.selenium.support.ui.Select(element);
	}

  @Override
  public void deselectAll(){
    select.deselectAll();
  }

  @Override
	public void deselectByIndex(int index){
    select.deselectByIndex(index);
  }

  @Override
	public void deselectByValue(String value){
    select.deselectByValue(value);
  }

  @Override
	public void deselectByVisibleText(String text){
    select.deselectByVisibleText(text);
  }

  @Override
	public List<WebElement> getAllSelectedOptions(){
    return select.getAllSelectedOptions();
  }

  @Override
	public WebElement getFirstSelectedOption(){
    return select.getFirstSelectedOption();
  }

  @Override
	public List<WebElement> getOptions(){
    return select.getOptions();
  }

  @Override
	public boolean isMultiple(){
    return select.isMultiple();
  }

  @Override
	public void selectByIndex(int index){
    select.selectByIndex(index);
  }

  @Override
	public void selectByValue(String value){
    select.selectByValue(value);
  }

  @Override
	public void selectByVisibleText(String text){
    select.selectByVisibleText(text);
  }

}
