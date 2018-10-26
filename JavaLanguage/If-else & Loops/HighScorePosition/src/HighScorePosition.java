
public class HighScorePosition {
    public static void main(String[] args) {

        int position = calculateHighScorePosition(1500);
        displayHighScorePosition("Martin", position);

        position = calculateHighScorePosition(900);
        displayHighScorePosition("Frederick", position);

        position = calculateHighScorePosition(400);
        displayHighScorePosition("Walter", position);

        position = calculateHighScorePosition(50);
        displayHighScorePosition("Tim", position);

    }

    public static void displayHighScorePosition(String playername, int position) {
        System.out.println(playername + " managed to get into position " + position + " on the high score table");

    }

    public static int calculateHighScorePosition(int playerScore) {
        if (playerScore > 1000) {
            int position = 1;
            return position;
        }
        if ((playerScore > 500 && playerScore < 1000)) {
            int position = 2;
            return position;
        }
        if (playerScore > 100 && playerScore < 500) {
            int position = 3;
            return position;
        } else {
            int position = 4;
            return position;
        }
    }

}
