package linkedList;

import Stack.Stack;

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

        Stack palindrome = new Stack("alla");
        for (char character : palindrome.getWord().toCharArray()) {
            palindrome.push(character);
        }

        palindrome.print();
    }


}
