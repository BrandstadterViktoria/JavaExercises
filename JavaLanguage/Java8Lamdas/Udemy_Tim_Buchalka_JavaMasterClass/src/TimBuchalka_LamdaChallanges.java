
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;


public class TimBuchalka_LamdaChallanges {


    public static void main(String[] args) {

        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        Function<String, String> lambdaFunction =  s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };

        lambdaFunction.apply("123456789");

        System.out.println(everySecondCharacter(lambdaFunction, "1234564789"));

        Supplier<String> iLoveJava = () -> { return "ILoveJava"; };
        System.out.println(iLoveJava.get());

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
        topNames2015
                .stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .sorted()
                .forEach(System.out::println);

        topNames2015
                .stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);

        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo);



    }

    public static String everySecondCharacter (Function <String, String> f, String s) {
        return f.apply(s);
    }


}
