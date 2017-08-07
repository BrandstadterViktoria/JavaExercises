import org.junit.Test;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class CountLettersTest {
    @Test
    public void countLettersTest() throws Exception {
        String testText = "Marriage";
        Map<Character, Integer> textHashMap = new HashMap<>();
        textHashMap.put('M', 1);
        textHashMap.put('a', 2);
        textHashMap.put('r', 2);
        textHashMap.put('i', 1);
        textHashMap.put('g', 1);
        textHashMap.put('e', 1);
        Assert.assertEquals(textHashMap, CountLetters.countLetters(testText));
    }
}