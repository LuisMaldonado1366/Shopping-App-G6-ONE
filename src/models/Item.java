package models;

public class Item {
    private double value;
    private String title;

    public Item(double value, String title) {
        this.value = value;
        this.title = title;
    }

    public double getValue() {
        return value;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return "  '" + this.title + "'" +
                " - $" + this.value;

    }
}
