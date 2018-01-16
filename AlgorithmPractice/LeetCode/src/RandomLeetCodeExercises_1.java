import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RandomLeetCodeExercises_1 {

    public static void main(String[] args) {

        int[] numbers = {22, 22, 33, 44, 33, 55, 44, 9, 55};
        int[] numbers1 = {1, 0, 1};
        System.out.println(singleNumber_LC136(numbers));

    }

    public static int singleNumber_LC136(int[] numbers1) {
        int result = 0;
        HashMap<Integer, Integer> mapOfNumbers1 = new HashMap<>();
        for (int i = 0; i <= numbers1.length - 1; i++) {
            mapOfNumbers1.put(numbers1[i], (mapOfNumbers1.containsKey(numbers1[i]) ? 0 : 1));
        }
        for (int key : mapOfNumbers1.keySet()){
            int value = mapOfNumbers1.get(key);
            if(value == 1){
             result = key;
            }
            }
            return result ;
    }
}





