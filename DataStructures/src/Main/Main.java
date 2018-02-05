package Main;

import Stack.MinStack;

import static Queue.QueueImplementation.checkForPalindrome;

public  class Main {
    public static void main(String[] args) {

        /*Employee Mary = new Employee("Mary",56);
        Employee Jackie = new Employee("Jackie",45);
        Employee Bonie = new Employee("Bonie",67);
        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        list.addToTheFront(Mary);
        list.addToTheFront(Jackie);
        list.print();

        list.addBefore(Bonie,Mary);
        list.print();*/
/*
        IntegerSinglyLinkedList list = new IntegerSinglyLinkedList();
        list.addToTheListInSortedOrder(4);
        list.addToTheListInSortedOrder(2);
        list.addToTheListInSortedOrder(1);
        list.addToTheListInSortedOrder(5);
        list.print();*/

        /*MyStack palindrome = new MyStack("I did, did I?");
        for (char character : palindrome.getWord().toCharArray()) {
            palindrome.push(character);
        }
        palindrome.print();
        System.out.println(palindrome.isItAPalindrome(palindrome.getWord()));*/

        // should return true
        /*System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));*/

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("This is minimum:     " + minStack.getMin());  // --> Returns -3.
        minStack.pop();
        System.out.println("This is top after remove     " + minStack.top());     // --> Returns 0.
        System.out.println("This is minimum after remove:     " + minStack.getMin());   //--> Returns -2.
    }

    }



