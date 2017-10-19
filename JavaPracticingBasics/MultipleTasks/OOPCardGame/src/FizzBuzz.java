import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        List<String> result = fizzBuzz(15);
        System.out.println(result);
    }

    static public List<String> fizzBuzz(int n) {
        List<String> stringList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                stringList.add("FizzBuzz");
            }
            else if (i  % 5 == 0) {
                stringList.add("Buzz");

            }else if(i  % 3 == 0) {
                stringList.add("Fizz");
            }else{
                stringList.add(String.valueOf(i));
            }
        }
        return stringList;

    }
}
