
public class HoghScorePosition {
    public static void main(String[] args) {

    }

    public static void displayHighScorePosition(String playername, int position) {
        System.out.println(playername + " managed to get into position " + position + " on the high score table");

    }
    public static int calculateHighScorePosition(int playerScore) {
        if (playerScore > 1000) {
            int position = 1;
            return position;
        }
        if ((playerScore > 500 && playerScore < 1000)){
            int position = 2;
            return position;
        }
        if (playerScore > 100 && playerScore < 500){
            int position = 3;
            return position;
        }
        else{int position = 4;
            return position;
        }
    }

}
