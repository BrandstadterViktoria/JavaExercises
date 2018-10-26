import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrderLexicographically {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < s.length(); i = i + 1) {
            if (s.length() - i >= k) {
                list.add(s.substring(i, k + i));
            }
        }
        Collections.sort(list);
        smallest= list.get(0);
        largest= list.get(list.size()-1);
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        System.out.println(getSmallestAndLargest(s, k));
    }
}


