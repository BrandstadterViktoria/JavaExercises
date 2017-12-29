package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackImplementations_LeetCode {

    public int[] nextGreaterElement(int[]  findNums, int[] nums) {
        /*Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
        Output: [-1,3,-1]*/

     Map<Integer, Integer> map = new HashMap<>();
     Stack<Integer> stack = new Stack<>();
     for(int i = nums.length-1; i >= 0; i--){
         while(!stack.empty() && nums[i] > stack.peek())
             stack.pop();
         map.put(nums[i], (stack.empty())? -1 : stack.peek());
         stack.push(nums[i]);
        }





        return findNums;
    }
}
