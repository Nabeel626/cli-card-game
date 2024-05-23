package org.card.game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Deck deck = new Deck();
//        deck.resetDeck();
//        System.out.println();
//        deck.printDeck();
//        System.out.println();
//        deck.dealCard();
//        System.out.println();
//        deck.sortDeck((a,b) -> a.getSymbol().compareTo(b.getSymbol()));
//        System.out.println();
//        deck.shuffleDeck();

        UserInteractions userInteractions = new UserInteractions();
        userInteractions.startGameMessage();

    }
}