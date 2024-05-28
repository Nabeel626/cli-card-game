package org.card.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck {

    protected List<Card> deckOfCards;
    final String[] suit = {"HEARTS ♥", "CLUBS ♣", "DIAMONDS ♦", "SPADES ♠"};
    final String[] symbol = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};


    public void dealCard() {
        System.out.println(deckOfCards.get(0));
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
    }

    public void resetDeck() {

        deckOfCards = new ArrayList<>(52);

        for(String suitArray : suit) {
            for(String symbolArray : symbol) {
                deckOfCards.add(new Card(suitArray, symbolArray));
            }
        }

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
        }

    }

}
