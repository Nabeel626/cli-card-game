package org.card.game;

public abstract class Game {
    private final String title;
    private final String rules;

    public Game(String title, String rules) {
        this.title = title;
        this.rules = rules;
    }
    public void printTitle() {
        System.out.println(title);
    }

    public void printRules() {
        System.out.println(rules);
    }

    public abstract void play();

    public abstract boolean playAgain();
}
