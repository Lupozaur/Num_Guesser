import java.awt.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private final ScoreManager scoreManager;
    private final Scanner in;
    private final Random rand = new Random();

    int goalNumber;
    int tries;
    private static final int MAX_TRIES = 5;

    public GameLogic(ScoreManager scoreManager, Scanner in) {
        this.scoreManager = scoreManager;
        this.in = in;
    }

    public void run(Player player) {
        boolean gameOver = false;
        while(!gameOver){
            MenuOptions.displayMenu();
            int choice = readInt("Choose option: ");
            System.out.println("Choose option: ");
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

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return in.nextInt();
            }catch (InputMismatchException e) {
                in.nextLine();
                System.out.print("Invalid input! Please try again.");
            }
        }
    }
}
