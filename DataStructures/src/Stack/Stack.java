package Stack;

public class Stack {
    /*Implementation of a palindrome decider in stack*/

    private String word;
    private int top;
    private char [] stack;

    public Stack(String word){
        this.word = word;
        stack = new char[word.length()];
    }

    public void push(char chaarcterOfTheWord){
       stack[top ++] = chaarcterOfTheWord;

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public char[] getStack() {
        return stack;
    }

    public void setStack(char[] stack) {
        this.stack = stack;
    }

    public void print(){
        for (int i = top -1; i >= 0 ; i--) {
            System.out.println(stack[i]);

        }
    }
}




