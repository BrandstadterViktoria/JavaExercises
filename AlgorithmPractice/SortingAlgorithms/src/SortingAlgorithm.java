public class SortingAlgorithm {

    public static void main(String[] args) {
        int[] nums = new int[]{20, 35, -15, 7, 55, 1, -22};
        int[] sout = insertionSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int[] selectionSort(int[] array) {

        for (int unsortedIndex = array.length - 1; unsortedIndex > 0; unsortedIndex--) {

            int largest = 0;

            for (int i = 1; i < unsortedIndex; i++) {
                if (array[i] > array[largest]) {
                    largest = i;
                }
            }

            swap(array, largest, unsortedIndex);

        }
        return array;
    }
    
    public static int[] insertionSort (int [] array){

        for (int unsortedIndex = 1; unsortedIndex < array.length; unsortedIndex++) {
            int j;
            int newElement = array[unsortedIndex];

            for (j = unsortedIndex; j > 0 && array[j -1] > newElement; j --) {
                array[j] = array[j - 1];

            }
            array[j] = newElement;

        }
        return array;
    }
    
    

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
