package org.card.game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deck deck = new Deck();
        deck.resetDeck();
        System.out.println();
        deck.printDeck();
        System.out.println();
        deck.dealCard();
        System.out.println();
        deck.sortDeck((a,b) -> a.getSymbol().compareTo(b.getSymbol()));
        System.out.println();
        deck.shuffleDeck();

        System.out.println("press 1 for snap or 2 for high and low");
        System.out.println("type a number: ");
        long input = scanner.nextLong();

        switch ((int) input) {

            case 1:

                break;

            case 2:

                break;

            default:
                System.out.println("please enter a valid number");
                break;
        }

    }
}