package cheesy.utilities.pagefactory.elements;

import cheesy.model.Cheese;
import cheesy.model.Taste;
import cheesy.utilities.pagefactory.elementfactory.Element;
import cheesy.utilities.pagefactory.elementfactory.ImplementedBy;

import java.util.List;

@ImplementedBy(TableImplementation.class)
public interface Table extends Element {
    List<Cheese> getCheeses();
    Cheese getCheeseBy(String name, Taste taste);
}
