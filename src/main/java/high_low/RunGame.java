package high_low;

import high_low.createFile.ReadAndWriteFile;
import org.card.game.Deck;

public class RunGame extends Deck {

    protected boolean startGameBoolean = true;

    public void startGame() {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        readAndWriteFile.CreateFile();

        ChooseDifficulty chooseDifficulty = new ChooseDifficulty();
        chooseDifficulty.difficultyLevel();
    }

    public void livesRemaining(int lives, int score, boolean gameContinue) {
        if (lives == 0) {
            System.out.println();
            System.out.println(HighLowUtils.RED_FONT + "YOU HAVE RUN OUT OF LIVES :( \n");
            System.out.println("THE NEXT CARD WAS: \n");
            getNextCard();

            ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
            readAndWriteFile.writeData(score);

            HighLowMenu highLowMenu = new HighLowMenu("Try Again", "randomise card to choose higher or lower");
            highLowMenu.playAgain();
            gameContinue = false;
        }
    }

    public void showLives(int lives) {
        System.out.print(HighLowUtils.YELLOW_FONT + "LIVES: ");
        for(int i = 0; i < lives; i++) {
            System.out.print(HighLowUtils.YELLOW_FONT + "❤");
        }
    }

    public void showHigherLowerMenu() {
        System.out.println(HighLowUtils.CYAN_FONT + "\n--------------------------------------------------------");
        System.out.println("| DO YOU THINK IT'S HIGHER OR LOWER THAN THE NEXT CARD |");
        System.out.println("|   TYPE 1 FOR HIGHER, 2 FOR LOWER OR 3 TO STOP GAME   |");
        System.out.println("--------------------------------------------------------\n");
    }

}
