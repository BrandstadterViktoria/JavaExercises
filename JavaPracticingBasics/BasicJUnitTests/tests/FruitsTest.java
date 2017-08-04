import org.junit.Test;

import static org.junit.Assert.*;

public class FruitsTest {
    @Test
    public void getFruits() throws Exception {
        Fruits testFruit = new Fruits("Strawberry");
        assertEquals("Strawberry", testFruit.getFruits());
    }

}