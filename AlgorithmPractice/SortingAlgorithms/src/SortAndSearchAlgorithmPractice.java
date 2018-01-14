import java.util.Arrays;

public class SortAndSearchAlgorithmPractice {

    public static void main(String[] args) {

        int[] sortedArrayA = {23, 35, 78, 0, 0, 0, 0, 0};
        int[] sortedArrayB = {2, 19, 25, 49, 82};

        int[] result = mergeSortedOrder(sortedArrayA, sortedArrayB);
        for (int i = 0; i < result.length; i++) {
            System.out.println(i);
        }
    }

    public static int[] mergeSortedOrder(int[] sortedArrayA, int[] sortedArrayB) {

    /*You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
    Write a method to merge B into A in sorted order.*/

        int indexOfMerged = sortedArrayA.length - 1;
        int lastIndexofA = sortedArrayA.length - sortedArrayB.length - 1;
        int lastIndexOfB = sortedArrayB.length - 1;

        while (lastIndexOfB >= 0) {
            if (sortedArrayA[lastIndexofA] < sortedArrayB[lastIndexOfB]) {
                sortedArrayA[indexOfMerged] = sortedArrayB[lastIndexOfB];
                lastIndexOfB--;
            } else {
                sortedArrayA[indexOfMerged] = sortedArrayA[lastIndexofA];
                lastIndexofA--;
            }
            indexOfMerged--;

        }
        return sortedArrayA;
    }
}

