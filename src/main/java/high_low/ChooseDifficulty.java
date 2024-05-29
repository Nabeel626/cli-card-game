package high_low;

import high_low.difficulty.EasyDifficulty;
import high_low.difficulty.HardDifficulty;
import high_low.difficulty.MediumDifficulty;
import org.card.game.UserInteractions;

import java.util.Scanner;

public class ChooseDifficulty extends RunGame {

    public void difficultyLevel() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(HighLowUtils.CYAN_FONT + "\n-------------------------------------------------------------------------------------------");
        System.out.println("|                                    CHOOSE DIFFICULTY                                    |");
        System.out.println("|                                                                                         |");
        System.out.println("|                       WOULD YOU LIKE TO PLAY EASY, MEDIUM OR HARD                       |");
        System.out.println("|             EASY HAS 8 LIVES, MEDIUM HAS 4 LIVES AND HARD IS UNTIL YOU LOSE             |");
        System.out.println("|   TYPE 1 FOR EASY, 2 FOR MEDIUM, 3 FOR HARD OR 4 TO STOP AND GO BACK TO THE MAIN MENU   |");
        System.out.println("-------------------------------------------------------------------------------------------\n");

        while (startGameBoolean) {

            System.out.println(HighLowUtils.CYAN_FONT + "ENTER YOUR CHOICE: ");
            String chooseDifficultyString = scanner.next();

            while (!chooseDifficultyString.matches(".*[0-9].*")){
                System.out.println(HighLowUtils.CYAN_FONT + "---------------------------------------");
                System.out.println("|    PLEASE ONLY ENTER 1, 2, 3 OR 4   |");
                System.out.println("---------------------------------------\n");
                System.out.println("ENTER YOUR CHOICE: ");
                chooseDifficultyString = scanner.nextLine();
            }

            long difficultyChoose = Long.parseLong(chooseDifficultyString);

            switch ((int) difficultyChoose) {
                case 1:
                    EasyDifficulty easyDifficulty = new EasyDifficulty();
                    easyDifficulty.easyMode();
                    startGameBoolean = false;
                    break;
                case 2:
                    MediumDifficulty mediumDifficulty = new MediumDifficulty();
                    mediumDifficulty.mediumMode();
                    startGameBoolean = false;
                    break;
                case 3:
                    HardDifficulty hardDifficulty = new HardDifficulty();
                    hardDifficulty.hardMode();
                    startGameBoolean = false;
                    break;
                case 4:
                    System.out.println(HighLowUtils.CYAN_FONT + "LOADING.......");
                    System.out.println("RETURNING BACK TO MAIN MENU!!!");
                    UserInteractions userInteractions = new UserInteractions();
                    userInteractions.startGameMessage();
                    startGameBoolean = false;
                    break;
                default:
                    System.out.println(HighLowUtils.CYAN_FONT + "ENTER A VALID CHOICE");
                    break;

            }
        }

    }

}
