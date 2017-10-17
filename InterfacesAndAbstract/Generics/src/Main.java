public class Main {

    public static void main(String[] args) {

        FootballLeague<FootbalTeam> hungarian = new FootballLeague<>("Hungarian");
        FootballLeague<FootbalTeam> spanish = new FootballLeague<>("Spanish");
        FootballLeague<FootbalTeam> german = new FootballLeague<>("German");

        hungarian.playMatch(spanish,3,7);
        spanish.playMatch(german,11,6);
        german.playMatch(hungarian,7,8);


        System.out.println(hungarian.ranking());
        System.out.println(spanish.ranking());
        System.out.println(german.ranking());

    }
}
