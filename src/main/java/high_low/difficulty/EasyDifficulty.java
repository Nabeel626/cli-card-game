package high_low.difficulty;

import high_low.HighLowMenu;
import high_low.RunGame;
import high_low.createFile.ReadAndWriteFile;
import org.card.game.Deck;

import java.util.Scanner;

public class EasyDifficulty extends Deck {

    Scanner scanner = new Scanner(System.in);
    protected boolean gameContinue = true;
    private boolean guessCorrect = false;
    private int lives = 8;
    protected int score;

    public void easyMode() {

        resetDeck();
        shuffleDeck();

        while (gameContinue) {

            if (lives == 0) {
                System.out.println();
                System.out.println("YOU HAVE RUN OUT OF LIVES :( \n");
                ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
//                readAndWriteFile.writeData(score);

                HighLowMenu highLowMenu = new HighLowMenu("Try Again", "randomise card to choose higher or lower");
                highLowMenu.playAgain();
                gameContinue = false;
            }

            dealCard();

            System.out.println("\n--------------------------------------------------------");
            System.out.println("| DO YOU THINK IT'S HIGHER OR LOWER THAN THE NEXT CARD |");
            System.out.println("|   TYPE 1 FOR HIGHER, 2 FOR LOWER OR 3 TO STOP GAME   |");
            System.out.println("--------------------------------------------------------\n");

            System.out.print("LIVES: ");
            for(int i = 0; i < this.lives; i++) {
                System.out.print("❤");
            }

            System.out.print("                 CURRENT SCORE: " + score + "\n");

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
                        guessCorrect = true;
                        ++score;

                    } else {
                        System.out.println("NICE TRY, BUT THAT WAS NOT THE RIGHT ANSWER");
                    }
                    deckOfCards.remove(0);
                    break;

                case 2:
                    if(deckOfCards.get(0).getValue() >= deckOfCards.get(1).getValue()) {
                        System.out.println("CORRECT\n");
                        guessCorrect = true;
                        ++score;

                    } else {
                        System.out.println("NICE TRY, BUT THAT WAS NOT THE RIGHT ANSWER");
                    }
                    deckOfCards.remove(0);
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

            if (!guessCorrect) {
                lives = lives - 1;
            }

            guessCorrect = false;
        }

    }

}
