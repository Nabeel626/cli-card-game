package high_low;

import high_low.createFile.ReadAndWriteFile;

import java.util.Scanner;

public class ShowScores {

    Scanner scanner = new Scanner(System.in);
    private boolean start = true;

    public void showScore() {

        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();

        System.out.println();
        System.out.println("-------------------------");
        System.out.println("          SCORES         ");
        readAndWriteFile.readData();
        System.out.println("-------------------------");

        System.out.println();
        System.out.println("TYPE 'BACK' TO GO BACK TO PREVIOUS SCREEN\n");

        while (start) {
            System.out.println("ENTER YOU CHOICE: ");
            String choose = scanner.next();

            switch (choose) {
                case "BACK":
                    System.out.println("RETURNING YOU BACK....\n");
                    HighLowMenu highLowMenu = new HighLowMenu("High Low Game", "randomise card to choose higher or lower");
                    highLowMenu.highLowMainMenu();
                    start = false;
                    break;

                default:
                    System.out.println("PLEASE ENTER A VALID CHOICE\n");
                    break;

            }
        }

    }

}
