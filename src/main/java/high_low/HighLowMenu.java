package high_low;

import org.card.game.Game;
import org.card.game.UserInteractions;

import java.util.Scanner;

public class HighLowMenu extends Game {

    Scanner scanner = new Scanner(System.in);

    public HighLowMenu(String title, String rules) {
        super(title, rules);
    }

    public void highLowMainMenu() {
        printRules();
    }

    @Override
    public void printRules() {
        System.out.println(HighLowUtils.CYAN_FONT + "-----------------------------------------------------------------------------------------");
        System.out.println("|                              WELCOME TO THE HIGH LOW GAME                             |");
        System.out.println("|                                                                                       |");
        System.out.println("|                                          RULES                                        |");
        System.out.println("|                              A RANDOM CARD WILL BE PICKED                             |");
        System.out.println("|  YOUR JOB IS TO GUESS THE CARD IF IT WILL BE HIGHER OR LOWER THAN THE CARD PRESENTED  |");
        System.out.println("|   YOU CAN QUIT THE GAME BY STOPPING AT ANY POINT AND THIS WILL RETURN YOU BACK HERE   |");
        System.out.println("-----------------------------------------------------------------------------------------\n");
        System.out.println("TYPE 'PLAY' TO START, TYPE 'SHOW' TO SHOW SCORES OR TYPE 'CLOSE' TO RETURN THE MAIN MENU\n");
        userSelection();
    }

    public void userSelection() {
        boolean runMenu = true;

        while (runMenu) {

            System.out.println(HighLowUtils.CYAN_FONT + "ENTER YOUR CHOICE: ");
            String userChoose = scanner.next();

            switch (userChoose) {
                case "PLAY":
                    play();
                    runMenu = false;
                    break;
                case "SHOW":
                    ShowScores showScores = new ShowScores();
                    showScores.showScore();
                    runMenu = false;
                    break;
                case "CLOSE":
                    UserInteractions userInteractions = new UserInteractions();
                    userInteractions.startGameMessage();
                    runMenu = false;
                    break;
                default:
                    System.out.println(HighLowUtils.YELLOW_FONT + "PLEASE ENTER A VALID CHOICE\n");
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
        Scanner scanner1 = new Scanner(System.in);

        System.out.println(HighLowUtils.CYAN_FONT + "\nWOULD YOU LIKE TO PLAY AGAIN");
        System.out.println("TYPE 'Y' FOR YES OR 'N' FOR NO ");

        while (true) {
            System.out.println(HighLowUtils.CYAN_FONT + "\nENTER CHOICE:  ");
            String choose = scanner1.next();

            switch (choose) {
                case "Y":
                    ChooseDifficulty chooseDifficulty = new ChooseDifficulty();
                    chooseDifficulty.difficultyLevel();
                    return false;

                case "N":
                    UserInteractions userInteractions = new UserInteractions();
                    userInteractions.startGameMessage();
                    return false;

                default:
                    System.out.println(HighLowUtils.YELLOW_FONT + "\nENTER A VALID CHOICE");
                    break;
            }
        }

    }
}
