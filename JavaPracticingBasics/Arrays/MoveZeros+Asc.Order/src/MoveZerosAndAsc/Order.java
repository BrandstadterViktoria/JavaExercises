package MoveZerosAndAsc;

import java.util.Arrays;

public class Order {
    public static void main(String[] args) {
        int[] test = {7, 19, 5, 0, 9, 2, 0};
        moveZeroes(test);

    }

    public static void moveZeroes(int[] nums) {
        Arrays.sort(nums);
        int temp = 0;
        int count = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            if (nums[i] == 0) {
                count++;
                temp = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = nums[i];
                nums[i] = temp;
            }
        }
        if (nums[nums.length - 1] == 0) {
            Arrays.sort(nums, 0, nums.length - count);


        }
    }
}
