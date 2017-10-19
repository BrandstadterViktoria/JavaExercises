import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        List<String> result = fizzBuzz(14);
        System.out.println(result);
    }

    static public List<String> fizzBuzz(int n) {
        List<Integer> nList = new ArrayList<>(n);
        List<String> stringList = new ArrayList<>();
        for (int i = 1;  i <= n; i++ ) {
            nList.add(i);
        }
        for (int i = 0; i < nList.size(); i++) {
            if (nList.get(i) % 3 == 0 && nList.get(i) % 5 == 0) {
                stringList.add("FizzBuzz");
                nList.remove(i);
            }
            if (nList.get(i) % 3 == 0) {
                stringList.add("Fizz");
                nList.remove(i);
            }
            if (nList.get(i) % 5 == 0) {
                stringList.add("Buzz");
                nList.remove(i);
            } else {
                stringList.add(String.valueOf(nList.get(i)));
            }
        }
        return stringList;

    }
}


