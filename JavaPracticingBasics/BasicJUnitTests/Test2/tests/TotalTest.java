import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TotalTest {
    @Test
    public void total() throws Exception {
        Total testTotal = new Total();
        ArrayList <Integer> testList = new ArrayList<>();
        for (int i = 1; i <10; i++) {
            testList.add(i);
        }
        assertEquals(44,testTotal.total(testList));
    }

}