import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static boolean isAnagram(String a, String b) {
        if (!(a.equalsIgnoreCase(b))) {
            char[] word1 = a.replaceAll("[\\s]", "").toCharArray();
            char[] word2 = b.replaceAll("[\\s]", "").toCharArray();
            Arrays.sort(word1);
            Arrays.sort(word2);
            if (Arrays.equals(word1, word2)) {

            }
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        System.out.println("Give me a String a, which length is between 1 and 50?");
        String a = user_input.nextLine();
        while (!(a.length() >= 1 && a.length() <= 50)) {
            System.out.println("String length isn't between 1 and 50, pls try again!");
            a = user_input.nextLine();
        }

        Scanner user_input1 = new Scanner(System.in);
        System.out.println("Give me the next String b, which length is between 1 and 50?");
        String b = user_input1.nextLine();
        while (!(b.length() >= 1 && b.length() <= 50)) {
            System.out.println("String length isn't between 1 and 50, pls try again!");
            b = user_input1.nextLine();
        }

        System.out.println(isAnagram(a,b));
        if (!isAnagram(a, b) && a.equalsIgnoreCase(b)) {
            System.out.println("Anagram");
        }
        else{
            System.out.println("Not Anagrams");
        }
    }
}

