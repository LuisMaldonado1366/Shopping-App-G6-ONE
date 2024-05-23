package models;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Card {

    private double creditLimit;
    private double balance;
    private List<Item> itemList;

    public Card(double creditLimit) {

        this.creditLimit = creditLimit;
        this.balance = creditLimit;
        this.itemList = new ArrayList<>();

    }

    public boolean buyItem(Item item) {
        boolean result = false;

        if (this.balance >= item.getValue()) {
            this.balance -= item.getValue();
            this.itemList.add(item);
            result = true;
        }
        return result;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
