package org.card.game;

public class Card {

    protected String suit;
    protected String symbol;
    protected int value;

    public Card(String suit, String symbol) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = assignValue(symbol);
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int assignValue(String symbol) {

        switch (symbol) {
            case "A":
                return 14;

            case "K":
                return 13;

            case "Q":
                return 12;

            case "J":
                return 11;

            case "10":
                return 10;

            case "9":
                return 9;

            case "8":
                return 8;

            case "7":
                return 7;

            case "6":
                return 6;

            case "5":
                return 5;

            case "4":
                return 4;

            case "3":
                return 3;

            case "2":
                return 2;

            default:
                System.out.println("Nothing is there");
                return 0;
        }

    }

    @Override
    public String toString() {
        return suit + " " + symbol;
    }
}
