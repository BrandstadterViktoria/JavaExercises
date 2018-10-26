import java.util.ArrayList;
import java.util.List;

public class AvValCalculator {

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            numberList.add(i);
        }
    }

    public int avarageValueCalculator(List<Integer> numberListForUse) {
        int avarage = 0;
        int numberOdds = 0;
        int sumOfOddNumbers =0;
        for (int i = 0; i < numberListForUse.size(); i++) {
            if (numberListForUse.get(i) % 2 == 1) {
                numberOdds++;
                sumOfOddNumbers += numberListForUse.get(i);
            }
            avarage = sumOfOddNumbers/numberOdds;
            System.out.print(avarage);
        }
        return (avarage);
    }
}
