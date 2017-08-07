
public class FibonacciSequence {
    public static void main(String args[]) {
    }
    public static int[] setFibonacci(int index) {
        int[] fibonacci = new int[index];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; ++i) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
    }
}
