import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private ScoreManager scoreManager;
    Random rand = new Random();
    int goalNumber = rand.nextInt(101);
    int tries = 0;
    final int MAX_TRIES = 5;

    static void mainLoop(int selection){
        MenuOptions menu = MenuOptions.getMenu_Option(selection);
        switch (selection){
            case NEW_GAME:

        }
    }

    public void mainGame(Player player) {
        while(tries < MAX_TRIES){
            System.out.println("Guess the number between 1 and 100.");
            int guess = takeNumber();

            if(guess == goalNumber){
                int points = Math.max(0,10 - tries);
                player.addScore(points);
                System.out.println("You won!");
                break;
            }else if(guess > goalNumber){
                System.out.println("The guesser number is less than " + guess);
            }else{
                System.out.println("The guesser number is greater than " + guess);
            }
            tries++;
        }
        System.out.println("Score: " + player.getScore());
        scoreManager.saveScore(player.getScore());
    }

    static int takeNumber(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
