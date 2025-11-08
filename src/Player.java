public class Player {

    private final String username;
    private int score;

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public Player(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        return username + " (" + score + ")";
    }

}
