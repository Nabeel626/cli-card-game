package high_low;

import high_low.createFile.ReadAndWriteFile;
import org.card.game.Deck;

public class RunGame extends Deck {

    protected boolean startGameBoolean = true;

    //COULD LOOP THE ARRAY OF DECKS SO CHECK THE LENGTH IF THAT IS 0 THEN RESET CARDS AND SHUFFLE
    //EASY, MEDIUM OR HARD DIFFICULTY WITH LIVES. SO, HARD WILL HAVE A TIME LIMIT
    //COULD CREATE A LEADERBOARD STORES NAMES WITH HIGHEST POINT
    //COULD ADD MULTIPLAYER SO USER 1 WILL PLAY FIRST AND THEN USER 2????
    //WHEN FIRST STARTING THE MAIN MENU, IF THERE IS NO NAME THEN IT WILL ASK YOUR NAME. BUT IF THERE IS THEN THAT WILL BE STORED IN AN ARRAY/FILE


    public void startGame() {

        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        readAndWriteFile.CreateFile();

        ChooseDifficulty chooseDifficulty = new ChooseDifficulty();
        chooseDifficulty.difficultyLevel();

        //This will add it to the temp Array, just in case if the user gets all of them right, this is a BACKUP
//        resetDeck();
//        shuffleDeck();
//        tempDeck = deckOfCards;
//
//        //This will reset it again for the user to play
//        resetDeck();
//        shuffleDeck();

    }

}
