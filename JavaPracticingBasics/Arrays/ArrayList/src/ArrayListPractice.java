import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ArrayListPractice {

    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<List<Integer>>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int d = scan.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            array.add(list);
            for (int j = 0; j < d; j++) {
                list.add(scan.nextInt());
            }
        }
    }
}
