import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountAs {
    public static void main(String[] args) {
        String myFile = "./resources/TextFileCountAs";
        countAsInFile(myFile);
    }

    public static int countAsInFile(String myFile) {
        int numberAs = 0;
        char a = 'a';
        int index = 0;
        try {
            Path filePath = Paths.get(myFile);
            List<String> lines = Files.readAllLines(filePath);
            String myLines = lines.toString();
            while (index < myLines.length()) {
                if (myLines.charAt(index) == a) {
                    numberAs++;
                }
                index++;
            }

        } catch (Exception e) {
            return 0;

        }
        System.out.println(numberAs);
        return numberAs;
    }
}
