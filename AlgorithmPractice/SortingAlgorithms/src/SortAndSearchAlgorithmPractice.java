import java.util.Arrays;

public class SortAndSearchAlgorithmPractice {

    public static void main(String[] args) {

        int [] sortedArray1 = {23, 35, 78};
        int [] sortedArray2 = {2, 19, 25, 49, 82};
    }

    public int [] mergeSortedOrder(int [] sortedArrayB, int [] sortedArrayA){

    /*You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
    Write a method to merge B into A in sorted order.*/

    sortedArrayB = Arrays.copyOf(sortedArrayB,sortedArrayA.length +sortedArrayB.length);

        for (int sortedArrayAPosition = 1; sortedArrayAPosition < sortedArrayA.length ; sortedArrayAPosition ++) {
            int j;
            int toInsertElement = sortedArrayA[sortedArrayAPosition];
            for (int j = sortedArrayAPosition; j > 0 && sortedArrayB[j] > toInsertElement; j --){
                sortedArrayB[j] =  sortedArrayA[j];

            }
            sortedArrayB[j] = toInsertElement;
        }

        return sortedArrayB;
    }
}
