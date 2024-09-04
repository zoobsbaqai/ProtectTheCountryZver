import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

public class gameLost {

    public static String getLastLine(String filePath) {
        String lastLine = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lastLine = currentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastLine;
    }


    public static void updateLeaderboard(String username, int score) {

        String filePath = "leaderboard.txt";
        List<String> leaderboard = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                leaderboard.add(line);
            }
        } catch (IOException e) {
            // If the file doesn't exist, it will be created later
        }

        // Add the new score
        leaderboard.add(username + " " + score);

        // Sort the leaderboard by score (from highest to lowest)
        Collections.sort(leaderboard, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int score1 = Integer.parseInt(o1.split(" ")[1]);
                int score2 = Integer.parseInt(o2.split(" ")[1]);
                return Integer.compare(score2, score1); // Sort in descending order
            }
        });

        // Write the updated leaderboard back to the file
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String entry : leaderboard) {
                writer.write(entry + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(int score) {
        String filePath = "logininfo.txt";
        String lastLine = getLastLine(filePath);
        updateLeaderboard(lastLine, score);

        JOptionPane.showMessageDialog(null, "BANKRUPT!!!\n" +
                "You have lost the game. \n" +
                "Your final score is: " + score + "!\n" +
                "Score saved under: " + lastLine);
    }
}
/*
GameLost: The main class containing methods and the main method.
int scorePoints = 500;: An instance variable to store the player's score.
getLastLine Method:

Reads the last line from a specified file.
Uses a BufferedReader to read the file line by line.
Updates the lastLine variable with each line read, so it ends up with the last line.
Returns the last line read from the file.
score Method:

Converts the scorePoints integer to a String.
Returns the string representation of scorePoints.
updateLeaderboard Method:

Reads the existing leaderboard from leaderboard.txt into a List<String>.
Adds a new entry with the username and score to the list.
Sorts the list in descending order based on scores using a custom comparator.
Writes the sorted leaderboard back to leaderboard.txt.
main Method:

Creates an instance of GameLost.
Reads the last line from logininfo.txt to get the username.
Uses the instance variable scorePoints for the score.
Calls updateLeaderboard to update the leaderboard with the new score.
Displays a message dialog with the final score and the username.
This code ensures that the leaderboard is updated correctly, with scores sorted from highest to lowest, and the new score is included appropriately. */