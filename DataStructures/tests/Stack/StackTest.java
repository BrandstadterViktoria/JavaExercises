package Stack;

import org.junit.Test;

public class StackTest {
    @Test
    public void isItAPalindrome_test1() throws Exception {
        Stack test1 = new Stack("abccba");
        for (char character : test1.getWord().toCharArray()) {
            test1.push(character);
        }
    }

    @Test
    public void isItAPalindrome_test2() throws Exception {
            Stack test2 = new Stack("Was it a car or a cat I saw?");
            for (char character : test2.getWord().toCharArray()) {
                test2.push(character);
        }
    }

    @Test
    public void isItAPalindrome_test3() throws Exception {
        Stack test3 = new Stack("I did, did I?");
        for (char character : test3.getWord().toCharArray()) {
            test3.push(character);
        }

    }
    @Test
    public void isItAPalindrome_test4() throws Exception {
        Stack test4 = new Stack("hello");
        for (char character : test4.getWord().toCharArray()) {
            test4.push(character);
        }
    }
    @Test
    public void isItAPalindrome_test5() throws Exception {
        Stack test5 = new Stack("Don't nod");
        for (char character : test5.getWord().toCharArray()) {
            test5.push(character);
        }
    }

}