import org.junit.Test;
import org.junit.Assert;

public class AnagramTest {

    @Test
    public void anagramTester() throws Exception {
        String testFirst = "green";
        String testSecond = "nrgee";
        Assert.assertEquals(true, Anagram.anagram(testFirst, testSecond));
    }
}