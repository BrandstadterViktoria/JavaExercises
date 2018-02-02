package Stack;
public class MinStack {
    private int [] arrayForStack;
    private int top = -1;

    public MinStack() {
        arrayForStack = new int [10];
    }

    public void push(int x) {
     if(top > -1 && x < arrayForStack[top]){
         arrayForStack[top -1] = x;
         ++ top;
     }else {
         arrayForStack[top] = x;
         ++ top;
     }

    }

    public void pop() {
        -- top;
    }

    public int top() {
        return arrayForStack.length;
    }

    public int getMin() {
        int min = arrayForStack[top];
        return min;
    }

}
