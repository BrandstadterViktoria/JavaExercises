import java.util.ArrayList;
import java.util.List;

public class Monster implements Saver{
    private String name;
    private String gender;
    private String userName;
    private int hitPoints;

    public Monster(String name, String gender, String userName, int hitPoints) {
        this.name = name;
        this.gender = gender;
        this.userName = userName;
        this.hitPoints = hitPoints;
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

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", userName='" + userName + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }

    @Override
    public List<String> writeTheValues() {
        List<String> monsterValues = new ArrayList<>();
        monsterValues.add(0, this.name);
        monsterValues.add(1, this.gender);
        monsterValues.add(2, this.userName);
        monsterValues.add(3, ""+ this.hitPoints);
        return monsterValues;
    }
}
