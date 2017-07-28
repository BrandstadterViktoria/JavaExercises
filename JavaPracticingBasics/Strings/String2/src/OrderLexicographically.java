import java.util.Scanner;

public class OrderLexicographically {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        for (int i = 0; i <= s.length() - k; i++) {
            String substr = s.substring(i, i + k);
            {
                System.out.println(substr);
            }
        }


        System.out.println(getSmallestAndLargest(s, k));
    }
}


