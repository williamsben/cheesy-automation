package cheesy.utilities.pagefactory;

import cheesy.utilities.tools.WebDriverResource;
import cheesy.utilities.pagefactory.elementfactory.ElementFactory;

public class PageStore {
	public static BasePage getPage(Class<? extends BasePage> clazz){
		BasePage page = ElementFactory.initElements(WebDriverResource.getInstance().driver, clazz);
		WebDriverResource.getInstance().wait.until(page.ready());
		return page;
	}
}
