public class FibonacciEvenNumbers {
    /*By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.*/
    public static void main(String[] args) {

        int [] fibonacciNumbers = new int [4000000];
        long sum = 0;
        for (int i = 2; i < 4000000; i++) {
          fibonacciNumbers[i] = fibonacci(i);
        }
        for (int i = 2; i <= fibonacciNumbers.length - 1 ; i++) {
            if(fibonacciNumbers[i] % 2 == 0){
                sum += fibonacciNumbers[i];
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
