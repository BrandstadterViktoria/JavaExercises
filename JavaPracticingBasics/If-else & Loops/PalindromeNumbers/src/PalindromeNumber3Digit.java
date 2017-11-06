public class PalindromeNumber3Digit {

    /*The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    Find the largest palindrome made from the product of two 3-digit */

    public static void main(String[] args) {


    }

    public void palindromeFinder() {
        int number = 0;
        for (int i = 999; i >= 500; i--) {
            for (int j = 999; j >= 500; j--) {
                do {
                    number = i * j;
                }
                while (String.valueOf(number).equals(new StringBuilder(String.valueOf(number)).reverse().toString()));

            }
        }
        System.out.println(String.valueOf(number));
    }
}

