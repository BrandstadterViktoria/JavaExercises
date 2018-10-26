import java.util.*;


public class Pirates {

    static class Pirate {
        private static boolean hashWoodenLeg;
        private static String name;
        private static int gold;

        public Pirate(String name, boolean hashWoodenLeg, int gold) {
            this.name = name;
            this.hashWoodenLeg = hashWoodenLeg;
            this.gold = gold;
        }

        public static int getGold() {
            return gold;
        }

        public static String getName() {
            return name;
        }

        public static boolean gethashWoodenLeg() {
            return hashWoodenLeg;

        }
    }

    public static void main(String[] args) {
        ArrayList<Pirate> pirates = new ArrayList<>();
        Pirate pirate1 = (new Pirate("Olaf", false, 12));
        Pirate pirate2 = (new Pirate("Uwe", true, 9));
        Pirate pirate3 = (new Pirate("Jack", true, 16));
        Pirate pirate4 = (new Pirate("Morgan", false, 17));
        Pirate pirate5 = (new Pirate("Hook", true, 20));

        pirates.add(pirate1);
        pirates.add(pirate2);
        pirates.add(pirate3);
        pirates.add(pirate4);
        pirates.add(pirate5);

        pirateCounter(pirates);

    }

    public static ArrayList<String> pirateCounter(ArrayList<Pirate> inputPirates) {
        ArrayList<String> pirateNames = new ArrayList<>();
        ArrayList<Pirate> countedPirates = new ArrayList<>();
        for (int i = 0; i < inputPirates.size(); i++) {
            if (Pirate.gethashWoodenLeg() && (Pirate.getGold() < 15)) {
                countedPirates.add(inputPirates.get(i));
            }
        }
            for (int j = 0; j < countedPirates.size(); j++) {
                String names = Pirate.getName();
                pirateNames.add(names);
            }
        return pirateNames;
    }
}
