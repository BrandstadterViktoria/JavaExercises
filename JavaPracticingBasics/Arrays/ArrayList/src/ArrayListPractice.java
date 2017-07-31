import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListPractice {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int d = scan.nextInt();
            ArrayList<Integer> list = new ArrayList<>(d);
            for (int k = 0; k < d; i++) {
                int val = scan.nextInt();
                list.add(val);
//
            }
            scan.close();
        }
    }
}
