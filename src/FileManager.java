import java.io.File;
import java.io.IOException;

public class FileManager {

    public static File checkOrCreateFile(Player player){
        String fileName = player.getUsername() + ".txt";
        File file = new File(fileName);

        if(file.exists()){
            System.out.println("Welcome back " + player.getUsername() + " to Num Guesser!");
        }else{
            try{
                if(file.createNewFile()){
                    System.out.println("Let's play!");
                }else{
                    System.out.println("Error!");
                }
            }catch(IOException e){
                System.out.println("Something went wrong!" + e.getMessage());
            }
        }
        return file;
    }
}
