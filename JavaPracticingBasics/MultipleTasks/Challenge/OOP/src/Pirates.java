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

        public boolean getHashWoodenLeg() {
            return this.hashWoodenLeg;
        }

        public int getGold(){
            return this.gold;
        }

        public String getName(){
            return this.name;
        }

        static class PirateComparator implements Comparator<Pirate> {

            @Override
            public int compare(Pirate pirate1, Pirate pirate2) {
                int pirate1
                return 0;
            }
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

        }

        public List<String> pirateCounter(ArrayList<Pirate> inputPirates) {
        ArrayList <String> sortedPiratesByName = new ArrayList<>();
            Collections.sort(inputPirates, new Pirate.PirateComparator());
            for (Pirate sortedPirates : inputPirates){
                sortedPiratesByName = new ArrayList<String>(Arrays.asList(sortedPirates.getName().split(",")));
                System.out.println(sortedPirates.getName());
        }
        return sortedPiratesByName;
    }
}
