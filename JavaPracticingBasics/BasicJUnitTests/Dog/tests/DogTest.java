import org.junit.Assert;
import org.junit.Test;

public class DogTest {
    Dog testDog = new Dog ();

    @Test
    public void eatTest() throws Exception {
        testDog.eat();
        Assert.assertEquals(49,testDog.getHunger());
    }

    @Test
    public void drinkTest() throws Exception {
        testDog.drink();
        Assert.assertEquals(49,testDog.getThirst());
    }

    @Test
    public void playTest() throws Exception {
        testDog.play();
        Assert.assertEquals(51,testDog.getThirst());
        Assert.assertEquals(51,testDog.getHunger());
    }

}

