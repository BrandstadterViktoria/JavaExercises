import org.junit.Assert;
import org.junit.Test;

public class FibonacciSequenceTest {
    @Test
    public void setFibonacciTester() throws Exception {
        Assert.assertEquals(8, FibonacciSequence.setFibonacci(10)[6]);
    }


}