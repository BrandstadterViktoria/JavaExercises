import java.util.Objects;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileCopy {
    public static void main(String[] args) {
        try {
            if (Objects.equals(args[0], " ")) {
                printUsage();
            }
            if (Objects.equals(args[0], "-a")) {
                addNewTask(args[1]);
            }
            if (args[0].equals("-c")) {
                checkTask(Integer.parseInt(args[1]));
            }
            if (args[0].equals("-r")) {
                removeTask(Integer.parseInt(args[1]));
            }
        }catch (IllegalArgumentException ex){
            argumentErrorHandling();
        }
    }

    public static void printUsage() {
        System.out.println(" copy [source] [destination]");
}


