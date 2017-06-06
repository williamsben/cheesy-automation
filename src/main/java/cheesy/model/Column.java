package cheesy.model;

public enum Column {
    ID("ID"),
    CHEESE("Cheese"),
    TASTE("Taste");

    public String text;

    Column(String s){ text=s; }
}
