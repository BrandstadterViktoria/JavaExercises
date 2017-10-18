import java.util.ArrayList;
import java.util.List;

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
        return "Players{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", userName='" + userName + '\'' +
                ", hitPoints=" + hitPoints +
                ", playerValues=" + playerValues +
                '}';
    }

    @Override
    public void getValues(List<String> savedValues) {
        savedValues = writeTheValues();

    }

    @Override
    public List<String> writeTheValues() {
        List<String> values = new ArrayList<>();
        values.add(0,this.name);
        values.add(1,this.gender);
        values.add(2,this.userName);
        values.add(3, String.valueOf(this.hitPoints));
        return this.playerValues;
    }
}
