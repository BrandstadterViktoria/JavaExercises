public class EvenNumberProblems {
    /*Here are small programs that solve the first 10 even numbered problems from the  Project Euler programming
    challenge at educational website*/

    public static void main(String[] args) {

//        sumfOfSquares();
//        greatestProductOf1000DigitNumber();
//        findTheSumOfPrimes();
        createTriangleNumberWithOver500Factors();
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

    public static void greatestProductOf1000DigitNumber() {
        /* Find the greatest product of five consecutive digits in the 1000-digit number*/

        String my1000DigitNumber = "73167176531330624919225119674426574742355349194934 " +
                "96983520312774506326239578318016984801869478851843 " +
                "85861560789112949495459501737958331952853208805511 " +
                "12540698747158523863050715693290963295227443043557 " +
                "66896648950445244523161731856403098711121722383113 " +
                "62229893423380308135336276614282806444486645238749 " +
                "30358907296290491560440772390713810515859307960866 " +
                "70172427121883998797908792274921901699720888093776 " +
                "65727333001053367881220235421809751254540594752243 " +
                "52584907711670556013604839586446706324415722155397 " +
                "53697817977846174064955149290862569321978468622482 " +
                "83972241375657056057490261407972968652414535100474 " +
                "82166370484403199890008895243450658541227588666881 " +
                "16427171479924442928230863465674813919123162824586 " +
                "17866458359124566529476545682848912883142607690042 " +
                "24219022671055626321111109370544217506941658960408 " +
                "07198403850962455444362981230987879927244284909188 " +
                "84580156166097919133875499200524063689912560717606 " +
                "05886116467109405077541002256983155200055935729725 " +
                "71636269561882670428252483600823257530420752963450";

        int product = 0;
        int temp = 0;
        for (int i = 0; i < my1000DigitNumber.length() - 4; i++) {
            product = my1000DigitNumber.charAt(i) + '0' *
                    my1000DigitNumber.charAt(i + 1) + '0' *
                    my1000DigitNumber.charAt(i + 2) + '0' *
                    my1000DigitNumber.charAt(i + 3) + '0' *
                    my1000DigitNumber.charAt(i + 4) + '0';
            if (product < temp) {
                temp = product;

            }
        }

        System.out.println("This is the greatest product of five consecutive digits in the 1000-digit number: " + product);
    }

    public static void findTheSumOfPrimes() {
        /*Find the sum of all the primes below one million*/

        int sumOfPrimes = 0;
        long range = 1000000;
        for (int i = 0; i < 100; i++) {
            if (isAPrime(i)) {
                sumOfPrimes += i;
            }
        }
        System.out.println("This is he sum of all the primes below one million:  " + sumOfPrimes);

    }

    public static boolean isAPrime(int prime) {
        if (prime == 1 || prime == 3) {
            return true;
        }
        if (prime == 5 || prime == 7) {
            return true;
        }
        if (prime == 2) {
            return true;
        }
        int sqrtN = (int) Math.sqrt(prime) + 1;
        for (int i = 2; i < sqrtN; i++) {
            if (prime % i == 0) {
                return false;
            }
        }
        return true;

    }

    public static void createTriangleNumberWithOver500Factors() {
        /*Which is the first triangle number to have over five-hundred factors?*/
        int twos = 0;
        int threes = 0;
        int fives = 0;
        int sevens = 0;
        int triangleNumber = 0;
        int divisors = 0;

        for (int i = 1; divisors < 502; i++) {
            if (divisors == 500 || divisors > 500) {
                System.out.println(triangleNumber);
            } else {
                divisors = 0;
                triangleNumber = ((i * (i + 1)) / 2);
                if (triangleNumber % 2 == 0) {
                    while (triangleNumber % 2 == 0) {
                        triangleNumber /= 2;
                        twos++;
                    }
                }
                if (triangleNumber % 3 == 0) {
                    while (triangleNumber % 3 == 0) {
                        triangleNumber /= 3;
                        threes++;
                    }
                }
                if (triangleNumber % 5 == 0) {
                    while (triangleNumber % 5 == 0) {
                        triangleNumber /= 5;
                        fives++;
                    }
                }
                if (triangleNumber % 7 == 0) {
                    while (triangleNumber % 7 == 0) {
                        triangleNumber /= 7;
                        sevens++;
                    }
                }
                divisors = (twos + 1) * (threes + 1) * (fives + 1) * (sevens + 1);

            }
        }
    }


}
        






