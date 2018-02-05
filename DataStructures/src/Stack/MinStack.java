package Stack;
public class MinStack {
    private int [] arrayForStack;
    private int top = 0;
    private int arrayActualLength = 0;

    public MinStack() {
        arrayForStack = new int [10];
    }

    public void push(int x) {
         if(top == 0 || arrayActualLength > 0 && x > arrayForStack[arrayActualLength -1]){
             arrayForStack[top] = x;
             arrayActualLength ++;
         }
        else if ((arrayActualLength > 0 && x <= arrayForStack[arrayActualLength -1])) {
             int current;
             int i;
            for (i = arrayActualLength -1; i >= 0 ; i--) {
                if (arrayForStack[i] > x) {
                   current = arrayForStack[i];
                   arrayForStack[i +1] = current;
                    continue;
                }
            }
             arrayForStack[i + 1] = x;
            arrayActualLength ++;
        }
    }

    public void pop() {
        ++ top;
    }

    public int top() {
        return arrayForStack[top];
    }

    public int getMin() {
        int min = arrayForStack[top];
        return min;
    }

}
