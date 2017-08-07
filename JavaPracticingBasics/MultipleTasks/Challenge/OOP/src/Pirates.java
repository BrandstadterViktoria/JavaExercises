import java.util.*;

public class Pirates {

    static class Pirate {
        String name;
        boolean hashWoodenLeg;
        int gold;

        Pirate(String name, boolean hashWoodenLeg, int gold) {
            this.name = name;
            this.hashWoodenLeg = hashWoodenLeg;
            this.gold = gold;
        }
    }

    public static void main (String [] args){
        ArrayList<Pirate> pirates = new ArrayList<>();
        pirates.add(new Pirate("Olaf", false, 12));
        pirates.add(new Pirate("Uwe", true, 9));
        pirates.add(new Pirate("Jack", true, 16));
        pirates.add(new Pirate("Morgan", false, 17));
        pirates.add(new Pirate("Hook", true, 20));

    }
}
