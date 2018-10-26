import java.util.*;

public class PalindromeNumber3Digit {

    /*The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    Find the largest palindrome made from the product of two 3-digit */

    public static void main(String[] args) {

        palindromeFinder();
    }

    public static void palindromeFinder() {
        long start = System.currentTimeMillis();
        int biggest = 100001;

        for (int i = 999; i >= 500; i--) {
            for (int j = 500; j <= i; j++) {
                int current = i * j;
                if (String.valueOf(current).equals(new StringBuilder(String.valueOf(current)).reverse().toString())
                        && current > biggest) {
                    biggest = current;
                }
            }
        }
        System.out.println(biggest);
        long end = System.currentTimeMillis();
        System.out.println(end - start+"ms");

    }
}
