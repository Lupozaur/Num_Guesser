import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private Player player;
    Random rand = new Random();

    int goalNumber = rand.nextInt(101);
    int tries = 0;


    public int mainLoop(){

        while(true){
            System.out.println("Guess the number between 1 and 100.");
            int guess = takeNumber();
            if(guess == goalNumber){
                System.out.println("You won!");

                break;
            }else if(guess > goalNumber){
                System.out.println("The guesser number is less than " + guess);
                tries++;
            }else if(guess < goalNumber){
                System.out.println("The guesser number is greater than " + guess);
                tries++;
            }
        }

        return player.getScore() - tries;
    }

    static int takeNumber(){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        return number;
    }
}
