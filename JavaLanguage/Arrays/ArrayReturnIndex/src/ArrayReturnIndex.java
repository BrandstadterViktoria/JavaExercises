import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayReturnIndex {

    public static void main(String[] args) {
        int [] nums = {2, 13, 4, 15, 5};
        int target = 6;

        System.out.println(twoSum(nums,target));
    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> indexOfSummedNumbers = new ArrayList<>();
        int arrayElement1 = 0;
        int arrayElement2 =0;
        for (int i = 0; i <nums.length ; i++) {
            do {
                 arrayElement2 = target - nums[i];
            }
            while (!(Arrays.asList(nums).contains(arrayElement2) ));
            
        }

        arrayElement1 = target - arrayElement2;
        int indexElement1 = Arrays.asList(nums).indexOf(arrayElement1);
        int indexElement2 = Arrays.asList(nums).indexOf(arrayElement2);
        indexOfSummedNumbers.add(indexElement1);
        indexOfSummedNumbers.add(indexElement2);
        System.out.println(indexOfSummedNumbers.toString());
        int [] ints = indexOfSummedNumbers.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }

    }

