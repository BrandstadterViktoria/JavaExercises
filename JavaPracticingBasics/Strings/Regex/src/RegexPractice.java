import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

    public static void main(String[] args) {

        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        String regExp1 = "I want a (bike|ball).";
        System.out.println(challenge1.matches(regExp1));
        System.out.println(challenge2.matches(regExp1));

        String regExp3 ="I want a \\w+.";
        Pattern pattern = Pattern.compile(regExp3);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());
        System.out.println(pattern.matcher(challenge2).matches());

        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s","_"));

        String challelnge5 = "aaabbbbbcdeeffg";
        System.out.println(challelnge5.matches("[a-g]+"));
        System.out.println(challelnge5.matches("^a{3}b{5}c?d?e{2}f{2}g?"));

        String challenge6a = "kjisl.22";
        String challenge6b = "abcd.135";
        String challenge6c = "f5.12a";

        String regExp6 = "(^[a-z]+[.]+\\d+\\w+)";
        System.out.println(challenge6a.matches(regExp6));
        System.out.println(challenge6b.matches(regExp6));
        System.out.println(challenge6c.matches(regExp6));


    }


}
