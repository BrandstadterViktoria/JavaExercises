package Stack;

import java.util.EmptyStackException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyStack {
    /*Implementation of a palindrome decider in stack*/

    private String word;
    private int top;
    private char[] stack;
    private Integer [] intStack;

    public MyStack(String word) {
        Pattern pattern = Pattern.compile("[^a-z A-Z]");
        Matcher matcher = pattern.matcher(word);
        word = matcher.replaceAll("").toLowerCase().replaceAll("\\s+", "");
        this.word = word;
        stack = new char[word.length()];
    }

    public MyStack(){

    }

    public void push(char chaarcterOfTheWord) {
        stack[top++] = chaarcterOfTheWord;

    }
    public void push(int number) {
        intStack[top++] = number;

    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Integer toPop = intStack[--top];
        return toPop;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void print() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);

        }
    }

    public int peek() {
        return intStack[top - 1];
    }

    public boolean isItAPalindrome(String input) {
        Pattern pattern = Pattern.compile("[^a-z A-Z]");
        Matcher matcher = pattern.matcher(input);
        String string = matcher.replaceAll("");
        char[] characters = string.trim().toLowerCase().toCharArray();
        for (int i = 0; i < characters.length - 1; i++) {
            if (characters[i] == stack[top - 1]) {
                top--;
            } else {
                return false;

            }
        }
        return true;
    }

    public String getWord() {
        return word;
    }



}







