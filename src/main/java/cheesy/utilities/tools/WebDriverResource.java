package cheesy.utilities.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverResource {
    private static WebDriverResource instance = null;
    public WebDriver driver;
    public WebDriverWait wait;

    // Exists only to defeat instantiation.
    protected WebDriverResource() {}

    public static WebDriverResource getInstance() {
        if(instance == null){
            instance = new WebDriverResource();
        }
        return instance;
    }

    public void setDriver(WebDriver d){
        this.driver = d;
    }

    public void setWait(Integer time){
        this.wait = new WebDriverWait(driver, time);
    }
}