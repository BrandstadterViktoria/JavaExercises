import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountAs {
    public static void main(String[] args) {


    }

    public int countAsInFile(String myFile) {
        int numberAs;
        myFile = "./resources/TextFileCountAs";
        try {
            Path filePath = Paths.get(myFile);
            List<String> lines = Files.readAllLines(filePath);
            

        } catch (Exception e) {
        }
        return numberAs;
    }


}
