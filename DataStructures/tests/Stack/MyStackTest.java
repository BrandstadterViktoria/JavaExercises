package Stack;

import org.junit.Assert;
import org.junit.Test;

public class MyStackTest {
    @Test
    public void isItAPalindrome_test1() throws Exception {
        MyStack test1 = new MyStack("abccba");
        for (char character : test1.getWord().toCharArray()) {
            test1.push(character);
        }
        Assert.assertTrue(test1.isItAPalindrome(test1.getWord()));
    }

    @Test
    public void isItAPalindrome_test2() throws Exception {
        MyStack test2 = new MyStack("Was it a car or a cat I saw?");
        for (char character : test2.getWord().toCharArray()) {
            test2.push(character);
        }
        Assert.assertTrue(test2.isItAPalindrome(test2.getWord()));
    }

    @Test
    public void isItAPalindrome_test3() throws Exception {
        MyStack test3 = new MyStack("I did, did I?");
        for (char character : test3.getWord().toCharArray()) {
            test3.push(character);
        }
        Assert.assertTrue(test3.isItAPalindrome(test3.getWord()));

    }

    @Test
    public void isItAPalindrome_test4() throws Exception {
        MyStack test4 = new MyStack("hello");
        for (char character : test4.getWord().toCharArray()) {
            test4.push(character);
        }
        Assert.assertFalse(test4.isItAPalindrome(test4.getWord()));
    }

    @Test
    public void isItAPalindrome_test5() throws Exception {
        MyStack test5 = new MyStack("Don't nod");
        for (char character : test5.getWord().toCharArray()) {
            test5.push(character);
        }
        Assert.assertTrue(test5.isItAPalindrome(test5.getWord()));
    }

}