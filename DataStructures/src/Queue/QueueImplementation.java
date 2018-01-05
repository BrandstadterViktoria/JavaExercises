package Queue;
import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueueImplementation {
     /*Implementation of a palindrome decider using stack and queue*/

    public static boolean checkForPalindrome(String string) {
        Pattern pattern = Pattern.compile("[^a-z A-Z]");
        Matcher matcher = pattern.matcher(string);
        string = matcher.replaceAll("").toLowerCase().replaceAll("\\s+", "");
        char[] characters = string.toCharArray();

        Deque<Character> palindrome = new LinkedList<>();
            for (int i = 0; i < characters.length / 2; i++) {
                palindrome.addFirst(characters[i]);
                palindrome.addLast(characters[characters.length - 1 - i]);
            }
            while (!palindrome.isEmpty()) {
                if (palindrome.pop().equals(palindrome.removeFirst())) {
                    return true;
                }
            }
            return false;

        }
    }



