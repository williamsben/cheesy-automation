package cheesy.model;

import org.openqa.selenium.WebElement;

public class Cheese {
    public String name;
    public Taste taste;
    public Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Taste getTaste() {
        return taste;
    }

    public void setTaste(Taste taste) {
        this.taste = taste;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setValueFor(Column column, WebElement webElement) {
        switch (column){
            case ID:
                this.setId(Integer.parseInt(webElement.getText()));
                break;
            case CHEESE:
                this.setName(webElement.getText());
                break;
            case TASTE:
                for(Taste t : Taste.values()){
                    if(t.text.toLowerCase().equals(webElement.getText().toLowerCase())){
                        this.setTaste(t);
                        break;
                    }
                }
                break;
        }
    }
}
