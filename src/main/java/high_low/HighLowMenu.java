package high_low;

import org.card.game.Game;
import org.card.game.UserInteractions;
import java.util.Scanner;

public class HighLowMenu extends Game {

    Scanner scanner = new Scanner(System.in);
    public static final String CYAN_FONT = "\u001B[36m";

    public HighLowMenu(String title, String rules) {
        super(title, rules);
    }

    public void highLowMainMenu() {
        printRules();
    }

    @Override
    public void printRules() {
        System.out.println(CYAN_FONT + "-----------------------------------------------------------------------------------------");
        System.out.println("|                              WELCOME TO THE HIGH LOW GAME                             |");
        System.out.println("|                                                                                       |");
        System.out.println("|                                          RULES                                        |");
        System.out.println("|                              A RANDOM CARD WILL BE PICKED                             |");
        System.out.println("|  YOUR JOB IS TO GUESS THE CARD IF IT WILL BE HIGHER OR LOWER THAN THE CARD PRESENTED  |");
        System.out.println("|     YOU CAN QUIT BY ENTERING STOP AT ANY POINT AND THIS WILL RETURN YOU BACK HERE     |");
        System.out.println("-----------------------------------------------------------------------------------------\n");
        System.out.println("             TYPE 'PLAY' TO START OR TYPE 'CLOSE' TO RETURN THE MAIN MENU                \n");
        userSelection();
    }

    public void userSelection() {
        boolean runMenu = true;

        while (runMenu) {

            System.out.println("ENTER YOUR CHOICE: ");
            String userChoose = scanner.next();

            switch (userChoose) {
                case "PLAY":
                    play();
                    runMenu = false;
                    break;
                case "CLOSE":
                    UserInteractions userInteractions = new UserInteractions();
                    userInteractions.startGameMessage();
                    runMenu = false;
                    break;
                default:
                    System.out.println("PLEASE ENTER A VALID CHOICE\n");
                    break;
            }
        }
    }

    @Override
    public void play() {
        RunGame runGame = new RunGame();
        runGame.startGame();
    }

    @Override
    public boolean playAgain() {

        return false;
    }
}
