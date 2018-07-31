public class Main {

    public static void main(String[] args) {
        Players viki = new Players("Viki", "female", "BVik", 32);
        System.out.println(viki.toString());
        viki.setGender("male");
        viki.setName("Clark");
        viki.setHitPoints(89);
        saveObject(viki);

        Saver beast = new Monster("Mr. Beast","male","Evil",124);
        ((Monster)beast).setName("Myrabell");
        ((Monster)beast).setHitPoints(456);
        saveObject(beast);
    }

    public static void saveObject(Saver objectSaver) {
        for (int i = 0; i < objectSaver.writeTheValues().size(); i++) {
            System.out.println("Saved " + objectSaver.writeTheValues().get(i) + " to my device");
        }
    }
}
