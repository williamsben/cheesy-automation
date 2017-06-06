package cheesy.model;

public enum Taste {
    HORRIBLE("Horrible"),
    SO_SO("So-So"),
    GOOD("Good"),
    DELICIOUS("Delicious");

    public String text;

    Taste(String s){ text=s; }
}
