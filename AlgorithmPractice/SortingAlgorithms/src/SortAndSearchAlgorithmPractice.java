import java.util.Arrays;

public class SortAndSearchAlgorithmPractice {

    public static void main(String[] args) {

        int[] sortedArrayA = {23, 35, 78, 0, 0, 0, 0, 0};
        int[] sortedArrayB = {2, 19, 25, 49, 82};
        mergeSortedOrder(sortedArrayA,sortedArrayB);

 }

    public static void mergeSortedOrder(int[] nums1, int[] nums2) {

    /*You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
    Write a method to merge B into A in sorted order.*/

        int indexOfMerged = nums1.length - 1;
        int lastIndexofA = nums1.length - nums2.length - 1;
        int lastIndexOfB = nums2.length - 1;

        while (lastIndexOfB >= 0) {

            if (lastIndexofA >= 0 && nums1[lastIndexofA] > nums2[lastIndexOfB]) {
                nums1[indexOfMerged] = nums1[lastIndexofA];
                lastIndexofA--;
            } else {
                nums1[indexOfMerged] = nums2[lastIndexOfB];
                lastIndexOfB--;

            }
            indexOfMerged--;

        }
        for (int i = 0; i < nums1.length ; i++) {
            System.out.println(nums1[i]);
        }

    }
}


