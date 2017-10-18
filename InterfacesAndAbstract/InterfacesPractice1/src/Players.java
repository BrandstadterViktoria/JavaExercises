import java.util.ArrayList;
import java.util.List;

public class Players implements Saver {
    private String name;
    private String gender;
    private String userName;
    private int hitPoints;

    public Players(String name, String gender, String userName, int hitPoints) {
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
        return "Players{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", userName='" + userName + '\'' +
                ", hitPoints=" + hitPoints +
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
        return values;
    }
}
