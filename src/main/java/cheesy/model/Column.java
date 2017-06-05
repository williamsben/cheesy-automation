package cheesy.model;

/**
 * Created by billiams on 6/5/17.
 */
public enum Column {
    ID("ID"),
    CHEESE("Cheese"),
    TASTE("Taste");

    public String text;

    Column(String s){ text=s; }
}
