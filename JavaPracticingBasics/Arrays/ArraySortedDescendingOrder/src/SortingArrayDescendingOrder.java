import java.util.Scanner;

public class SortingArrayDescendingOrder {

    public static void main(String[] args) {

        printArray(getIntegers());

    }

    public static int [] getIntegers () {
        Scanner scanner = new Scanner(System.in);
        int[] myArray = new int[7];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = scanner.nextInt();
        }
        return myArray;
    }

    public static void printArray(int [] array){
        System.out.println(array);
    }
}
