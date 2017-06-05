package cheesy.model;

/**
 * Created by billiams on 6/5/17.
 */
public enum Taste {
    HORRIBLE("Horrible"),
    SO_SO("So-So"),
    GOOD("Good"),
    DELICIOUS("Delicious");

    public String text;

    Taste(String s){ text=s; }
}
