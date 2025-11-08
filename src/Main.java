import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Num Guesser Game!");
        System.out.println("Enter your name: ");
        String nickname = scanner.nextLine();

        Player player = new Player(nickname);
        ScoreManager scoreManager = new ScoreManager();
        GameLogic game = new GameLogic(scoreManager, scanner);

        game.run(player);

        scanner.close();












    }
}
