package high_low.difficulty;

import high_low.HighLowMenu;
import high_low.HighLowUtils;
import high_low.RunGame;
import high_low.createFile.ReadAndWriteFile;
import org.card.game.Deck;

import java.util.Scanner;

public class HardDifficulty extends Deck  {

    Scanner scanner = new Scanner(System.in);
    protected boolean gameContinue = true;
    protected int score;

    public void hardMode() {

        resetDeck();
        shuffleDeck();

        while (gameContinue) {
            RunGame runGame = new RunGame();

            continueDeck();

            runGame.showHigherLowerMenu();
            System.out.println(HighLowUtils.YELLOW_FONT  + "                  CURRENT SCORE: " + score + "\n");

            System.out.println(HighLowUtils.CYAN_FONT + "ENTER YOUR CHOICE: ");
            String userChoiceString = scanner.next();

            while (!userChoiceString.matches(".*[0-9].*")){
                System.out.println(HighLowUtils.CYAN_FONT + "------------------------------------");
                System.out.println("|    PLEASE ONLY ENTER 1, 2 OR 3   |");
                System.out.println("------------------------------------\n");
                System.out.println("ENTER YOUR CHOICE: ");
                userChoiceString = scanner.nextLine();
            }

            long userChoice = Long.parseLong(userChoiceString);

            switch ((int) userChoice) {
                case 1:
                    if(deckOfCards.get(0).getValue() <= deckOfCards.get(1).getValue()) {
                        System.out.println(HighLowUtils.GREEN_FONT + "CORRECT\n");
                        deckOfCards.remove(0);
                        ++score;

                    } else {
                        System.out.println(HighLowUtils.RED_FONT + "BETTER LUCK NEXT TIME");
                        System.out.println("THE NEXT CARD WAS: \n");
                        getNextCard();
                        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
                        readAndWriteFile.writeData(score);

                        HighLowMenu highLowMenu = new HighLowMenu("Try Again", "randomise card to choose higher or lower");
                        highLowMenu.playAgain();
                        gameContinue = false;
                    }
                    break;

                case 2:
                    if(deckOfCards.get(0).getValue() >= deckOfCards.get(1).getValue()) {
                        System.out.println(HighLowUtils.GREEN_FONT + "CORRECT\n");
                        deckOfCards.remove(0);
                        ++score;

                    } else {
                        System.out.println(HighLowUtils.RED_FONT + "BETTER LUCK NEXT TIME");
                        System.out.println("THE NEXT CARD WAS: \n");
                        getNextCard();
                        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
                        readAndWriteFile.writeData(score);

                        HighLowMenu highLowMenu = new HighLowMenu("Try Again", "randomise card to choose higher or lower");
                        highLowMenu.playAgain();
                        gameContinue = false;
                    }
                    break;

                case 3:
                    System.out.println(HighLowUtils.YELLOW_FONT + "LOADING.......");
                    System.out.println("RETURNING BACK TO MAIN MENU!!!");
                    runGame.startGame();
                    gameContinue = false;
                    break;

                default:
                    System.out.println(HighLowUtils.YELLOW_FONT + "ENTER A VALID CHOICE");
                    break;

            }

        }

    }

}
