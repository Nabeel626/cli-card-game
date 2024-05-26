package high_low.difficulty;

import high_low.HighLowMenu;
import high_low.RunGame;
import high_low.createFile.ReadAndWriteFile;
import org.card.game.Deck;

import java.util.Scanner;

public class HardDifficulty extends Deck  {

    Scanner scanner = new Scanner(System.in);
    protected boolean gameContinue = true;
    protected int score;
    protected int highscore;

    public void hardMode() {

        resetDeck();
        shuffleDeck();

        while (gameContinue) {

            dealCard();

            System.out.println("\n--------------------------------------------------------");
            System.out.println("| DO YOU THINK IT'S HIGHER OR LOWER THAN THE NEXT CARD |");
            System.out.println("|   TYPE 1 FOR HIGHER, 2 FOR LOWER OR 3 TO STOP GAME   |");
            System.out.println("--------------------------------------------------------");

            System.out.println("                  CURRENT SCORE: " + score + "\n");

            System.out.println("ENTER YOUR CHOICE: ");
            String userChoiceString = scanner.next();

            while (!userChoiceString.matches(".*[0-9].*")){
                System.out.println("------------------------------------");
                System.out.println("|    PLEASE ONLY ENTER 1, 2 OR 3   |");
                System.out.println("------------------------------------\n");
                System.out.println("ENTER YOUR CHOICE: ");
                userChoiceString = scanner.nextLine();
            }

            long userChoice = Long.parseLong(userChoiceString);

            switch ((int) userChoice) {
                case 1:
                    if(deckOfCards.get(0).getValue() <= deckOfCards.get(1).getValue()) {
                        System.out.println("CORRECT\n");
                        deckOfCards.remove(0);
                        ++score;

                    } else {
                        System.out.println("BETTER LUCK NEXT TIME");
                        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
                        readAndWriteFile.writeData(score);

                        HighLowMenu highLowMenu = new HighLowMenu("Try Again", "randomise card to choose higher or lower");
                        highLowMenu.playAgain();
                        gameContinue = false;
                    }
                    break;

                case 2:
                    if(deckOfCards.get(0).getValue() >= deckOfCards.get(1).getValue()) {
                        System.out.println("CORRECT\n");
                        deckOfCards.remove(0);
                        ++score;

                    } else {
                        System.out.println("BETTER LUCK NEXT TIME");
                        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
                        readAndWriteFile.writeData(score);

                        HighLowMenu highLowMenu = new HighLowMenu("Try Again", "randomise card to choose higher or lower");
                        highLowMenu.playAgain();
                        gameContinue = false;
                    }
                    break;

                case 3:
                    System.out.println("LOADING.......");
                    System.out.println("RETURNING BACK TO MAIN MENU!!!");
                    RunGame runGame = new RunGame();
                    runGame.startGame();
                    gameContinue = false;
                    break;

                default:
                    System.out.println("ENTER A VALID CHOICE");
                    break;

            }

        }

    }

}
