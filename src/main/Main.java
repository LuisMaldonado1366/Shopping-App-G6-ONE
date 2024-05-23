package main;

import models.Card;
import models.Item;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the credit card limit: ");
        double creditLimit = userInput.nextDouble();

        Card userCard = new Card(creditLimit);

        boolean loop = true;

        while (loop) {
            System.out.println("Enter the item's title: ");
            String itemTitle = userInput.next();

            System.out.println("Enter the item's value: ");
            double itemValue = userInput.nextDouble();

            Item userItem = new Item(itemValue, itemTitle);
            boolean purchasedItem = userCard.buyItem(userItem);

            if (purchasedItem) {
                System.out.printf("Purchased item: %s", userItem);
                boolean validOption = false;
                while (!validOption) {
                    System.out.println("\nTo continue press <C> or <Q> to quit.");
                    String userOption = userInput.next();
                    if (userOption.equals("q") || userOption.equals("Q")) {
                        System.out.println("Have a nice day! Come back soon.");
                        validOption = true;
                        loop = false;
                    } else if (userOption.equalsIgnoreCase("c")) {
                        validOption = true;
                    } else {
                        System.out.println("Enter a valid option!");
                    }
                }
            } else {
                System.out.printf("\nInsufficient balance:  %.2f", userCard.getBalance());
                System.out.println("\n\n\nProgram terminated.");
                loop = false;
            }
        }

    }
}