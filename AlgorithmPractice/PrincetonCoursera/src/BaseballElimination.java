import edu.princeton.cs.algs4.In;

import java.util.HashMap;


public class BaseballElimination {

    private int[] wins;
    private int[] losses;
    private int[][] games;
    private int[] left;
    private int size;
    private HashMap<String, Integer> teams = new HashMap<>();

    // create a baseball division from given filename in format specified below
    public BaseballElimination(String filename) {
        In read = new In(filename);
        size = Integer.valueOf(read.readLine());
        wins = new int[size];
        losses = new int[size];
        left = new int[size];
        games = new int[size][size];
        int ig = 0;
        while (read.hasNextLine()) {
            String[] line = read.readLine().split(" ");
            teams.put(line[0], ig);
            int compare = 0;
            int col = -1;
            for (int i = 1; i < line.length; i++) {
                if (line[i].trim().length() > 0) {
                    if (wins[ig] == 0) {
                        compare = i;
                        wins[ig] = Integer.valueOf(line[i]);
                    }
                    if (i == compare + 1) {
                        losses[ig] = Integer.valueOf(line[i]);
                    }
                    if (i == compare + 3) {
                        left[ig] = Integer.valueOf(line[i]);
                    }
                    if (i > compare + 3) {
                        games[ig][++col] = Integer.valueOf(line[i]);
                    }
                }
            }
            ig++;
        }
    }

    // number of teams
    public int numberOfTeams() {
        return size;

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

    /*
    // subset R of teams that eliminates given team; null if not eliminated
    public Iterable<String> certificateOfElimination(String team) {


    }*/

    public static void main(String[] args) {
        BaseballElimination division = new BaseballElimination(args[0]);
        division.teams().forEach(System.out::println);
        System.out.println(division.numberOfTeams());
        System.out.println(division.losses("Atlanta"));
        System.out.println(division.against("Atlanta","Montreal"));
        System.out.println(division.remaining("Atlanta"));
        System.out.println(division.wins("Atlanta"));

        }
    }



