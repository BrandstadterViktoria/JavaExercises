import edu.princeton.cs.algs4.In;
import java.util.HashMap;


public class BaseballElimination {

    private int [] wins;
    private int [] losses;
    private int [][] games;
    private int [] left;
    private HashMap<String,Integer> teams = new HashMap<>();

    // create a baseball division from given filename in format specified below
    public BaseballElimination(String filename) {
        In read = new In(filename);
        int size = Integer.valueOf(read.readLine());
        wins = new int[size];
        losses = new int[size];
        left = new int[size];
        games = new int[size][size];
        int ig = 0;
        while (read.hasNextLine()) {
        int index = -1;
        int il = 0;
        String []line = read.readLine().split(" ");
        teams.put(line[0],ig);
        wins[++index] = Integer.valueOf(line[++il]);
        losses[index] = Integer.valueOf(line[++il]);
        left[index] = Integer.valueOf(line[++il]);
            for (int i = 0; i < size; i++) {
                games[ig][i] = Integer.valueOf(line[++il]);
            }
            ig++;
        }
    }

    // number of teams
    public int numberOfTeams() {
    return teams.size();

    }

    // all teams
    public Iterable<String> teams() {
        return teams.keySet();

    }

    // number of wins for given team
    public int wins(String team) {
        return wins[teams.get(team)];

    }

    // number of losses for given team
    public int losses(String team) {
        return losses[teams.get(team)];

    }

    // number of remaining games for given team
    public int remaining(String team) {
        return left[teams.get(team)];

    }

    // number of remaining games between team1 and team2
    public int against(String team1, String team2) {
        return games[teams.get(team1)][teams.get(team2)];
    }

    // is given team eliminated?
    public boolean isEliminated(String team) {


    }

    // subset R of teams that eliminates given team; null if not eliminated
    public Iterable<String> certificateOfElimination(String team) {


    }*/


}
