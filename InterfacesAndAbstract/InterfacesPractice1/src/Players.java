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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public ArrayList<String> getPlayerValues() {
        return playerValues;
    }

    public void setPlayerValues(ArrayList<String> playerValues) {
        this.playerValues = playerValues;
    }

    @Override
    public String toString() {

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
