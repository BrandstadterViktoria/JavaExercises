
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProjectEulerProblems11_30
/*Problem_13 solved in an other class*/ {

    public static void main(String[] args) {
//        largestProductInAGrid_Problem11();
// highlyDivisibleTriangularNumber_Problem12();
// longestCollatzSequence_Problem14();
        specialPythagoreanTriplet_Problem9();
        //       powerDigitSum_16();
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
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put( 1,"one");
        hm.put( 2,"two");
        hm.put(3,"three");
        hm.put(4,"four" );
        hm.put( 5,"five");
        hm.put(6,"six")
        hm.put(7,"seven");
        hm.put( 8,"eight");
        hm.put( 9,"nine");
        hm.put(10, "ten");
        hm.put(11,"eleven");
        hm.put(12,"twelve");
        hm.put(13,"thirteen");
        hm.put(14,"fourteen");
        hm.put(15,"fifteen");
        hm.put(16,"teen");
        hm.put(20,"twenty");
        hm.put(30,"thirty");
        hm.put( 40,"forty");
        hm.put(50,"fifty");
        hm.put(60,"sixty");
        hm.put(70, "seventy");
        hm.put(80,"eighty");
        hm.put(90, "ninety");
        hm.put( 100,"hundred");

        // and
        hm.put(101,"and");
        hm.put(1000, "thousand");

        for (int i = 0; i < 10000 ; i++) {
            if( i <= 10){
                hm.get(1);
            }
        }


    }

}






