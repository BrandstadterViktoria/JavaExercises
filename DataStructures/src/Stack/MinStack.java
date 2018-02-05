package Stack;
public class MinStack {
    private int [] arrayForStack;
    private int top;

    public MinStack() {
        arrayForStack = new int [10];
    }

    public void push(int x) {
         if(top == 0 || top > 0 && x > arrayForStack[top -1]){
             arrayForStack[top] = x;
             ++top;
         }
        else if ((top > 0 && x <= arrayForStack[top -1])) {
             int current;
             int i;
            for (i = top -1; i >= 0 ; i--) {
                if (arrayForStack[i] > x) {
                   current = arrayForStack[i];
                   arrayForStack[i +1] = current;
                    continue;
                }
            }
             arrayForStack[i + 1] = x;
             ++top;
        }
    }

    public void pop() {
        -- top;
    }

    public int top() {
        return arrayForStack.length;
    }

    public int getMin() {
        int min = arrayForStack[0];
        return min;
    }

}
