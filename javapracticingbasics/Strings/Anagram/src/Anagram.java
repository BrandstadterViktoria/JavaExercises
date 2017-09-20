import java.util.Arrays;

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


    }

}
