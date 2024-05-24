package main;

import models.Card;
import models.Item;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        try {
            System.out.println("Enter the credit card limit: ");
            double creditLimit = userInput.nextDouble();
            boolean loop = true;
            Card userCard = new Card(creditLimit);

            while (loop) {
                System.out.println("\nEnter the item's title: ");
                String itemTitle = userInput.next();

                System.out.println("Enter the item's value: ");
                double itemValue = userInput.nextDouble();

                Item userItem = new Item(itemValue, itemTitle);
                boolean purchasedItem = userCard.buyItem(userItem);

                if (purchasedItem) {
                    System.out.printf("\n\tPurchased item: %s", userItem);
                    System.out.printf("\nBalance: %.2f", userCard.getBalance());
                    boolean validOption = false;
                    while (!validOption) {
                        System.out.println("\n\nTo continue press <C> or <Q> to quit.");
                        String userOption = userInput.next();
                        if (userOption.equals("q") || userOption.equals("Q")) {
                            validOption = true;
                            loop = false;
                        } else if (userOption.equalsIgnoreCase("c")) {
                            validOption = true;
                        } else {
                            System.out.println("\n\nEnter a valid option!");
                        }
                    }
                } else {
                    System.out.printf("\nInsufficient balance:  %.2f", userCard.getBalance());
                    loop = false;
                }
            }

            System.out.println("\n******************************************");
            System.out.println("Purchasing List: \n");

            Collections.sort(userCard.getItemList());

            for (Item item : userCard.getItemList()) {
                System.out.println("\t" + item.getTitle() + " - " + item.getValue());
            }
            System.out.println("\n******************************************");
            System.out.printf("Total balance: %.2f", userCard.getBalance());
            System.out.println("\n******************************************");
            System.out.println("\n\nHave a nice day! Come back soon.");

        } catch (Exception e) {

            System.out.println("Enter a valid data!");

        }
    }
}