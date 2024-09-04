import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//zohair
public class stats {

    //the main calls the methods
    public static void main(String[] args) {
        List<String> userNames = readUserNamesFromFile("leaderboard.txt");
        displayUserNamesInMessageBox(userNames);
    }

    //this method gets the usernames
    private static List<String> readUserNamesFromFile(String fileName) {
        List<String> userNames = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userNames.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userNames;
    }

    //this method prints the usernames
    private static void displayUserNamesInMessageBox(List<String> userNames) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < userNames.size(); i++) {
            sb.append((i + 1) + ". ").append(userNames.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Leaderboard", JOptionPane.INFORMATION_MESSAGE);
    }
}