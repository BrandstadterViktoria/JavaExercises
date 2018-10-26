import java.util.Scanner;

public class ArraySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            a[i] = val;
        }
        sc.close();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = a[j] + sum;
                if (sum < 0) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
