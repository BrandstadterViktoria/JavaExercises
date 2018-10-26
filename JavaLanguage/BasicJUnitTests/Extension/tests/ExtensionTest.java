import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ExtensionTest {

    Extension extension = new Extension();

    @Test
    void testAdd_2and3is5() {
        assertEquals(6, extension.add(3, 2));
    }

    @Test
    void testAdd_1and4is5() {
        assertEquals(5, extension.add(1, 4));
    }

    @Test
    void testMaxOfThree_first() {
        assertEquals(5, extension.maxOfThree(5, 4, 7));
    }

    @Test
    void testMaxOfThree_third() {
        assertEquals(9, extension.maxOfThree(5, 4, 9));
    }

    @Test
    void testMedian_four() {
        assertEquals(1, extension.median(Arrays.asList(7, 5, 3, 5)));
    }

    @Test
    void testMedian_five() {
        assertEquals(5, extension.median(Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9, 10)));
    }

    @Test
    void testIsVowel_a() {
        assertTrue(extension.isVowel('A'));
    }

    @Test
    void testIsVowel_u() {
        assertTrue(extension.isVowel('u'));
    }
}
