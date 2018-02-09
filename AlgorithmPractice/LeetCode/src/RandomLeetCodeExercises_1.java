
import java.util.*;


public class RandomLeetCodeExercises_1 {

    public static void main(String[] args) {

        int[] numbers = {5, 4, 3, 2, 1};
        int[] numbers1 = {1, 4, 3, 2};
//        System.out.println(singleNumber_LC136(numbers));
//        System.out.println(findDuplicates_LC442(numbers));
//
//        int[] result = maxSumOfThreeSubarrays_LC689(numbers, 2);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
        //       System.out.println(detectCapitalUse("LeetCode"));
        //       System.out.println(arrayPairSum(numbers1));
        /*String [] result = findRelativeRanks_LC506(numbers);
        for (int i = 0; i <= result.length -1 ; i++) {
            System.out.println(result[i]);
        }*/
//        System.out.println( hammingDistance(1,4));
//        System.out.println(countPrimeSetBits_762LC(10, 15));
// System.out.println(hasAlternatingBits_693LC(6));
        System.out.println(toHex(26));

    }

    public static int singleNumber_LC136(int[] numbers1) {
        HashMap<Integer, Integer> mapOfNumbers1 = new HashMap<>();
        for (int i = 0; i <= numbers1.length - 1; i++) {
            mapOfNumbers1.put(numbers1[i], (mapOfNumbers1.containsKey(numbers1[i]) ? 0 : 1));
        }
        for (int key : mapOfNumbers1.keySet()) {
            int value = mapOfNumbers1.get(key);
            if (value == 1) {
                return key;
            }
        }

        return -1;
    }

    public static List<Integer> findDuplicates_LC442(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Arrays.sort(nums);
        int current;
        int previous;
        if (nums.length < 2) {
            return duplicates;
        }
        for (int i = 0; i < nums.length; i++) {
            previous = nums[i == 0 ? 0 : i - 1];
            current = nums[i == 0 ? i + 1 : i];
            if (previous == current) {
                if (!duplicates.contains(nums[i])) {
                    duplicates.add(nums[i]);
                }
            }
            if (i == nums.length - 1 && (nums[nums.length - 1] == nums[nums.length - 2])) {
                if (!duplicates.contains(nums[i])) {
                    duplicates.add(nums[i]);
                }
            }

        }
        return duplicates;
    }

    public static int[] maxSumOfThreeSubarrays_LC689(int[] nums, int k) {
        /*Input: [1,2,1,2,6,7,5,1], k= 2
        4, 3, 2, 7, 8, 2, 3, 1
          Output: [0, 3, 5]*/
        TreeMap<Integer, Integer> sumsAndIndexnumbers = new TreeMap<>();
        TreeMap<Integer, Integer> duplicates = new TreeMap<>();
        int sumOfSubarrays = 0;
        for (int i = 0, index = 0; i < nums.length; i++, index++) {
            sumOfSubarrays += nums[i];
            if ((i + 1) % k == 0) {
                sumsAndIndexnumbers.put(sumOfSubarrays, (i + 1 - k));
                if (sumsAndIndexnumbers.size() > 3 && sumOfSubarrays == sumsAndIndexnumbers.firstKey()) {
                    sumsAndIndexnumbers.remove(sumsAndIndexnumbers.firstKey());
                }
                sumOfSubarrays = 0;
            }
        }
        int[] indexNumbers = sumsAndIndexnumbers.values().stream().mapToInt(i -> i).toArray();
        Arrays.sort(indexNumbers);
        return indexNumbers;
    }

    public int numJewelsInStones(String J, String S) {
        HashMap<Integer, Character> jewels = new HashMap<>();
        char[] jewelLetters = J.toCharArray();
        char[] stoneLetters = S.toCharArray();
        int counter = 0;
        for (int i = 0; i < jewelLetters.length; i++) {
            jewels.put(i, jewelLetters[i]);
        }
        for (int i = 0; i < stoneLetters.length; i++) {
            if (jewels.containsValue(stoneLetters[i])) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean detectCapitalUse(String word) {
        return word.matches("([A-Z][a-z]*\\s*)") || word.matches("[A-Z ]+") || word.matches("[a-z]+");
    }

    public static int arrayPairSum(int[] nums) {
        int min;
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 1)
            if ((i + 1) % 2 == 0) {
                min = Math.min(nums[i], nums[i - 1]);
                sum += min;
            }
        return sum;
    }

    public static String[] findRelativeRanks_LC506(int[] nums) {
        /*Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
        who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".*/

        String[] ranks = new String[nums.length];
        Arrays.sort(nums);
        for (int i = 0, rankPosition = 0; i <= nums.length - 1; i++, rankPosition++) {
            if (i == 0) {
                ranks[rankPosition] = "Gold Medal";
            } else if (i == 1) {
                ranks[rankPosition] = "Silver Medal";
            } else if (i == 2) {
                ranks[rankPosition] = "Bronze Medal";
            } else {
                ranks[rankPosition] = String.valueOf(nums[i]);
            }
        }
        return ranks;
    }

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static int countPrimeSetBits_762LC(int L, int R) {
        int countPrimeSetBits = 0;
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= 50; i++) {
            int counter = 0;
            for (int j = i; j >= 1; j--) {
                if (i % j == 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                primes.add(i);
            }
        }

        for (int i = L; i <= R; i++) {
            if (primes.contains(Integer.bitCount(i))) {
                countPrimeSetBits++;
            }
        }
        return countPrimeSetBits;
    }

    public static boolean hasAlternatingBits_693LC(int n) {
        if(n == 1){
            return true;
        }
        boolean hasAlternatingBits = false;
        for (int i = 0; i <= Integer.toBinaryString(n).toCharArray().length - 2; i++) {
            if (Integer.toBinaryString(n).toCharArray()[i + 1] != Integer.toBinaryString(n).toCharArray()[i]) {
                hasAlternatingBits = true;
                continue;

            } else {
                hasAlternatingBits = false;
                break;
            }
        }
        return hasAlternatingBits;
    }
    public static String toHex(int num) {
        StringBuilder hexaDecimalNumber = new StringBuilder();
        HashMap<Integer, Character> hexaLetters = new HashMap<>();
        for (int i = 10, alphabet = 0; i <= 15; i++, alphabet++) {
            hexaLetters.put(i, ((char) ('a' + alphabet)));
        }
        int remainder = 1;
        while (remainder != 0) {
            remainder = num % 16;
            if (remainder >= 10 && remainder <= 15) {
                hexaDecimalNumber.append(hexaLetters.get(remainder));
                num = num / 16;
                if((num / 16) < 1){
                    hexaDecimalNumber.append(num);
                    break;
                }
            } else {
                hexaDecimalNumber.append(remainder);
            }
        }
        hexaDecimalNumber.reverse();
        return hexaDecimalNumber.toString();

    }git

}















