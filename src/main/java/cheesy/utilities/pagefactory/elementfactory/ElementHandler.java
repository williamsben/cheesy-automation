package cheesy.utilities.pagefactory.elementfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Replaces DefaultLocatingElementHandler. Simply opens it up to descendants of the WebElement interface, and other
 * mix-ins of WebElement and Locatable, etc. Saves the wrapping type for calling the constructor of the wrapped classes.
 */
public class ElementHandler implements InvocationHandler {
    private final ElementLocator locator;
    private final Class<?> wrappingType;

    /**
     * Generates a handler to retrieve the WebElement from a locator for a given WebElement interface descendant.
     *
     * @param interfaceType Interface wrapping this class. It contains a reference the the implementation.
     * @param locator       Element locator that finds the element on a page.
     * @param <T>           type of the interface
     */
    public <T> ElementHandler(Class<T> interfaceType, ElementLocator locator) {
        this.locator = locator;
        if (!Element.class.isAssignableFrom(interfaceType)) {
            throw new RuntimeException("interface not assignable to Element.");
        }

        this.wrappingType = getWrapperClass(interfaceType);
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
       final WebElement element;
        try {
            element = locator.findElement();
        } catch (NoSuchElementException e) {
            if ("toString".equals(method.getName())) {
                return "Proxy element for: " + locator.toString();
            }
            throw e;
        }

        if ("getWrappedElement".equals(method.getName())) {
            return element;
        }

        Constructor<?> cons = wrappingType.getConstructor(WebElement.class);
        Object thing = null;
        try {
            Constructor<?> altCons = wrappingType.getConstructor(WebElement.class, By.class);
            if (altCons != null) {
                By by = createByFromLocator();
                thing = altCons.newInstance(element, by);
            }
        }catch(NoSuchMethodException e){
            thing = cons.newInstance(element);
        }
        try {
            return method.invoke(wrappingType.cast(thing), objects);
        } catch (InvocationTargetException e) {
            // Unwrap the underlying exception
            throw e.getCause();
        }
    }
    
    public static <T> Class<?> getWrapperClass(Class<T> iface) {
        if (iface.isAnnotationPresent(ImplementedBy.class)) {
            ImplementedBy annotation = iface.getAnnotation(ImplementedBy.class);
            Class<?> clazz = annotation.value();
            if (Element.class.isAssignableFrom(clazz)) {
                return annotation.value();
            }
        }
        throw new UnsupportedOperationException("Apply @ImplementedBy interface to your Interface " + 
                iface.getCanonicalName() + " if you want to extend ");
    }

    private By createByFromLocator(){
        By result;
        String[] parts = locator.toString().split("By\\.");
        String[] idParts = parts[1].split(":\\s");
        String method = idParts[0];
        String identifier = idParts[1].substring(0, idParts[1].length()-1);
        switch(method){
            case "id":
                result = By.id(identifier);
                break;
            case "name":
                result = By.name(identifier);
                break;
            case "xpath":
                result = By.xpath(identifier);
                break;
            case "cssSelector":
                result = By.cssSelector(identifier);
                break;
            case "tagName":
                result = By.tagName(identifier);
                break;
            case "className":
                result = By.className(identifier);
                break;
            default:
                result = By.id(identifier);
        }

        return result;
    }
}
