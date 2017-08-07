import java.util.ArrayList;
import java.util.List;

public class Seconds {
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            numberList.add(i);
        }
        System.out.println(setListWithSecondElements(numberList));
    }

    public static List<Integer> setListWithSecondElements(List<Integer> numberListForUse) {
        List<Integer> secondElements = new ArrayList<>();
        for (int i = 2; i < numberListForUse.size() + 2; i += 2) {
            secondElements.add(i);
        }
        return secondElements;
    }
}
