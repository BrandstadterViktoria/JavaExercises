import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public boolean isAnagram(String a, String b) {
        boolean isAnagram;
        char[] word1 = a.replaceAll("[\\s]", "").toCharArray();
        char[] word2 = b.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        if (Arrays.equals(word1, word2)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String a;
        String b;
        Scanner user_input = new Scanner(System.in);
        System.out.println("Give me a String a, which length is between 1 and 50?");
        String aFirst = user_input.nextLine();
        if(aFirst.length() >= 1 && aFirst.length() <= 50){
            a = user_input.nextLine();
        }
        else {
            System.out.println("String doesn't meet the first condition, try again");
        }





    }

}
