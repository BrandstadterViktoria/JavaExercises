public class PalindromeNumber3Digit {

    /*The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    Find the largest palindrome made from the product of two 3-digit */

    public static void main(String[] args) {
    }

    public void palindromeFinder() {
        for (int i = 999; i >= 500; i--) {
            for (int j = 998; j >= 500; j--) {
                int current = i * j;
                if (String.valueOf(current).equals(new StringBuilder(String.valueOf(current)).reverse().toString())) {
                    String palindrome = String.valueOf(current);
                    System.out.println(palindrome);

                }

            }
        }
    }
}
