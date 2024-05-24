package models;

public class Item implements Comparable<Item>{
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

    @Override
    public int compareTo(Item otherItem) {
        return Double.compare(this.value, otherItem.value);
    }
}
