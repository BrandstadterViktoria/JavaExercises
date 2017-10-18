public class Main {

    public static void saveObject(Saver objectSaver) {
        for (int i = 0; i <objectSaver.writeTheValues().size(); i++) {
            System.out.println("Saved" + objectSaver.writeTheValues().get(i) +"to my device");
        }
    }
}
