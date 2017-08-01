import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListPractice {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<List<Integer>> array = new ArrayList<>();
        int d = scan.nextInt();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(d);
            array.add(list);
            for (int p = 0; p < d; p++) {
                list.add(scan.nextInt());
            }
        }
        int q = scan.nextInt();
        for (int l = 0; l < q; l++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            System.out.println(array.get(x).get(y));

        }
    }
}


