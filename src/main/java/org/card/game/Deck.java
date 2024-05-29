package org.card.game;

import high_low.HighLowUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck {

    protected List<Card> deckOfCards;
    final String[] suit = {"♥", "♣", "♦", "♠"};
    final String[] symbol = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public void dealCard() {
        if(deckOfCards.get(0).getValue() == 10){
            System.out.println(HighLowUtils.YELLOW_FONT + "┌────────────────┐");
            System.out.println("│ " + deckOfCards.get(0).getSymbol() + "             │");
            System.out.println("│           " + deckOfCards.get(0).getSuit() + "\u200A \u200A  \u200A│");
            System.out.println("│                │");
            System.out.println("│       " + deckOfCards.get(0).getSuit() + "\u200A     \u200A  \u200A│");
            System.out.println("│                │");
            System.out.println("│   " + deckOfCards.get(0).getSuit() + "\u200A    \u200A       \u200A│");
            System.out.println("│             " + deckOfCards.get(0).getSymbol() + " │");
            System.out.println("└────────────────┘");
        } else {
            System.out.println(HighLowUtils.YELLOW_FONT + "┌────────────────┐");
            System.out.println("│ " + deckOfCards.get(0).getSymbol() + "              │");
            System.out.println("│           " + deckOfCards.get(0).getSuit() + "\u200A \u200A \u200A │");
            System.out.println("│                │");
            System.out.println("│       " + deckOfCards.get(0).getSuit() + "\u200A  \u200A   \u200A  │");
            System.out.println("│                │");
            System.out.println("│   " + deckOfCards.get(0).getSuit() + "\u200A     \u200A    \u200A  │");
            System.out.println("│              " + deckOfCards.get(0).getSymbol() + " │");
            System.out.println("└────────────────┘");
        }
    }

//    public Card dealCard() {
//        System.out.println(deckOfCards.get(0));
//        return deckOfCards.get(0);
//    }

    public void getNextCard() {
        if(deckOfCards.get(1).getValue() == 10){
            System.out.println(HighLowUtils.YELLOW_FONT + "┌────────────────┐");
            System.out.println("│ " + deckOfCards.get(1).getSymbol() + "             │");
            System.out.println("│           " + deckOfCards.get(1).getSuit() + "\u200A \u200A  \u200A│");
            System.out.println("│                │");
            System.out.println("│       " + deckOfCards.get(1).getSuit() + "\u200A     \u200A  \u200A│");
            System.out.println("│                │");
            System.out.println("│   " + deckOfCards.get(1).getSuit() + "\u200A    \u200A       \u200A│");
            System.out.println("│             " + deckOfCards.get(1).getSymbol() + " │");
            System.out.println("└────────────────┘");
        } else {
            System.out.println(HighLowUtils.YELLOW_FONT + "┌────────────────┐");
            System.out.println("│ " + deckOfCards.get(1).getSymbol() + "              │");
            System.out.println("│           " + deckOfCards.get(1).getSuit() + "\u200A \u200A \u200A │");
            System.out.println("│                │");
            System.out.println("│       " + deckOfCards.get(1).getSuit() + "\u200A  \u200A   \u200A  │");
            System.out.println("│                │");
            System.out.println("│   " + deckOfCards.get(1).getSuit() + "\u200A     \u200A    \u200A  │");
            System.out.println("│              " + deckOfCards.get(1).getSymbol() + " │");
            System.out.println("└────────────────┘");
        }
    }

    public void sortDeck() {

        deckOfCards.sort((a,b) -> a.getValue() - b.getValue());
        System.out.println(deckOfCards);

    }

    public void sortDeck(Comparator<Card> comparator) {

        deckOfCards.sort(comparator);
        System.out.println(deckOfCards);
    }

    public void shuffleDeck() {

        Collections.shuffle(deckOfCards);
        System.out.println(deckOfCards);

    }

    public void resetDeck() {

        deckOfCards = new ArrayList<>(52);

        for(String suitArray : suit) {
            for(String symbolArray : symbol) {
                deckOfCards.add(new Card(suitArray, symbolArray));
            }
        }

        System.out.println(deckOfCards);

    }

    public void printDeck() {

        for(Card card : deckOfCards) {
            System.out.println(card);
        }
    }

    public void continueDeck() {
        if(deckOfCards.isEmpty()) {
            resetDeck();
            shuffleDeck();
            dealCard();
        } else {
            dealCard();
        }
    }

}
