import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        result = fizzBuzz(15);
        System.out.println(result);

    }

    static public List<String> fizzBuzz(int n) {
        List<Integer> nList = new ArrayList<>(n);
        List<String> stringList = new ArrayList<>();
        for (int i = 1; n > i; i++) {
            nList.add(i);
        }
        for (int i = 0; i < nList.size() - 1; i++) {
            if (nList.get(i) % 3 == 0) {
                stringList.add("Fizz");

            }
            if (nList.get(i) % 5 == 0) {
                stringList.add("Buzz");

            }
            if (nList.get(i) % 3 == 0 && nList.get(i) % 5 == 0) {
                stringList.add("FizzBuzz");
            } else {
                stringList.add(String.valueOf(nList.get(i)));
            }
        }
        return stringList;

    }
}


