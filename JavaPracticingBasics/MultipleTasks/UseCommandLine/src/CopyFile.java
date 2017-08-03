import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyFile {

        public static void main(String[] args) {
            if (args.length == 0) {
                printWithoutArgument();
            } else if (args.length < 2){
                printWithOneArgument();

            } else if (args.length == 3){
                copy(args[1], args[2]);
            }
            }

    private static void printWithoutArgument() {
        System.out.println(" copy [source] [destination]");
    }

    private static void printWithOneArgument (){
        System.out.println("No destination provided");
    }

    private static void copy(String source, String destination) {
        try {
            Files.copy(Paths.get(source), Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 }
