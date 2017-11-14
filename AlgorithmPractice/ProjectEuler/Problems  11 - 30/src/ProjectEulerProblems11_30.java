import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ProjectEulerProblems11_30 {

    public static void main(String[] args) {
        largestProductInAGrid_Problem11();
    }

    public static void largestProductInAGrid_Problem11() {
        try {
            Scanner scanner = new Scanner(new File("Problem11"));
            while (scanner.hasNext()) {
                String line = scanner.next();
                String numbers = line.trim();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

}
