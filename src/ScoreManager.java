import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class ScoreManager {

    public void saveScore(String username, int score){
        String line = LocalDate.now() + "|" + username + "|" + score + "\n";

        try(FileWriter fw = new FileWriter(username + ".txt", true)){
            fw.write(line + System.lineSeparator());
        }catch(IOException e){
            System.out.println("Error saving score" + e.getMessage());
        }
    }

    public void printScores(Player player) {
        Path file = Path.of(player.getUsername() + ".txt");
        try {
            if (!Files.exists(file)) {
                System.out.println("No results for: " + player.getUsername());
                return;
            }
            Files.readAllLines(file).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Reading results error " + e.getMessage());
        }
    }


}
