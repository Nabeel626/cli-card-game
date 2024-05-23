package org.card.game;

import high_low.HighLowMenu;
import snap.SnapMenu;

import java.util.Scanner;

public class UserInteractions {

    Scanner scanner = new Scanner(System.in);
    String username;
    boolean start = true;

    public void startGameMessage() {

        System.out.println("\nWelcome \n");
        System.out.println("What's your name???");
        System.out.println("Type your name: ");
        username = scanner.nextLine();

        System.out.println("\nHi " + username + " choose a game below\n");

        while(start) {

            System.out.println("Press 1 for snap or 2 for high and low");
            System.out.println("type a number: ");
            String inputString = scanner.nextLine();

            while (!inputString.matches(".*[0-9].*")){
                System.out.println("Press 1 for snap or 2 for high and low");
                System.out.println("Only enter either 1 or 2");
                inputString = scanner.nextLine();
            }

            long input = Long.parseLong(inputString);

            switch ((int) input) {
                case 1:
                    SnapMenu snapMenu = new SnapMenu("Snap Game", "First to call snap");
                    snapMenu.snapRules();
                    start = false;
                    break;

                case 2:
                    HighLowMenu highLowMenu = new HighLowMenu("High Low Game", "randomise card to choose higher or lower");
                    highLowMenu.highLowMainMenu();
                    start = false;
                    break;

                default:
                    System.out.println("please enter a valid number");
                    break;
            }
        }

    }
}
