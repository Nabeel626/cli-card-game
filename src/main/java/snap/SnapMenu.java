package snap;

import high_low.RunGame;
import org.card.game.Game;
import org.card.game.UserInteractions;

import java.util.*;

public class SnapMenu extends Game {

    Scanner scanner = new Scanner(System.in);
    private String username;

    public SnapMenu(String title, String rules, String username){
        super(title, rules);
        this.username = username;
    }

    public void snapRules(){
        printRules();
    }

    @Override
    public void printRules() {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|                                 WELCOME TO THE SNAP GAME                              |");
        System.out.println("|                                                                                       |");
        System.out.println("|                                          RULES                                        |");
        System.out.println("|                              THE DECK WILL BE SHUFFLED                                |");
        System.out.println("|   CARDS WILL BE DRAWN ONE AT A TIME, DISPLAYED ONE AFTER THE OTHER                    |");
        System.out.println("|   IF TWO CONSECUTIVE CARDS MATCH IN VALUE, THE FIRST PLAYER TO RESPOND WINS!          |");
        System.out.println("|      PLAYER ONE ENTERS 'q' TO WIN, WHILE PLAYER TWO ENTERS 'p' TO WIN.                |");
        System.out.println("|          IF NO ONE RESPONDS IN TIME, THE GAME CONTINUES WITH THE NEXT CARD            |");
        System.out.println("|            YOU CAN QUIT BY ENTERING 'STOP' AT ANY POINT TO RETURN TO THE MENU         |");
        System.out.println("-----------------------------------------------------------------------------------------\n");
        System.out.println("             TYPE 'PLAY' TO START OR TYPE 'CLOSE' TO RETURN TO THE MAIN MENU             \n");
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
        SnapPlay snapPlay = new SnapPlay(username);
        snapPlay.playGame();
    }

    @Override
    public boolean playAgain() {

        return false;
    }

}
