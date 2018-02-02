package Stack;
import java.util.*;

public class StackImplementations_LeetCode {

    public static void main(String[] args) {
        /*int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result = nextGreaterElement(nums1, nums2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }*/

    /*    MyStack minStack = new MyStack(4);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(getMin(minStack));   //--> Returns -3.
        minStack.pop();
        System.out.println(minStack.peek());      //-> Returns 0.
        System.out.println(getMin(minStack));   //--> Returns -2.*/
       // System.out.println(reverseWords_LC557("Let's take LeetCode contest"));
        System.out.println(reverseStr_LC541_reverseStringII("abcdefg", 2));
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


    public static String reverseWords_LC557 (String s){
        char [] theWord = s.toCharArray();
        Stack<Character> reverseTheWord = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < theWord.length ; i++) {
            if(!Character.isWhitespace(theWord[i])) {
                reverseTheWord.push(theWord[i]);
            }
            if(Character.isWhitespace(theWord[i]) || i == theWord.length -1){
                reverseTheWord.push(' ');
                while (!reverseTheWord.isEmpty()){
                    result.append(reverseTheWord.pop());
                }
            }
        }
        return result.toString().trim();

    }

    public static String reverseStr_LC541_reverseStringII(String s, int k){
        int indexNumber = -1;
        char [] theWord = s.toCharArray();
        Deque<Character> reverseTheWord = new ArrayDeque<>();
        for (int i = 0; i < theWord.length ; i++) {
            reverseTheWord.push(theWord[i]);
            if(i == k){
                reverseTheWord.pop();
                while (!reverseTheWord.isEmpty()){
                    theWord[indexNumber + 1] = reverseTheWord.pop();
                    indexNumber += 1;
                }
            }
            indexNumber = i - k;
            if((i % (2 * k)) == k && i > k){
                reverseTheWord.pollFirst();
                while (indexNumber < i ){
                    theWord[indexNumber] = reverseTheWord.poll();
                    indexNumber += 1;
                }
            }
        }
            return new String(theWord);
    }

}
