import java.util.ArrayList;
public class HungarianFootballLeagueTable < T extends Team>{

    private ArrayList<T> memmberOfTheLeague = new ArrayList<>();

    public void addTeam(T team){
        memmberOfTheLeague.add(team);
    }
}
