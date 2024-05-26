package high_low.createFile;

import java.io.*;

public class ReadAndWriteFile {

    private final File scorefile = new File("scores.txt");
    private FileWriter writeFile = null;
    private FileReader readFile = null;
    private BufferedWriter writer = null;
    private BufferedReader reader = null;

    public void CreateFile() {
        if (!scorefile.exists()) {
            try {
                scorefile.createNewFile();
                System.out.println("FILE NAME CREATED: " + scorefile.getName());
            } catch (IOException exception) {
                System.out.println("ERROR OCCURRED IN CREATING FILE");
                exception.printStackTrace();
            }
        }
    }

    public void writeData(int score) {
        try {
            readFile = new FileReader("scores.txt");
            reader = new BufferedReader(readFile);

            String tempscore = reader.readLine();
            System.out.println(Integer.parseInt(tempscore));

            writeFile = new FileWriter(scorefile);
            writer = new BufferedWriter(writeFile);

            if(score > Integer.parseInt(tempscore)) {
                tempscore = String.valueOf(score);
                writer.write(tempscore);
                writer.write("\n" + String.valueOf(score));
            } else {
                writer.write(tempscore);
                writer.write("\n" + String.valueOf(score));
            }

        } catch (Exception e) {
            System.out.println("ERROR OCCURRED IN WRITING DATA FOR SCORE");
        } finally {
            try {
                if(writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                System.out.println("ERROR OCCURRED IN CLOSING THE DATA FOR WRITING");
            }
        }
    }

    public void readData(){
        try {
            readFile = new FileReader("scores.txt");
            reader = new BufferedReader(readFile);

            System.out.println("Highscore: " + reader.readLine());
            System.out.println("Current Score: " + reader.readLine());

        } catch (Exception e) {
            System.out.println("0");
        } finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
