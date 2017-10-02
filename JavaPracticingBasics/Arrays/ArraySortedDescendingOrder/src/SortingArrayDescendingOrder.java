import java.util.Scanner;

public class SortingArrayDescendingOrder {

    public static void main(String[] args) {

    }

    public int [] getIntegers () {
        Scanner scanner = new Scanner(System.in);
        int[] myArray = new int[7];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = scanner.nextInt();
        }
        return myArray;
    }
}
