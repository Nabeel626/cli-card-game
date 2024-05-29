package snap;

import org.card.game.Deck;
import org.card.game.Card;
import org.card.game.UserInteractions;

import java.util.Scanner;

public class SnapPlay extends Deck {
    private Player playerOne = new Player("");
    private Player playerTwo = new Player("");
    private Player currentPlayer;
    private Scanner scanner = new Scanner(System.in);
    private String playerOneName;
    private Thread timerThread;
    private String username;
    private boolean playAgain = true;

    public SnapPlay(String playerOneName) {
        resetDeck();
        shuffleDeck();
        this.playerOneName = playerOneName;
        playerNames();
    }

    private void playerNames(){
        playerOne = new Player(playerOneName);

        System.out.println("Please enter second player name");
        String playerTwoName = scanner.nextLine();
        playerTwo = new Player(playerTwoName);

        currentPlayer = playerOne;
    }

    public void playGame() {
        Card previousCard = null;
        Card currentCard = null;

        System.out.println("Let's get snapping");

        while (!deckOfCards.isEmpty()) {
            currentPlayer = (currentPlayer == playerOne) ? playerTwo : playerOne;
            System.out.println(currentPlayer.getName() + "'s turn. Press Enter to draw a card...");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("STOP")) {
                System.out.println("Returning to the menu");
                returnToMenu();
                return;
            }

            previousCard = currentCard;
            currentCard = dealCard();
            deckOfCards.remove(currentCard);

            if (previousCard != null && currentCard.getValue() == previousCard.getValue()) {
                timerThread = new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                        System.out.println("You took too long! Press enter to resume");
                    } catch (InterruptedException e) {

                    }
                });
                timerThread.start();

                String snapInput = scanner.nextLine();
                if (snapInput.equalsIgnoreCase("STOP")) {
                    System.out.println("Returning to the menu");
                    timerThread.interrupt();
                    returnToMenu();
                    return;
                } else if (snapInput.equalsIgnoreCase("q")) {
                    System.out.println(playerOne.getName() + " scores a point");
                    playerOne.incrementScore();
                    timerThread.interrupt();
                } else if (snapInput.equalsIgnoreCase("p")) {
                    System.out.println(playerTwo.getName() + " scores a point, press enter to resume");
                    playerTwo.incrementScore();
                    timerThread.interrupt();
                } else {
                    System.out.println("Invalid input. Press enter to resume");
                }
            }
        }

        System.out.println("The deck is empty, the scores are:");
        System.out.println(playerOne.getName() + "'s score is: " + playerOne.getScore());
        System.out.println(playerTwo.getName() + "'s score is: " + playerTwo.getScore());
        System.out.println("\nDo you want to play again? (yes/no)");
        String getPlayAgain = scanner.nextLine().toLowerCase();
        if (getPlayAgain.equals("yes")) {
            playAgain = true;
        } else {
            playAgain = false;
        }

    }

    private void returnToMenu() {
        SnapMenu snapMenu = new SnapMenu("Snap Game", "First to call snap", username);
        snapMenu.snapRules();
    }
}
