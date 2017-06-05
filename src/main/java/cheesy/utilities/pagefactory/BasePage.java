package cheesy.utilities.pagefactory;

import cheesy.utilities.tools.WebDriverResource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public abstract class BasePage {
	protected static WebDriverResource wdResource = WebDriverResource.getInstance();
	public static String windowHandle;

	public static void quit(){
		wdResource.driver.quit();
	}

	public ExpectedCondition<?> ready(){return null;}


	public void waitUntilDisplayed(final WebElement element){
		int keepTrying = 0;
		while(keepTrying < 5){
			try{
				wdResource.wait.until(new ExpectedCondition<Boolean>(){
					@Override
					public Boolean apply(WebDriver driver){
						return element.isDisplayed();
					};
				});
				keepTrying = 6;
			}catch(WebDriverException e){
				keepTrying += 1;
			}
		}
	}

	public void waitUntilDisplayed(final By locator){
		wdResource.wait.until(new ExpectedCondition<Boolean>(){
			@Override
			public Boolean apply(WebDriver driver){
				return wdResource.driver.findElement(locator).isDisplayed();
			};
		});
	}

	public void waitUntilStale(By locator){
		wdResource.wait.until(ExpectedConditions.stalenessOf(wdResource.driver.findElement(locator)));
	}
	
	public void waitUntilStale(WebElement element){
		wdResource.wait.until(ExpectedConditions.stalenessOf(element));
	}

	public void waitUntilUncovered(WebElement element, By selector){
		wdResource.wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
	}

	public void waitUntilTextDisplayed(WebElement element, String text){
		wdResource.wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public void waitUntilVisible(WebElement element){
		int keepTrying = 0;
		while(keepTrying < 5){
			try{
				wdResource.wait.until(ExpectedConditions.visibilityOf(element));
				keepTrying = 6;
			}catch(WebDriverException e){
				keepTrying += 1;
			}
		}
	}

	public void waitUntilClickable(WebElement element){
		wdResource.wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilHidden(By locator){
		wdResource.wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitUntilAjaxReady(){
		wdResource.wait.until(new ExpectedCondition<Boolean>(){
			@Override
			public Boolean apply(WebDriver driver){
				return (Boolean)((JavascriptExecutor)wdResource.driver).executeScript("return jQuery.active == 0");
			};
		});
	}

	public void waitUntilPageReady(){
		wdResource.wait.until(new ExpectedCondition<Boolean>(){
			@Override
			public Boolean apply(WebDriver driver){
				return (Boolean)((JavascriptExecutor)wdResource.driver).executeScript("return document.readyState").equals("complete");
			};
		});
	}

	public void waitUntilEnabled(final WebElement element){
		wdResource.wait.until(new ExpectedCondition<Boolean>(){
			@Override
			public Boolean apply(WebDriver driver){
				return element.isEnabled();
			};
		});
	}
}
