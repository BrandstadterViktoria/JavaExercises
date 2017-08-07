import java.util.Arrays;
import java.util.List;

public class Extension {
    int add(int a, int b) {
        return a + b;
    }

    int maxOfThree(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        }
        if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

    int median(List<Integer> pool) {
        if (pool.size() % 2 == 1) {
            return pool.get((pool.size() - 1) / 2);
        } else {
            return 1;
        }
    }
    boolean isVowel(char c) {
        return (Arrays.asList('a', 'u', 'o', 'e', 'i').contains(c));
    }
}



