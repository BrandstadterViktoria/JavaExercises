
import java.util.*;


public class RandomLeetCodeExercises_1 {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 1, 2, 6, 7, 5, 1};
        int[] numbers1 = {1, 0, 1};
//        System.out.println(singleNumber_LC136(numbers));
//        System.out.println(findDuplicates_LC442(numbers));
//
//        int[] result = maxSumOfThreeSubarrays_LC689(numbers, 2);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
        System.out.println(detectCapitalUse("LeetCode"));
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
      HashMap <Integer, Character> jewels = new HashMap<>();
      char [] jewelLetters = J.toCharArray();
      char [] stoneLetters = S.toCharArray();
      int counter = 0;
        for (int i = 0; i < jewelLetters.length; i++) {
            jewels.put(i,jewelLetters[i]);
        }
        for (int i = 0; i < stoneLetters.length; i++) {
            if(jewels.containsValue(stoneLetters[i])){
                counter++;
            }
        }
        return counter;
    }
    public static boolean detectCapitalUse(String word){
        return word.matches("([A-Z][a-z]*\\s*)") || word.matches("[A-Z ]+" )|| word.matches("[a-z]+");
    }
}















