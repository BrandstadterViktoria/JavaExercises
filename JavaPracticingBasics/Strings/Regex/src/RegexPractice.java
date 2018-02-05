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

        String regExp6 = "^[a-z]+[.]+\\d+\\w+";

        System.out.println(challenge6a.matches(regExp6));
        System.out.println(challenge6b.matches(regExp6));
        System.out.println(challenge6c.matches(regExp6));

        String challenge8 = "abcd.135uvqz.7tzik.999";
        Pattern pattern8 = Pattern.compile("(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);
        while(matcher8.find()){
            System.out.println("Occurence:   " + matcher8.group());
        }

        String challenge9 = "abcd.135\tuvqz.7\tzik.999\n";
        Pattern pattern9 = Pattern.compile("(\\d+)\\s");
        Matcher matcher9 = pattern9.matcher(challenge9);
        int counter = 0;
        while(matcher9.find()){
            counter ++;
            System.out.println("Occurence:   " + matcher9.group());
            System.out.println("Occurence" + counter + ": starts with   " + matcher9.start(1) + " ends with= " + (matcher9.end(1)- 1));
        }




    }


}
