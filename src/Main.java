import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Num Guesser Game!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String nickname = scanner.nextLine();
        Player player = new Player(nickname);












    }

    static void DisplayMenu() {
        System.out.println("""
                [1] New Game
                [2] Load Game
                [3] Quit
                """);
    }
}
