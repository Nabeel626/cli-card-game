package high_low;

import org.card.game.Deck;

import java.util.Scanner;

public class RunGame extends Deck {

    Scanner scanner = new Scanner(System.in);
    boolean gameContinue = true;

    public void startGame() {

        resetDeck();
        shuffleDeck();

        while (gameContinue) {

            dealCard();

            System.out.println("--------------------------------------------------------");
            System.out.println("| DO YOU THINK IT'S HIGHER OR LOWER THAN THE NEXT CARD |");
            System.out.println("|          TYPE 1 FOR HIGHER OR 2 FOR LOWER            |");
            System.out.println("--------------------------------------------------------\n");

            System.out.println("ENTER YOUR CHOICE: ");
            long userChoice = scanner.nextLong();

//            while (!userChoice.matches(".*[0-9].*")){
//                System.out.println("----------------------------------------------------");
//                System.out.println("|            PLEASE ONLY ENTER 1 OR 2              |");
//                System.out.println("|        TYPE 1 FOR HIGHER OR 2 FOR LOWER          |");
//                System.out.println("----------------------------------------------------\n");
//                System.out.println("ENTER YOUR CHOICE: ");
//                userChoice = scanner.nextLine();
//            }
//
            switch ((int) userChoice) {
                case 1:

                    gameContinue = false;
                    break;

                case 2:

                    gameContinue = false;
                    break;

                default:

                    break;

            }


        }

    }

}
