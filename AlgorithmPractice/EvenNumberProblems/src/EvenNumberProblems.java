public class EvenNumberProblems {
    /*Here are small programs that solve the first 10 even numbered problems from the  Project Euler programming
    challenge at educational website*/

    public static void main(String[] args) {
        sumfOfSquares();
    }

    public static void sumfOfSquares() {
        /* Find the difference between the sum of the squares of the first one hundred natural numbers and the square
        of the sum*/
        int sumOfTheSquares = 0;
        int sumOfNumbersSquares;
        int sumOfNumbers = 0;
        for (int i = 1; i <= 100; i++) {
            int square = i * i;
            sumOfTheSquares += square;
            sumOfNumbers += i;
        }
        sumOfNumbersSquares = sumOfNumbers * sumOfNumbers;
        int difference = sumOfNumbersSquares - sumOfTheSquares;
        System.out.println("Sum  of the square of the first 100 natural numbers is: " + sumOfTheSquares + "\n" +
                "Square of the sum:  " + sumOfNumbersSquares + "\n" +
                "and the difference is:   " + difference);

    }
}


