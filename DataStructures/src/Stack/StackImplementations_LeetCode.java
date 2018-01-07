package Stack;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackImplementations_LeetCode {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nextGreaterElement(nums1, nums2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

        }

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*Input: nums1 = ], nums2 = [1,3,4,2].
        Output: [-1,3,-1]*/

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stackNums2 = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stackNums2.empty() && nums2[i] > stackNums2.peek())
                stackNums2.pop();
            map.put(nums2[i], (stackNums2.empty()) ? -1 : stackNums2.peek());
            stackNums2.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}


