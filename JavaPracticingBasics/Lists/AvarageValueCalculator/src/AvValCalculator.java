import java.util.ArrayList;
import java.util.List;

public class AvValCalculator {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(4);
        numbers.add(7);
        numbers.add(9);
        numbers.add(5);

        AvValCalculator(numbers);

    }

    private static int AvValCalculator(List<Integer> numbers) {
        int sum =0;
        int numberEvens = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                sum += numberEvens;
            }
            System.out.println(sum/numbers.size());
        }
        return sum/numbers.size();
    }
}
