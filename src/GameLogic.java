import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private final ScoreManager scoreManager;
    private final Scanner in;
    private final Random rand = new Random();

    int goalNumber;
    int tries;
    private static final int MAX_TRIES = 10;

    public GameLogic(ScoreManager scoreManager, Scanner in) {
        this.scoreManager = scoreManager;
        this.in = in;
    }

    public void run(Player player) {
        boolean gameOver = false;
        while(!gameOver){
            MenuOptions.displayMenu();
            int choice = readInt();
            MenuOptions option = MenuOptions.getMenu_Option(choice);


            if(option == null){
                System.out.println("Wrong option");
                continue;
        }
        switch (option){
            case NEW_GAME -> mainGame(player);
            case SCORE -> scoreManager.printScores(player);
            case EXIT ->  gameOver = true;
            }
        }
        System.out.println("Goodbye!");
    }

    public void mainGame(Player player){
        tries = 0;
        goalNumber = 1 + rand.nextInt(1, 100);

        System.out.println("Game started!");
        System.out.println("Guess number between 1 and 100. You have " + MAX_TRIES + " tries.");

        while(tries < MAX_TRIES){
            int guessNumber = in.nextInt();

            if(guessNumber == goalNumber){
                int points = Math.max(0, 10 - tries);
                player.addScore(points);
                saveScoreSafe(player);
                System.out.println("You have " + points + " points.");
                return;
            }
            if(guessNumber > goalNumber){
                System.out.println("Too much! " + (MAX_TRIES - tries) + " tries left." );
            }else{
                System.out.println("Too little! " + (MAX_TRIES - tries) + " tries left.");
            }
            tries++;
        }
        System.out.println("End of tries! The number of guesses was " + goalNumber + ".");
        saveScoreSafe(player);
    }

    private int readInt() {
        while (true) {
            System.out.print("Choose option: ");
            try {
                return in.nextInt();
            }catch (InputMismatchException e) {
                in.nextLine();
                System.out.print("Invalid input! Please try again.");
            }
        }
    }

    private void saveScoreSafe(Player player){
        try{
            scoreManager.saveScore(player.getUsername(), player.getScore());
        }catch (Exception e){
            System.out.println("Error saving score!");
        }
    }
}
