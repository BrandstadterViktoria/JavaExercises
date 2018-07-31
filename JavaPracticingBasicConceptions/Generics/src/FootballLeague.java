import java.util.ArrayList;

public class FootballLeague<T extends Team> implements Comparable<FootballLeague<T>> {
    private String name;
    private int numberOfWins = 0;
    private int numberOfLoss = 0;
    private int scoreIsTied = 0;

    private ArrayList<T> memberOfTheLeague = new ArrayList<>();

    public FootballLeague(String name) {
        this.name = name;
    }

    public void addTeam(T team) {
        memberOfTheLeague.add(team);
    }

    public void showLeagueTable() {
//        Collections.sort();
    }

    public void playMatch(FootballLeague<T> otherTeam, int scoreTeam1, int scoreTeam2) {
        if (scoreTeam1 < scoreTeam1) {
            numberOfWins++;
        } else if (scoreTeam1 == scoreTeam2) {
            scoreIsTied++;
        } else numberOfLoss++;
    }

    public int ranking() {
        return numberOfWins * 2 + scoreIsTied - numberOfLoss;
    }

    @Override
    public int compareTo(FootballLeague<T> footballLeague) {
        if (this.ranking() > footballLeague.ranking()) {
            return -1;
        } else if (this.ranking() < footballLeague.ranking()) {
            return 1;
        } else {
            return 0;
        }

    }
}
