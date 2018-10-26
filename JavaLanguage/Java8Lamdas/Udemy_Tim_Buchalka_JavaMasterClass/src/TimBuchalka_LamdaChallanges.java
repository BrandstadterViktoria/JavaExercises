
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


    }

    public static String everySecondCharacter (Function <String, String> f, String s) {
        return f.apply(s);
    }


}
