import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {

        int n = 0;
        int k = Integer.parseInt(args[0]);
        if (k <= 0) {
            throw new IllegalArgumentException("K must be positive number.");
        }

        RandomizedQueue<String> q = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            q.enqueue(s);
            n++;
        }
        if (k <= n) {
            for (int i = 0; i <= k; i++) {
                StdOut.print(q.dequeue());
            }
        } else {
            throw new UnsupportedOperationException("Size of datastructure is unsufficient for random");
        }
    }

}
