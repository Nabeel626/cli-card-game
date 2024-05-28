package high_low.difficulty;

import high_low.RunGame;
import org.card.game.Deck;

import java.util.Scanner;

public class MediumDifficulty extends Deck {

    Scanner scanner = new Scanner(System.in);
    protected boolean gameContinue = true;
    private boolean guessCorrect = false;
    private int lives = 4;
    protected int score;

    public void mediumMode() {

        resetDeck();
        shuffleDeck();

        while (gameContinue) {

            RunGame runGame = new RunGame();
            runGame.livesRemaining(lives, score, gameContinue);

            dealCard();

            continueDeck();

            runGame.showHigherLowerMenu();
            runGame.showLives(lives);
            System.out.print("                   CURRENT SCORE: " + score + "\n");

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
