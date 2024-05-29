package high_low.difficulty;

import high_low.HighLowUtils;
import high_low.RunGame;
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

            RunGame runGame = new RunGame();
            runGame.livesRemaining(lives, score, gameContinue);

            continueDeck();

            runGame.showHigherLowerMenu();
            runGame.showLives(lives);
            System.out.print(HighLowUtils.CYAN_FONT + "                 CURRENT SCORE: " + score + "\n");

            System.out.println("ENTER YOUR CHOICE: ");
            String userChoiceString = scanner.next();

            while (!userChoiceString.matches(".*[0-9].*")) {
                System.out.println(HighLowUtils.CYAN_FONT + "------------------------------------");
                System.out.println("|    PLEASE ONLY ENTER 1, 2 OR 3   |");
                System.out.println("------------------------------------\n");
                System.out.println("ENTER YOUR CHOICE: ");
                userChoiceString = scanner.nextLine();
            }

            long userChoice = Long.parseLong(userChoiceString);

            switch ((int) userChoice) {
                case 1:
                    if (deckOfCards.get(0).getValue() <= deckOfCards.get(1).getValue()) {
                        System.out.println(HighLowUtils.GREEN_FONT + "CORRECT\n");
                        guessCorrect = true;
                        ++score;

                    } else {
                        System.out.println(HighLowUtils.RED_FONT + "NICE TRY, BUT THAT WAS NOT THE RIGHT ANSWER");
                    }
                    deckOfCards.remove(0);
                    break;

                case 2:
                    if (deckOfCards.get(0).getValue() >= deckOfCards.get(1).getValue()) {
                        System.out.println(HighLowUtils.GREEN_FONT + "CORRECT\n");
                        guessCorrect = true;
                        ++score;

                    } else {
                        System.out.println(HighLowUtils.RED_FONT + "NICE TRY, BUT THAT WAS NOT THE RIGHT ANSWER");
                    }
                    deckOfCards.remove(0);
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

            if (!guessCorrect) {
                lives = lives - 1;
            }

            guessCorrect = false;
        }

    }

}
