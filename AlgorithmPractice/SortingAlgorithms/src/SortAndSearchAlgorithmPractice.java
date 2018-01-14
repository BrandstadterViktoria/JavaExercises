import java.util.Arrays;

public class SortAndSearchAlgorithmPractice {

    public static void main(String[] args) {

        int[] sortedArrayA = {23, 35, 78, 0, 0, 0, 0, 0};
        int[] sortedArrayB = {2, 19, 25, 49, 82};
        mergeSortedOrder(sortedArrayA,sortedArrayB);

 }

    public static void mergeSortedOrder(int[] sortedArrayA, int[] sortedArrayB) {

    /*You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
    Write a method to merge B into A in sorted order.*/

        int indexOfMerged = sortedArrayA.length - 1;
        int lastIndexofA = sortedArrayA.length - sortedArrayB.length - 1;
        int lastIndexOfB = sortedArrayB.length - 1;

        while (lastIndexOfB >= 0) {

            if (lastIndexofA >= 0 && sortedArrayA[lastIndexofA] > sortedArrayB[lastIndexOfB]) {
                sortedArrayA[indexOfMerged] = sortedArrayA[lastIndexofA];
                lastIndexofA--;
            } else {
                sortedArrayA[indexOfMerged] = sortedArrayB[lastIndexOfB];
                lastIndexOfB--;

            }
            indexOfMerged--;

        }
        for (int i = 0; i < sortedArrayA.length ; i++) {
            System.out.println(i);
        }

    }
}


