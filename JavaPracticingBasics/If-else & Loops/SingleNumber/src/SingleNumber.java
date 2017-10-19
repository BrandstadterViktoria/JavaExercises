public class SingleNumber {
    public static void main(String[] args) {
        int [] givenValues = {2,3,4,2,3,4,5,5,14};
        int result = singleNumber(givenValues);
        System.out.println(result);

    }

    public static int singleNumber(int[] nums) {
        int returnValue = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < nums.length; k++) {
                if (nums[i] != nums[k]) {
                    returnValue = nums[i];
                }
            }
        }
        return returnValue;
    }

}
