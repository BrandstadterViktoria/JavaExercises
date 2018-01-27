
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RandomLeetCodeExercises_1 {

    public static void main(String[] args) {

        int[] numbers = {1,1};
        int[] numbers1 = {1, 0, 1};
//        System.out.println(singleNumber_LC136(numbers));
        System.out.println(findDuplicates(numbers));

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

    public static List<Integer> findDuplicates(int[] nums) {
        /* Input:[4,3,2,7,8,2,3,1], Output: [2,3]*/
        List<Integer> duplicates = new ArrayList<>();
        Arrays.sort(nums);
        int current;
        int previous;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length == 2) {
                current = nums[0];
                previous = nums[1];
                if (previous == current) {
                    if (!duplicates.contains(nums[i])) {
                        duplicates.add(nums[i]);
                    }
                }
            }
            if (i == 0) {
                continue;
            } else {
                previous = nums[i - 1];
                current = nums[i];
                if (previous == current) {
                    if (!duplicates.contains(nums[i])) {
                        duplicates.add(nums[i]);
                    }
                }
            }
            if(i == nums.length -1 && (nums[nums.length - 1] == nums[nums.length - 2])){
                   if(!duplicates.contains(nums[i])){
                       duplicates.add(nums[i]);
                }
            }

        }
        return duplicates;
    }
}





