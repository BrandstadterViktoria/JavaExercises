import java.util.*;

public class SortingArrayDescendingOrder {

    public static void main(String[] args) {
        printArray(getIntegers());

    }

    public static int[] getIntegers() {
        Scanner scanner = new Scanner(System.in);
        int[] myArray = new int[7];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = scanner.nextInt();
        }
        return myArray;
    }

    public static void printArray(int[] array) {
        System.out.println(array);
    }

    public static int[] sortArray(int[] array) {
        int[] sortedArray = new int[7];
        for (int i = 0; i < (array.length - 1); i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }
}
