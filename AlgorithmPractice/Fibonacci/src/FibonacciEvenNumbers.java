public class FibonacciEvenNumbers {
    /*By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.*/
    public static void main(String[] args) {
        long number1 = 1;
        long fibonacci;
        long sum = 0;
        long temp = 0;
        for (int i = 0; i <= 4000000; i++) {
            fibonacci = number1 + temp;
            number1 = fibonacci;
            temp = fibonacci - temp;
            System.out.println(fibonacci);
            if (fibonacci % 2 == 0) {
                sum += fibonacci;
            }
        }

        System.out.println(sum);
        }
    }




