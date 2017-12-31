import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProjectEulerProblems11_30 {

    public static void main(String[] args) {
//        largestProductInAGrid_Problem11();
// highlyDivisibleTriangularNumber_Problem12();
// longestCollatzSequence_Problem14();
//        specialPythagoreanTriplet_Problem9();
        //       powerDigitSum_16();
        //       numberLetterCounts();
        //      countingSundays();
        // factorialDigitSum_Problem20();
//        amicableNumbers_Problem21();
//        nonAbundantSums_Problem23();
        the1000digitFibonacciNumber_Problem25();

    }

    public static void specialPythagoreanTriplet_Problem9() {
        /*A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a2 + b2 = c2
        There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc. */
        int result = 0;
        for (int a = 1; a <= 1000; a++) {
            for (int b = 2; b <= 1000; b++) {
                int c = 1000 - a - b;
                if (a * a + b * b == c * c) {
                    result = a * b * c;
                }
            }
        }

        System.out.println(result);
    }


    public static void largestProductInAGrid_Problem11() {

    /*What is the greatest product of 4 adjacent numbers in the same direction (up, down, left, right, or diagonally)
     in the 20×20 grid?*/

        int multipleUpAndDown = 0;
        int multipleLeftAndRight = 0;
        int multipleDiagonally = 0;
        int temp;

        int[] grid = {8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8,
                49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0,
                81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65,
                52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91,
                22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80,
                24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50,
                32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70,
                67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21,
                24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72,
                21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95,
                78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92,
                16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57,
                86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58,
                19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40,
                4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66,
                88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69,
                4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36,
                20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16,
                20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54,
                1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48};

        for (int i = 0; i < grid.length - 60; i++) {
            temp = grid[i] * grid[i + 20] * grid[i + 40] * grid[i + 60];
            if (temp > multipleUpAndDown) {
                multipleUpAndDown = temp;
            }
        }
        for (int i = 0; i < grid.length - 3; i++) {
            temp = grid[i] * grid[i + 1] * grid[i + 2] * grid[i + 3];
            if (temp > multipleLeftAndRight) {
                multipleLeftAndRight = temp;
            }
        }
        for (int i = 0; i < grid.length - 63; i++) {
            temp = grid[i] * grid[i + 21] * grid[i + 42] * grid[i + 63];
            if (temp > multipleDiagonally) {
                multipleDiagonally = temp;
            }
        }
        System.out.println("diagonally:  " + multipleDiagonally + "  left and right:  " + multipleLeftAndRight
                + "  up and down " + multipleUpAndDown);
    }

    public static void highlyDivisibleTriangularNumber_Problem12() {
        /*What is the value of the first triangle number to have over five hundred divisors?*/

        final long startTime = System.nanoTime();
        int triangleNumber;
        int result = 0;
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; divisors.size() < 201; i++) {
            triangleNumber = (i * (i + 1)) / 2;
            result = triangleNumber;
            divisors.clear();
            for (int j = 1; j <= triangleNumber; j++) {
                if (triangleNumber % j == 0) {
                    divisors.add(j);
                }
            }
        }
        System.out.println(result);
    }

    public static void longestCollatzSequence_Problem14() {
        long nextNumber;
        int chainSize;
        int max = 0;
        long result = 0;
        for (long j = 1000; j < 1000000; j++) {
            nextNumber = j;
            chainSize = 0;
            while (nextNumber != 1) {
                if (nextNumber % 2 == 0) {
                    nextNumber = nextNumber / 2;
                    chainSize++;
                } else if (!(nextNumber % 2 == 0)) {
                    nextNumber = 3 * nextNumber + 1;
                    chainSize++;
                }
            }
            chainSize++;
            if (chainSize > max) {
                max = chainSize;
                result = j;
            }
        }

        System.out.println(result);
    }

    public static void powerDigitSum_16() {
        /*215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26. What is the sum of the digits of the number
         21000?*/

        long result = 0;
        BigInteger number = BigInteger.valueOf(2).pow(1000);
        List<Integer> listOfDigits = new ArrayList<>();
        String numbers = number.toString();
        for (int i = 0; i < numbers.length(); i++) {
            result += Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        System.out.println(result);
    }

    public static void numberLetterCounts() {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1, 3); //"one");
        hm.put(2, 3); //"two");
        hm.put(3, 5); //"three");
        hm.put(4, 4); //"four" );
        hm.put(5, 4); //"five");
        hm.put(6, 3); //"six")
        hm.put(7, 5); //"seven");
        hm.put(8, 5);//"eight");
        hm.put(9, 4); //"nine");
        hm.put(10, 3);//"ten");
        hm.put(11, 6); //"eleven");
        hm.put(12, 6);//"twelve");
        hm.put(13, 8);//"thirteen");
        hm.put(14, 8);//"fourteen");
        hm.put(15, 7);//"fifteen");
        //"teen");
        hm.put(16, 4);
        hm.put(20, 6);//"twenty");
        hm.put(30, 6);//"thirty");
        hm.put(40, 5);//"forty");
        hm.put(50, 5);//"fifty");
        hm.put(60, 5);//"sixty");
        hm.put(70, 7);//seventy");
        hm.put(80, 6);//"eighty");
        hm.put(90, 6);//"ninety");
        hm.put(100, 7);//"hundred");

        // and
        hm.put(101, 3);//"and");
        hm.put(1000, 8);// "thousand");

        int numberLetters1_10;
        int numberLetters_11_20;
        int numberLetters_21_99;
        int numberLetters100_1000_WthOutAnds;
        int numberOfAnds;
        int result;

        numberLetters1_10 = hm.get(1) + hm.get(2) + hm.get(3) + hm.get(4) + hm.get(5) + hm.get(6) + hm.get(7) + hm.get(8) +
                hm.get(9) + hm.get(10);

        numberLetters_11_20 = hm.get(11) + hm.get(12) + hm.get(13) + hm.get(14) + hm.get(15) + 4 * (hm.get(16)) + hm.get(6)
                + hm.get(7) + hm.get(8) + hm.get(9) + hm.get(20);


        numberLetters_21_99 = 9 * hm.get(20) + 10 * (hm.get(30) + hm.get(40) + hm.get(50) + hm.get(60) + hm.get(70) + hm.get(80)
                + hm.get(90)) + 8 * (hm.get(1) + hm.get(2) + hm.get(3) + hm.get(4) + hm.get(5) + hm.get(6) + hm.get(7) + hm.get(8) +
                hm.get(9));

        numberLetters100_1000_WthOutAnds = 9 * (numberLetters1_10 + numberLetters_11_20 + numberLetters_21_99) + 899 * hm.get(100) +
                100 * (hm.get(1) + hm.get(2) + hm.get(3) + hm.get(4) + hm.get(5) + hm.get(6) + hm.get(7) + hm.get(8) +
                        hm.get(9)) + hm.get(1) + hm.get(1000);

        numberOfAnds = 898 * hm.get(101);

        result = numberLetters1_10 + numberLetters_11_20 + numberLetters_21_99 + numberLetters100_1000_WthOutAnds
                + numberOfAnds;

        System.out.println(result);

    }

    public static void countingSundays() {
        /*How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?*/
        int numberOfSundays = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = format.parse("1901-01-01");
            Date endDate = format.parse("2000-12-31");
            Calendar cal = new GregorianCalendar();
            cal.setTime(startDate);
            Calendar calEnd = new GregorianCalendar();
            calEnd.setTime(endDate);
            while (cal.before(calEnd)) {
                if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    numberOfSundays++;
                }
                cal.add(Calendar.MONTH, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(numberOfSundays);
    }

    public static void factorialDigitSum_Problem20() {
        int sumOfDigits = 0;
        BigInteger factroialOf100 = new BigInteger("1");
        for (int i = 1; i < 100; i++) {
            factroialOf100 = factroialOf100.multiply(new BigInteger(i + ""));
        }

        String digits = factroialOf100.toString();
        for (int i = 0; i < digits.length(); i++) {
            int digit = (int) (digits.charAt(i) - '0');
            sumOfDigits = sumOfDigits + digit;

        }
        System.out.println(sumOfDigits);

    }


    public static void amicableNumbers_Problem21() {
        /*Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
        If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
        Evaluate the sum of all the amicable numbers under 10000.*/

        int sumOfDivisorsOfNumbers;
        int result = 0;
        for (int i = 220; i < 10000; i++) {
            sumOfDivisorsOfNumbers = countDivisorsSum(i);
            if (countDivisorsSum(sumOfDivisorsOfNumbers) == i && i != sumOfDivisorsOfNumbers) {
                result += i;
            }
        }

        System.out.println(result);
    }

    public static int countDivisorsSum(long input) {
        int sum = 0;
        for (int i = 1; i < input; i++) {
            if (input % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void nonAbundantSums_Problem23() {
       /*Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.*/
        long result = 0;
        Set<Long> abundantNumbers = new HashSet<>();
        for (long i = 1; i < 28124; i++) {
            if (countDivisorsSum(i) > i) {
                abundantNumbers.add(i);
            }
        }
        for (long sum = 24; sum < 28124; sum++)
            for (long number1 : abundantNumbers) {
                if (sum > number1 && abundantNumbers.contains(sum - number1)) {
                    break;
                } else {
                    result += sum;
                }
            }
        System.out.println(result);

    }

    public static void the1000digitFibonacciNumber_Problem25() {
        BigInteger number1 = new BigInteger("1");
        BigInteger fibonacci = new BigInteger("0");
        BigInteger temp = new BigInteger("0");
        BigInteger maximum = BigInteger.valueOf(10).pow(100);
        while (!fibonacci.equals(maximum)) {
            fibonacci = number1.add(temp);
            number1 = fibonacci;
            temp = fibonacci.subtract(temp);
        }
}

}








