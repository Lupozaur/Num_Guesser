import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScoreManager {
    private Player player;

    public void saveScore(int score){
        String line = LocalDate.now() + "|" + player.getUsername() + "|" + player.getScore();

        try(FileWriter fw = new FileWriter(player.getUsername() + ".txt", true)){
            fw.write(line + System.lineSeparator());
        }catch(IOException e){
            System.out.println("Error saving score" + e.getMessage());
        }
    }
}
