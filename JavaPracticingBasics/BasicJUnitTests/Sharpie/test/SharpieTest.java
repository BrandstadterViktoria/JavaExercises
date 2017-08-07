import org.junit.Assert;
import org.junit.Test;

public class SharpieTest {
    Sharpie testSharpie = new Sharpie("white", 4.5f);

    @Test
    public void getInkAmountTest() throws Exception {
        Assert.assertEquals( 99f, testSharpie.getInkAmount(), 0.5f);
    }

    @Test
    public void getColorTest() throws Exception {
        Assert.assertEquals("white", testSharpie.getColor());
    }

    @Test
    public void getWidhtTest() throws Exception {
        Assert.assertEquals(4.5f, testSharpie.getWidht(), 0.5f);
    }
}



