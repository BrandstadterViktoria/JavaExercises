package linkedList;

import Stack.MyStack;

public  class Main {
    public static void main(String[] args) {

      /*  Employee Mary = new Employee("Mary",56);
        Employee Jackie = new Employee("Jackie",45);
        Employee Bonie = new Employee("Bonie",67);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        list.addtoTheFront(Mary);
        list.addtoTheFront(Jackie);
        list.addtoTheFront(Bonie);
        list.print();*/

        MyStack palindrome = new MyStack("I did, did I?");
        for (char character : palindrome.getWord().toCharArray()) {
            palindrome.push(character);
        }
        palindrome.print();
        System.out.println(palindrome.isItAPalindrome(palindrome.getWord()));


    }

}
