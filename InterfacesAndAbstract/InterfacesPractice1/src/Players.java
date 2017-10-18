import java.util.ArrayList;

public class Players implements Saver {
    private String name;
    private String gender;
    private String userName;
    private int hitPoints;
    private ArrayList<String> playerValues;

    public Players(ArrayList<String> playerValues) {
        this.playerValues = new ArrayList<>();
        this.playerValues = playerValues;
    }

    @Override
    public void getValues(ArrayList<String> savedValues) {


    }

    @Override
    public ArrayList<String> writeTheValues() {
        this.playerValues.add(name);
        this.playerValues.add(gender);
        this.playerValues.add(userName);
        this.playerValues.add(hitPoints);
        return this.playerValues;
    }
}
