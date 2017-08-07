import java.util.HashMap;
import java.util.Map;

public class CountLetters {
    public static void main(String[] args) {

    }

    public static Map<Character, Integer> countLetters(String text) {
        Map<Character, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (dictionary.containsKey(text.charAt(i))) {
                dictionary.put(text.charAt(i), dictionary.get(text.charAt(i)) + 1);
            } else {
                dictionary.put(text.charAt(i), 1);
            }
        }
        return dictionary;

    }
}
