package high_low;

import high_low.createFile.ReadAndWriteFile;
import org.card.game.Deck;

public class RunGame extends Deck {

    protected boolean startGameBoolean = true;

    //COULD CREATE A LEADERBOARD STORES NAMES WITH HIGHEST POINT
    //WHEN FIRST STARTING THE MAIN MENU, IF THERE IS NO NAME THEN IT WILL ASK YOUR NAME. BUT IF THERE IS THEN THAT WILL BE STORED IN AN ARRAY/FILE


    public void startGame() {

        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        readAndWriteFile.CreateFile();

        ChooseDifficulty chooseDifficulty = new ChooseDifficulty();
        chooseDifficulty.difficultyLevel();

    }

    public void livesRemaining(int lives, int score, boolean gameContinue) {
        if (lives == 0) {
            System.out.println();
            System.out.println("YOU HAVE RUN OUT OF LIVES :( \n");
            ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
            readAndWriteFile.writeData(score);

            HighLowMenu highLowMenu = new HighLowMenu("Try Again", "randomise card to choose higher or lower");
            highLowMenu.playAgain();
            gameContinue = false;
        }
    }

    public void showLives(int lives) {
        System.out.print("LIVES: ");
        for(int i = 0; i < lives; i++) {
            System.out.print("❤");
        }
    }

    public void showHigherLowerMenu() {
        System.out.println("\n--------------------------------------------------------");
        System.out.println("| DO YOU THINK IT'S HIGHER OR LOWER THAN THE NEXT CARD |");
        System.out.println("|   TYPE 1 FOR HIGHER, 2 FOR LOWER OR 3 TO STOP GAME   |");
        System.out.println("--------------------------------------------------------\n");
    }

}
