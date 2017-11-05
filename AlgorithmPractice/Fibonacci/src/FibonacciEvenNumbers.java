public class FibonacciEvenNumbers {
    public static void main(String[] args) {
        int sum = 0;
        int n = 42;
        for (int i = 1; i <= n; i++) {
            if (fibonacci(i) % 2 == 0 && fibonacci(i) <= 1000000){
                System.out.println(fibonacci(i));
                sum += fibonacci(i);
            }
        }
        System.out.println(sum);
    }


    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
