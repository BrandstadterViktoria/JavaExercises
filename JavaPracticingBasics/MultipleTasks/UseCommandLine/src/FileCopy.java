import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {

        if (args.length == 0) {
            printUsage();
        }
        else if (for(String a : args)){
            copy();}

        else if ( args.length < 2){
            oneArg();
        }
    }

    public static void printUsage() {
        System.out.println(" copy [source] [destination]");
    }

    public static void copy(String source, String destination) {
        try {
            Files.copy(Paths.get(source), Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void oneArg (){
        System.out.println("No destination provided");
    }
}